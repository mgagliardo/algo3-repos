package pantallaPrincipal;

import ar.tp.dieta.Busqueda;
import ar.tp.dieta.ContadorConsultas;
import ar.tp.dieta.CriterioBusqueda;
import ar.tp.dieta.Filtro;
import ar.tp.dieta.FiltroPorGustos;
import ar.tp.dieta.FiltroPorIngredienteCaro;
import ar.tp.dieta.PosteriorBusquedaDiezPrimeros;
import ar.tp.dieta.PosteriorBusquedaOrdenadoCalorias;
import ar.tp.dieta.Receta;
import ar.tp.dieta.RecetarioPublico;
import ar.tp.dieta.RutinaActiva;
import ar.tp.dieta.TestRepositorio;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class PantallaPrincipalAplicationModel extends TestRepositorio {
  private CriterioBusqueda busquedaUsuario = new CriterioBusqueda();
  
  private Receta recetaSeleccionada;
  
  private ContadorConsultas accion = new ContadorConsultas();
  
  private List<Receta> recetas = new ArrayList<Receta>();
  
  private Usuario usuario;
  
  private RecetarioPublico recetario = new RecetarioPublico();
  
  private String mensaje;
  
  private Busqueda busqueda1 = ObjectExtensions.<Busqueda>operator_doubleArrow(new Busqueda(), new Procedure1<Busqueda>() {
    @Override
    public void apply(final Busqueda it) {
      FiltroPorIngredienteCaro _filtroPorIngredienteCaro = new FiltroPorIngredienteCaro();
      it.agregarFiltro(_filtroPorIngredienteCaro);
    }
  });
  
  private Busqueda busqueda2 = ObjectExtensions.<Busqueda>operator_doubleArrow(new Busqueda(), new Procedure1<Busqueda>() {
    @Override
    public void apply(final Busqueda it) {
      PosteriorBusquedaOrdenadoCalorias _posteriorBusquedaOrdenadoCalorias = new PosteriorBusquedaOrdenadoCalorias();
      it.agregarFiltro(_posteriorBusquedaOrdenadoCalorias);
    }
  });
  
  private Busqueda busqueda3 = ObjectExtensions.<Busqueda>operator_doubleArrow(new Busqueda(), new Procedure1<Busqueda>() {
    @Override
    public void apply(final Busqueda it) {
      FiltroPorGustos _filtroPorGustos = new FiltroPorGustos();
      it.agregarFiltro(_filtroPorGustos);
    }
  });
  
  private Filtro filtroPrimeras = new PosteriorBusquedaDiezPrimeros();
  
  public PantallaPrincipalAplicationModel(final Usuario parametroUsuario) {
    this.usuario = parametroUsuario;
    RutinaActiva _rutinaActiva = new RutinaActiva();
    final Procedure1<RutinaActiva> _function = new Procedure1<RutinaActiva>() {
      @Override
      public void apply(final RutinaActiva it) {
        it.setTiempoDeEjercicio(240);
      }
    };
    RutinaActiva _doubleArrow = ObjectExtensions.<RutinaActiva>operator_doubleArrow(_rutinaActiva, _function);
    this.basket = _doubleArrow;
    List<Receta> _establecerRecetas = this.establecerRecetas();
    this.recetas.addAll(_establecerRecetas);
  }
  
  public List<Receta> establecerRecetas() {
    List<Receta> _recetasFavoritas2 = this.usuario.getRecetasFavoritas2();
    boolean _isEmpty = _recetasFavoritas2.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.mensaje = "Estas son sus recetas favoritas";
      List<Receta> _recetasFavoritas2_1 = this.usuario.getRecetasFavoritas2();
      return this.filtroPrimeras.aplicarFiltroUsuario(this.usuario, _recetasFavoritas2_1);
    } else {
      List<Receta> _recetasBuscadas = this.usuario.getRecetasBuscadas();
      boolean _isEmpty_1 = _recetasBuscadas.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        this.mensaje = "Este es el resultado de su ultima consulta";
        List<Receta> _recetasBuscadas_1 = this.usuario.getRecetasBuscadas();
        return this.filtroPrimeras.aplicarFiltroUsuario(this.usuario, _recetasBuscadas_1);
      } else {
        this.mensaje = "Estas son las recetas mas consultadas";
        ContadorConsultas _observerConsulta = this.usuario.getObserverConsulta();
        List<Receta> _recetasFinales = _observerConsulta.getRecetasFinales();
        return this.filtroPrimeras.aplicarFiltroUsuario(this.usuario, _recetasFinales);
      }
    }
  }
  
  public boolean limpiarRecetas() {
    return CollectionExtensions.<Receta>removeAll(this.recetas);
  }
  
  public void agregarORemoverRecetaFavorita() {
    List<Receta> _recetasFavoritas2 = this.usuario.getRecetasFavoritas2();
    boolean _contains = _recetasFavoritas2.contains(this.recetaSeleccionada);
    if (_contains) {
      this.usuario.eliminarRecetaFavorita(this.recetaSeleccionada);
    } else {
      this.usuario.agregarRecetaFavorita(this.recetaSeleccionada);
    }
  }
  
  public void filtrar() {
    List<Receta> _recetasQuePuedoVer = this.usuario.recetasQuePuedoVer();
    List<Receta> _filtrar = this.busquedaUsuario.filtrar(this.usuario, _recetasQuePuedoVer);
    this.recetas = _filtrar;
    ContadorConsultas _observerConsulta = this.usuario.getObserverConsulta();
    _observerConsulta.seRealizoBusqueda(this.recetas);
    this.usuario.agregarRecetasBuscadas(this.recetas);
  }
  
  @Pure
  public CriterioBusqueda getBusquedaUsuario() {
    return this.busquedaUsuario;
  }
  
  public void setBusquedaUsuario(final CriterioBusqueda busquedaUsuario) {
    this.busquedaUsuario = busquedaUsuario;
  }
  
  @Pure
  public Receta getRecetaSeleccionada() {
    return this.recetaSeleccionada;
  }
  
  public void setRecetaSeleccionada(final Receta recetaSeleccionada) {
    this.recetaSeleccionada = recetaSeleccionada;
  }
  
  @Pure
  public ContadorConsultas getAccion() {
    return this.accion;
  }
  
  public void setAccion(final ContadorConsultas accion) {
    this.accion = accion;
  }
  
  @Pure
  public List<Receta> getRecetas() {
    return this.recetas;
  }
  
  public void setRecetas(final List<Receta> recetas) {
    this.recetas = recetas;
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
  
  @Pure
  public RecetarioPublico getRecetario() {
    return this.recetario;
  }
  
  public void setRecetario(final RecetarioPublico recetario) {
    this.recetario = recetario;
  }
  
  @Pure
  public String getMensaje() {
    return this.mensaje;
  }
  
  public void setMensaje(final String mensaje) {
    this.mensaje = mensaje;
  }
  
  @Pure
  public Busqueda getBusqueda1() {
    return this.busqueda1;
  }
  
  public void setBusqueda1(final Busqueda busqueda1) {
    this.busqueda1 = busqueda1;
  }
  
  @Pure
  public Busqueda getBusqueda2() {
    return this.busqueda2;
  }
  
  public void setBusqueda2(final Busqueda busqueda2) {
    this.busqueda2 = busqueda2;
  }
  
  @Pure
  public Busqueda getBusqueda3() {
    return this.busqueda3;
  }
  
  public void setBusqueda3(final Busqueda busqueda3) {
    this.busqueda3 = busqueda3;
  }
  
  @Pure
  public Filtro getFiltroPrimeras() {
    return this.filtroPrimeras;
  }
  
  public void setFiltroPrimeras(final Filtro filtroPrimeras) {
    this.filtroPrimeras = filtroPrimeras;
  }
}
