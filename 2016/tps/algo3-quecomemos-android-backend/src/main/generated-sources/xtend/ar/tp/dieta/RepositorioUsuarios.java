package ar.tp.dieta;

import ar.tp.dieta.Busqueda;
import ar.tp.dieta.CondicionCeliaco;
import ar.tp.dieta.CondicionHipertension;
import ar.tp.dieta.CondicionVegano;
import ar.tp.dieta.ContadorConsultas;
import ar.tp.dieta.FiltroPorIngredienteCaro;
import ar.tp.dieta.Ingrediente;
import ar.tp.dieta.IngredienteBuilder;
import ar.tp.dieta.RecetarioPublico;
import ar.tp.dieta.RepoRecetas;
import ar.tp.dieta.RutinaActiva;
import ar.tp.dieta.Usuario;
import ar.tp.dieta.UsuarioBuilder;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepositorioUsuarios extends RepoRecetas {
  private static RepositorioUsuarios instance;
  
  private List<Usuario> usuarios;
  
  private ContadorConsultas observer = new ContadorConsultas();
  
  private RecetarioPublico recetario = new RecetarioPublico();
  
  private RutinaActiva basket = new RutinaActiva();
  
  public Usuario juan;
  
  public Usuario gabriel;
  
  public Usuario miguel;
  
  public Usuario carlos;
  
  public Usuario manuel;
  
  public Usuario daniel;
  
  public Usuario tempUser;
  
  private Busqueda busquedaFiltrada = new Busqueda();
  
  public RepositorioUsuarios() {
    FiltroPorIngredienteCaro _filtroPorIngredienteCaro = new FiltroPorIngredienteCaro();
    this.busquedaFiltrada.agregarFiltro(_filtroPorIngredienteCaro);
    ArrayList<Usuario> _arrayList = new ArrayList<Usuario>();
    this.usuarios = _arrayList;
    this.basket.setTiempoDeEjercicio(240);
    UsuarioBuilder _usuarioBuilder = new UsuarioBuilder("Gabriel", "gabriel");
    UsuarioBuilder _peso = _usuarioBuilder.peso(Double.valueOf(90.5));
    UsuarioBuilder _altura = _peso.altura(Double.valueOf(1.90));
    UsuarioBuilder _fechaNacimiento = _altura.fechaNacimiento(1985, 6, 12);
    UsuarioBuilder _sexo = _fechaNacimiento.sexo("M");
    CondicionCeliaco _condicionCeliaco = new CondicionCeliaco();
    UsuarioBuilder _condicion = _sexo.condicion(_condicionCeliaco);
    UsuarioBuilder _preferencia = _condicion.preferencia("fruta");
    UsuarioBuilder _email = _preferencia.email("gabriel@edrans.com");
    Usuario _build = _email.build();
    this.gabriel = _build;
    UsuarioBuilder _usuarioBuilder_1 = new UsuarioBuilder("Manuel", "manuel");
    UsuarioBuilder _peso_1 = _usuarioBuilder_1.peso(Double.valueOf(120.5));
    UsuarioBuilder _altura_1 = _peso_1.altura(Double.valueOf(1.85));
    UsuarioBuilder _fechaNacimiento_1 = _altura_1.fechaNacimiento(1982, 1, 25);
    UsuarioBuilder _sexo_1 = _fechaNacimiento_1.sexo("M");
    UsuarioBuilder _rutina = _sexo_1.rutina(this.basket);
    CondicionVegano _condicionVegano = new CondicionVegano();
    UsuarioBuilder _condicion_1 = _rutina.condicion(_condicionVegano);
    UsuarioBuilder _preferencia_1 = _condicion_1.preferencia("carne");
    UsuarioBuilder _email_1 = _preferencia_1.email("manuel@edrans.com");
    Usuario _build_1 = _email_1.build();
    this.manuel = _build_1;
    UsuarioBuilder _usuarioBuilder_2 = new UsuarioBuilder("Miguel", "miguel");
    UsuarioBuilder _peso_2 = _usuarioBuilder_2.peso(Double.valueOf(70.5));
    UsuarioBuilder _altura_2 = _peso_2.altura(Double.valueOf(1.73));
    UsuarioBuilder _fechaNacimiento_2 = _altura_2.fechaNacimiento(1989, 5, 18);
    UsuarioBuilder _sexo_2 = _fechaNacimiento_2.sexo("M");
    CondicionHipertension _condicionHipertension = new CondicionHipertension();
    UsuarioBuilder _condicion_2 = _sexo_2.condicion(_condicionHipertension);
    UsuarioBuilder _preferencia_2 = _condicion_2.preferencia("fruta");
    UsuarioBuilder _email_2 = _preferencia_2.email("miguel@edrans.com");
    Usuario _build_2 = _email_2.build();
    this.miguel = _build_2;
    UsuarioBuilder _usuarioBuilder_3 = new UsuarioBuilder("Daniel", "daniel");
    UsuarioBuilder _peso_3 = _usuarioBuilder_3.peso(Double.valueOf(100.5));
    UsuarioBuilder _altura_3 = _peso_3.altura(Double.valueOf(1.95));
    UsuarioBuilder _fechaNacimiento_3 = _altura_3.fechaNacimiento(1995, 6, 28);
    UsuarioBuilder _sexo_3 = _fechaNacimiento_3.sexo("M");
    UsuarioBuilder _rutina_1 = _sexo_3.rutina(this.basket);
    UsuarioBuilder _preferencia_3 = _rutina_1.preferencia("pescado");
    UsuarioBuilder _email_3 = _preferencia_3.email("daniel@edrans.com");
    Usuario _build_3 = _email_3.build();
    this.daniel = _build_3;
    UsuarioBuilder _usuarioBuilder_4 = new UsuarioBuilder("Juan", "juan");
    UsuarioBuilder _peso_4 = _usuarioBuilder_4.peso(Double.valueOf(75.5));
    UsuarioBuilder _altura_4 = _peso_4.altura(Double.valueOf(1.87));
    UsuarioBuilder _fechaNacimiento_4 = _altura_4.fechaNacimiento(1993, 1, 28);
    UsuarioBuilder _sexo_4 = _fechaNacimiento_4.sexo("M");
    UsuarioBuilder _preferencia_4 = _sexo_4.preferencia("fruta");
    UsuarioBuilder _email_4 = _preferencia_4.email("juan@edrans.com");
    Usuario _build_4 = _email_4.build();
    this.juan = _build_4;
    this.usuarios.add(this.gabriel);
    this.usuarios.add(this.miguel);
    this.usuarios.add(this.manuel);
    this.usuarios.add(this.juan);
    this.usuarios.add(this.daniel);
    this.daniel.agregarRecetaFavorita(this.ensalada);
    final Consumer<Usuario> _function = new Consumer<Usuario>() {
      public void accept(final Usuario usuario) {
        usuario.setObserverConsulta(RepositorioUsuarios.this.observer);
      }
    };
    this.usuarios.forEach(_function);
    final Consumer<Usuario> _function_1 = new Consumer<Usuario>() {
      public void accept(final Usuario usuario) {
        usuario.setRecetario(RepositorioUsuarios.this.recetarioPublico);
      }
    };
    this.usuarios.forEach(_function_1);
    IngredienteBuilder _ingredienteBuilder = new IngredienteBuilder("carne");
    IngredienteBuilder _cantidad = _ingredienteBuilder.cantidad(500);
    Ingrediente _build_5 = _cantidad.build();
    IngredienteBuilder _ingredienteBuilder_1 = new IngredienteBuilder("papa");
    IngredienteBuilder _cantidad_1 = _ingredienteBuilder_1.cantidad(300);
    Ingrediente _build_6 = _cantidad_1.build();
    this.miguel.crearReceta("Pastel de papa", 1500, "Gabriel", "Mediana", "Hervir la papa, sellar la carne picada, mezclar ambas en una fuente y poner durante 40 minutos en el horno", "Todo el año", _build_5, _build_6);
    IngredienteBuilder _ingredienteBuilder_2 = new IngredienteBuilder("fideos");
    IngredienteBuilder _cantidad_2 = _ingredienteBuilder_2.cantidad(200);
    Ingrediente _build_7 = _cantidad_2.build();
    IngredienteBuilder _ingredienteBuilder_3 = new IngredienteBuilder("tomate");
    IngredienteBuilder _cantidad_3 = _ingredienteBuilder_3.cantidad(300);
    Ingrediente _build_8 = _cantidad_3.build();
    this.miguel.crearReceta("Fideos con Tuco", 400, "Gabriel", "Facil", "Hervir los fideos, mezclar con la salsa de tomate caliente.", "Todo el año", _build_7, _build_8);
    this.daniel.agregarRecetaFavorita(this.ensalada);
    this.daniel.agregarRecetaFavorita(this.asado);
    IngredienteBuilder _ingredienteBuilder_4 = new IngredienteBuilder("bizcochuelo");
    IngredienteBuilder _cantidad_4 = _ingredienteBuilder_4.cantidad(300);
    Ingrediente _build_9 = _cantidad_4.build();
    IngredienteBuilder _ingredienteBuilder_5 = new IngredienteBuilder("azucar");
    IngredienteBuilder _cantidad_5 = _ingredienteBuilder_5.cantidad(250);
    Ingrediente _build_10 = _cantidad_5.build();
    this.manuel.crearReceta("Bizcochuelo", 600, "Manuel", "Facil", "Mezclar un sobre de exquisita con leche. Hornear con horno al maximo durante 40 minutos", "Todo el año", _build_9, _build_10);
    IngredienteBuilder _ingredienteBuilder_6 = new IngredienteBuilder("Queso");
    IngredienteBuilder _cantidad_6 = _ingredienteBuilder_6.cantidad(50);
    Ingrediente _build_11 = _cantidad_6.build();
    IngredienteBuilder _ingredienteBuilder_7 = new IngredienteBuilder("Dulce de Membrillo");
    IngredienteBuilder _cantidad_7 = _ingredienteBuilder_7.cantidad(50);
    Ingrediente _build_12 = _cantidad_7.build();
    this.manuel.crearReceta("Vigilante", 300, "Manuel", "Facil", "Cortar una feta de queso y una del dulce que mas te guste, comer ambos juntos.", "Todo el año", _build_11, _build_12);
    Usuario _get = this.usuarios.get(1);
    _get.agregarBusqueda(this.busquedaFiltrada);
    Usuario _get_1 = this.usuarios.get(1);
    _get_1.busquedaFiltrada();
  }
  
  public Usuario validarLogin(final String username, final String password) {
    return this.buscarUsuario(username, password);
  }
  
  public Usuario buscarUsuario(final String user, final String key) {
    this.tempUser = null;
    final Consumer<Usuario> _function = new Consumer<Usuario>() {
      public void accept(final Usuario usuario) {
        boolean _and = false;
        String _nombre = usuario.getNombre();
        boolean _equals = _nombre.equals(user);
        if (!_equals) {
          _and = false;
        } else {
          String _contrasenia = usuario.getContrasenia();
          boolean _equals_1 = _contrasenia.equals(key);
          _and = _equals_1;
        }
        if (_and) {
          RepositorioUsuarios.this.tempUser = usuario;
        }
      }
    };
    this.usuarios.forEach(_function);
    boolean _notEquals = (!Objects.equal(this.tempUser, null));
    if (_notEquals) {
      return this.tempUser;
    } else {
      throw new RuntimeException("Usuario y/o contraseña incorrectos");
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
  
  @Pure
  public RutinaActiva getBasket() {
    return this.basket;
  }
  
  public void setBasket(final RutinaActiva basket) {
    this.basket = basket;
  }
  
  @Pure
  public Usuario getJuan() {
    return this.juan;
  }
  
  public void setJuan(final Usuario juan) {
    this.juan = juan;
  }
  
  @Pure
  public Usuario getGabriel() {
    return this.gabriel;
  }
  
  public void setGabriel(final Usuario gabriel) {
    this.gabriel = gabriel;
  }
  
  @Pure
  public Usuario getMiguel() {
    return this.miguel;
  }
  
  public void setMiguel(final Usuario miguel) {
    this.miguel = miguel;
  }
  
  @Pure
  public Usuario getCarlos() {
    return this.carlos;
  }
  
  public void setCarlos(final Usuario carlos) {
    this.carlos = carlos;
  }
  
  @Pure
  public Usuario getManuel() {
    return this.manuel;
  }
  
  public void setManuel(final Usuario manuel) {
    this.manuel = manuel;
  }
  
  @Pure
  public Usuario getDaniel() {
    return this.daniel;
  }
  
  public void setDaniel(final Usuario daniel) {
    this.daniel = daniel;
  }
  
  @Pure
  public Usuario getTempUser() {
    return this.tempUser;
  }
  
  public void setTempUser(final Usuario tempUser) {
    this.tempUser = tempUser;
  }
  
  @Pure
  public Busqueda getBusquedaFiltrada() {
    return this.busquedaFiltrada;
  }
  
  public void setBusquedaFiltrada(final Busqueda busquedaFiltrada) {
    this.busquedaFiltrada = busquedaFiltrada;
  }
}
