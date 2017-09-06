package ar.tp.dieta;

import ar.tp.dieta.BusinessException;
import ar.tp.dieta.Condicion;
import ar.tp.dieta.Rutina;
import ar.tp.dieta.Usuario;
import java.util.GregorianCalendar;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class UsuarioBuilder {
  private Usuario usuario;
  
  public UsuarioBuilder(final String nombreUsuario, final String contrasenia) {
    Usuario _usuario = new Usuario();
    this.usuario = _usuario;
    this.usuario.setNombre(nombreUsuario);
    this.usuario.setContrasenia(contrasenia);
  }
  
  public UsuarioBuilder peso(final Double peso) {
    this.usuario.setPeso(peso);
    return this;
  }
  
  public UsuarioBuilder email(final String email) {
    this.usuario.setDireccionCorreo(email);
    return this;
  }
  
  public UsuarioBuilder altura(final Double altura) {
    this.usuario.setAltura(altura);
    return this;
  }
  
  public UsuarioBuilder fechaNacimiento(final int ano, final int mes, final int dia) {
    this.usuario.setFechaDeNacimiento(ano, mes, dia);
    return this;
  }
  
  public UsuarioBuilder sexo(final String sexo) {
    this.usuario.setSexo(sexo);
    return this;
  }
  
  public UsuarioBuilder rutina(final Rutina unaRutina) {
    this.usuario.setRutina(unaRutina);
    return this;
  }
  
  public UsuarioBuilder condicion(final Condicion unaCondicion) {
    this.usuario.agregarCondicion(unaCondicion);
    return this;
  }
  
  public UsuarioBuilder preferencia(final String unaPreferencia) {
    this.usuario.agregarPreferencia(unaPreferencia);
    return this;
  }
  
  protected boolean validarUsuario() {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _and_3 = false;
    boolean _and_4 = false;
    boolean _validarNombreUsuario = this.validarNombreUsuario();
    if (!_validarNombreUsuario) {
      _and_4 = false;
    } else {
      boolean _validarPesoUsuario = this.validarPesoUsuario();
      _and_4 = _validarPesoUsuario;
    }
    if (!_and_4) {
      _and_3 = false;
    } else {
      boolean _validarAlturaUsuario = this.validarAlturaUsuario();
      _and_3 = _validarAlturaUsuario;
    }
    if (!_and_3) {
      _and_2 = false;
    } else {
      boolean _validarRutinaUsuario = this.validarRutinaUsuario();
      _and_2 = _validarRutinaUsuario;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      boolean _validarFechaNacimientoUsuario = this.validarFechaNacimientoUsuario();
      _and_1 = _validarFechaNacimientoUsuario;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _condicionesValidas = this.condicionesValidas();
      _and = _condicionesValidas;
    }
    return _and;
  }
  
  protected boolean validarNombreUsuario() {
    boolean _and = false;
    boolean _equals = this.usuario.nombre.equals(null);
    if (!_equals) {
      _and = false;
    } else {
      int _length = this.usuario.nombre.length();
      boolean _lessEqualsThan = (_length <= 4);
      _and = _lessEqualsThan;
    }
    return _and;
  }
  
  protected boolean validarPesoUsuario() {
    Double _peso = this.usuario.getPeso();
    return _peso.equals(null);
  }
  
  protected boolean validarAlturaUsuario() {
    Double _altura = this.usuario.getAltura();
    return _altura.equals(null);
  }
  
  protected boolean validarFechaNacimientoUsuario() {
    boolean _and = false;
    GregorianCalendar _fechaDeNacimiento = this.usuario.getFechaDeNacimiento();
    boolean _equals = _fechaDeNacimiento.equals(null);
    if (!_equals) {
      _and = false;
    } else {
      GregorianCalendar _fechaDeNacimiento_1 = this.usuario.getFechaDeNacimiento();
      GregorianCalendar _diaDeHoy = this.getDiaDeHoy();
      int _compareTo = _fechaDeNacimiento_1.compareTo(_diaDeHoy);
      boolean _lessEqualsThan = (0 <= _compareTo);
      _and = _lessEqualsThan;
    }
    return _and;
  }
  
  protected GregorianCalendar getDiaDeHoy() {
    return new GregorianCalendar();
  }
  
  protected boolean validarRutinaUsuario() {
    Rutina _rutina = this.usuario.getRutina();
    return _rutina.equals(null);
  }
  
  protected boolean condicionesValidas() {
    List<Condicion> _condicionesPreexistentes = this.usuario.getCondicionesPreexistentes();
    final Function1<Condicion, Boolean> _function = new Function1<Condicion, Boolean>() {
      public Boolean apply(final Condicion condicion) {
        boolean _validarCondicion = condicion.validarCondicion(UsuarioBuilder.this.usuario);
        return Boolean.valueOf(Boolean.valueOf(_validarCondicion).equals(Boolean.valueOf(false)));
      }
    };
    return IterableExtensions.<Condicion>exists(_condicionesPreexistentes, _function);
  }
  
  public Usuario build() {
    boolean _validarUsuario = this.validarUsuario();
    if (_validarUsuario) {
      throw new BusinessException("Usuario no valido");
    }
    return this.usuario;
  }
}
