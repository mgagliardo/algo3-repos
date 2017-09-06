package appModel;

import ar.tp.dieta.ContadorConsultas;
import ar.tp.dieta.CriterioBusqueda;
import ar.tp.dieta.Filtro;
import ar.tp.dieta.PosteriorBusquedaDiezPrimeros;
import ar.tp.dieta.Receta;
import ar.tp.dieta.RecetaBuilder;
import ar.tp.dieta.RecetaCliente;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class PantallaPrincipalAplicationModel {
  private CriterioBusqueda busquedaUsuario = new CriterioBusqueda();
  
  private Receta recetaSeleccionada;
  
  private ContadorConsultas accion = new ContadorConsultas();
  
  private List<Receta> recetas = new ArrayList<Receta>();
  
  private Usuario usuario;
  
  private String mensaje;
  
  private Filtro filtroPrimeras;
  
  private List<String> dificultades;
  
  private List<String> temporadas;
  
  public PantallaPrincipalAplicationModel(final Usuario parametroUsuario) {
    PosteriorBusquedaDiezPrimeros _posteriorBusquedaDiezPrimeros = new PosteriorBusquedaDiezPrimeros();
    this.filtroPrimeras = _posteriorBusquedaDiezPrimeros;
    RecetaBuilder _recetaBuilder = new RecetaBuilder("a");
    List<String> _dificultades = _recetaBuilder.getDificultades();
    this.dificultades = _dificultades;
    RecetaBuilder _recetaBuilder_1 = new RecetaBuilder("a");
    List<String> _temporadas = _recetaBuilder_1.getTemporadas();
    this.temporadas = _temporadas;
    this.usuario = parametroUsuario;
    this.establecerRecetas();
  }
  
  public List<Receta> establecerRecetas() {
    List<Receta> _xifexpression = null;
    List<Receta> _recetasFavoritas2 = this.usuario.getRecetasFavoritas2();
    boolean _isEmpty = _recetasFavoritas2.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List<Receta> _xblockexpression = null;
      {
        this.mensaje = "Estas son sus recetas favoritas";
        List<Receta> _recetasFavoritas2_1 = this.usuario.getRecetasFavoritas2();
        List<Receta> _aplicarFiltroUsuario = this.filtroPrimeras.aplicarFiltroUsuario(this.usuario, _recetasFavoritas2_1);
        _xblockexpression = this.recetas = _aplicarFiltroUsuario;
      }
      _xifexpression = _xblockexpression;
    } else {
      List<Receta> _xifexpression_1 = null;
      List<Receta> _recetasBuscadas = this.usuario.getRecetasBuscadas();
      boolean _isEmpty_1 = _recetasBuscadas.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        List<Receta> _xblockexpression_1 = null;
        {
          this.mensaje = "Este es el resultado de su ultima consulta";
          List<Receta> _busquedaFiltrada = this.usuario.busquedaFiltrada();
          List<Receta> _aplicarFiltroUsuario = this.filtroPrimeras.aplicarFiltroUsuario(this.usuario, _busquedaFiltrada);
          _xblockexpression_1 = this.recetas = _aplicarFiltroUsuario;
        }
        _xifexpression_1 = _xblockexpression_1;
      } else {
        List<Receta> _xblockexpression_2 = null;
        {
          this.mensaje = "Estas son las recetas mas consultadas";
          ContadorConsultas _observerConsulta = this.usuario.getObserverConsulta();
          List<Receta> _recetasFinales = _observerConsulta.getRecetasFinales();
          List<Receta> _aplicarFiltroUsuario = this.filtroPrimeras.aplicarFiltroUsuario(this.usuario, _recetasFinales);
          _xblockexpression_2 = this.recetas = _aplicarFiltroUsuario;
        }
        _xifexpression_1 = _xblockexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public boolean limpiarRecetas() {
    return CollectionExtensions.<Receta>removeAll(this.recetas);
  }
  
  public void filtrar() {
    this.mensaje = "Estas son sus recetas buscadas";
    List<Receta> _recetasQuePuedoVer = this.usuario.recetasQuePuedoVer();
    List<Receta> _filtrar = this.busquedaUsuario.filtrar(this.usuario, _recetasQuePuedoVer);
    this.recetas = _filtrar;
    ContadorConsultas _observerConsulta = this.usuario.getObserverConsulta();
    _observerConsulta.seRealizoBusqueda(this.recetas);
    this.usuario.agregarRecetasBuscadas(this.recetas);
  }
  
  public void agregarORemoverRecetaFavorita(final Receta receta) {
    List<Receta> _recetasFavoritas2 = this.usuario.getRecetasFavoritas2();
    boolean _contains = _recetasFavoritas2.contains(receta);
    if (_contains) {
      this.usuario.eliminarRecetaFavorita(receta);
    } else {
      this.usuario.agregarRecetaFavorita(receta);
    }
  }
  
  public Receta devolverReceta(final String nombreReceta) {
    return this.usuario.buscarRecetaPorNombre(nombreReceta);
  }
  
  public CriterioBusqueda limpiarCriterioBusqueda() {
    CriterioBusqueda _criterioBusqueda = new CriterioBusqueda();
    return this.busquedaUsuario = _criterioBusqueda;
  }
  
  public RecetaCliente recetasCliente() {
    return new RecetaCliente(this.mensaje, this.recetas, this.usuario, this.dificultades, this.temporadas);
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
  public String getMensaje() {
    return this.mensaje;
  }
  
  public void setMensaje(final String mensaje) {
    this.mensaje = mensaje;
  }
  
  @Pure
  public Filtro getFiltroPrimeras() {
    return this.filtroPrimeras;
  }
  
  public void setFiltroPrimeras(final Filtro filtroPrimeras) {
    this.filtroPrimeras = filtroPrimeras;
  }
  
  @Pure
  public List<String> getDificultades() {
    return this.dificultades;
  }
  
  public void setDificultades(final List<String> dificultades) {
    this.dificultades = dificultades;
  }
  
  @Pure
  public List<String> getTemporadas() {
    return this.temporadas;
  }
  
  public void setTemporadas(final List<String> temporadas) {
    this.temporadas = temporadas;
  }
}
