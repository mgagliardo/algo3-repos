package ar.tp.dieta;

import ar.tp.dieta.Busqueda;
import ar.tp.dieta.CondicionHipertension;
import ar.tp.dieta.CondicionVegano;
import ar.tp.dieta.ContadorConsultas;
import ar.tp.dieta.FiltroPorIngredienteCaro;
import ar.tp.dieta.Receta;
import ar.tp.dieta.RecetarioPublico;
import ar.tp.dieta.RutinaActiva;
import ar.tp.dieta.Usuario;
import ar.tp.dieta.UsuarioBuilder;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class RepositorioUsuarios {
  private List<Usuario> usuarios = new ArrayList<Usuario>();
  
  private RutinaActiva basket;
  
  private Busqueda busqueda1 = ObjectExtensions.<Busqueda>operator_doubleArrow(new Busqueda(), new Procedure1<Busqueda>() {
    @Override
    public void apply(final Busqueda it) {
      FiltroPorIngredienteCaro _filtroPorIngredienteCaro = new FiltroPorIngredienteCaro();
      it.agregarFiltro(_filtroPorIngredienteCaro);
    }
  });
  
  private ContadorConsultas observer = new ContadorConsultas();
  
  private RecetarioPublico recetario = new RecetarioPublico();
  
  public RepositorioUsuarios() {
    RutinaActiva _rutinaActiva = new RutinaActiva();
    final Procedure1<RutinaActiva> _function = new Procedure1<RutinaActiva>() {
      @Override
      public void apply(final RutinaActiva it) {
        it.setTiempoDeEjercicio(240);
      }
    };
    RutinaActiva _doubleArrow = ObjectExtensions.<RutinaActiva>operator_doubleArrow(_rutinaActiva, _function);
    this.basket = _doubleArrow;
    UsuarioBuilder _usuarioBuilder = new UsuarioBuilder("Miguel", "miguel");
    UsuarioBuilder _peso = _usuarioBuilder.peso(Double.valueOf(70.5));
    UsuarioBuilder _altura = _peso.altura(Double.valueOf(1.73));
    UsuarioBuilder _fechaNacimiento = _altura.fechaNacimiento(1989, 6, 28);
    UsuarioBuilder _sexo = _fechaNacimiento.sexo("M");
    UsuarioBuilder _rutina = _sexo.rutina(this.basket);
    CondicionVegano _condicionVegano = new CondicionVegano();
    UsuarioBuilder _condicion = _rutina.condicion(_condicionVegano);
    UsuarioBuilder _preferencia = _condicion.preferencia("fruta");
    UsuarioBuilder _email = _preferencia.email("soyvegano@edrans.com");
    Usuario _build = _email.build();
    this.usuarios.add(_build);
    UsuarioBuilder _usuarioBuilder_1 = new UsuarioBuilder("Daniel", "daniel");
    UsuarioBuilder _peso_1 = _usuarioBuilder_1.peso(Double.valueOf(70.5));
    UsuarioBuilder _altura_1 = _peso_1.altura(Double.valueOf(1.73));
    UsuarioBuilder _fechaNacimiento_1 = _altura_1.fechaNacimiento(1989, 6, 28);
    UsuarioBuilder _sexo_1 = _fechaNacimiento_1.sexo("M");
    UsuarioBuilder _rutina_1 = _sexo_1.rutina(this.basket);
    UsuarioBuilder _preferencia_1 = _rutina_1.preferencia("fruta");
    UsuarioBuilder _email_1 = _preferencia_1.email("soyvegano@edrans.com");
    Usuario _build_1 = _email_1.build();
    this.usuarios.add(_build_1);
    UsuarioBuilder _usuarioBuilder_2 = new UsuarioBuilder("Juan", "juan");
    UsuarioBuilder _peso_2 = _usuarioBuilder_2.peso(Double.valueOf(70.5));
    UsuarioBuilder _altura_2 = _peso_2.altura(Double.valueOf(1.73));
    UsuarioBuilder _fechaNacimiento_2 = _altura_2.fechaNacimiento(1989, 6, 28);
    UsuarioBuilder _sexo_2 = _fechaNacimiento_2.sexo("M");
    UsuarioBuilder _rutina_2 = _sexo_2.rutina(this.basket);
    CondicionHipertension _condicionHipertension = new CondicionHipertension();
    UsuarioBuilder _condicion_1 = _rutina_2.condicion(_condicionHipertension);
    UsuarioBuilder _preferencia_2 = _condicion_1.preferencia("fruta");
    UsuarioBuilder _email_2 = _preferencia_2.email("soyvegano@edrans.com");
    Usuario _build_2 = _email_2.build();
    this.usuarios.add(_build_2);
    Usuario _get = this.usuarios.get(0);
    List<Receta> _recetas = this.recetario.getRecetas();
    Receta _get_1 = _recetas.get(0);
    _get.agregarRecetaFavorita(_get_1);
    Usuario _get_2 = this.usuarios.get(0);
    List<Receta> _recetas_1 = this.recetario.getRecetas();
    Receta _get_3 = _recetas_1.get(1);
    _get_2.agregarRecetaFavorita(_get_3);
    final Consumer<Usuario> _function_1 = new Consumer<Usuario>() {
      @Override
      public void accept(final Usuario usuario) {
        usuario.setObserverConsulta(RepositorioUsuarios.this.observer);
      }
    };
    this.usuarios.forEach(_function_1);
    final Consumer<Usuario> _function_2 = new Consumer<Usuario>() {
      @Override
      public void accept(final Usuario usuario) {
        usuario.recetario = RepositorioUsuarios.this.recetario;
      }
    };
    this.usuarios.forEach(_function_2);
    Usuario _get_4 = this.usuarios.get(1);
    _get_4.agregarBusqueda(this.busqueda1);
  }
  
  public Usuario validarLogin(final String nombre, final String contraseña) {
    Usuario usuarioTemporal = null;
    final Function1<Usuario, Boolean> _function = new Function1<Usuario, Boolean>() {
      @Override
      public Boolean apply(final Usuario usuario) {
        boolean _and = false;
        boolean _equals = usuario.nombre.equals(nombre);
        if (!_equals) {
          _and = false;
        } else {
          String _contraseña = usuario.getContraseña();
          boolean _equals_1 = _contraseña.equals(contraseña);
          _and = _equals_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    Usuario _findFirst = IterableExtensions.<Usuario>findFirst(this.usuarios, _function);
    usuarioTemporal = _findFirst;
    boolean _equals = Objects.equal(usuarioTemporal, null);
    boolean _not = (!_equals);
    if (_not) {
      return usuarioTemporal;
    } else {
      throw new UserException("Nombre y/o Contraseña incorrectos");
    }
  }
  
  @Pure
  public List<Usuario> getUsuarios() {
    return this.usuarios;
  }
  
  public void setUsuarios(final List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }
  
  @Pure
  public RutinaActiva getBasket() {
    return this.basket;
  }
  
  public void setBasket(final RutinaActiva basket) {
    this.basket = basket;
  }
  
  @Pure
  public Busqueda getBusqueda1() {
    return this.busqueda1;
  }
  
  public void setBusqueda1(final Busqueda busqueda1) {
    this.busqueda1 = busqueda1;
  }
  
  @Pure
  public ContadorConsultas getObserver() {
    return this.observer;
  }
  
  public void setObserver(final ContadorConsultas observer) {
    this.observer = observer;
  }
  
  @Pure
  public RecetarioPublico getRecetario() {
    return this.recetario;
  }
  
  public void setRecetario(final RecetarioPublico recetario) {
    this.recetario = recetario;
  }
}
