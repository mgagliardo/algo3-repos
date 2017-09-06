package ar.tp.dieta;

import ar.tp.dieta.Condicion;
import ar.tp.dieta.ElementoDeReceta;
import ar.tp.dieta.Usuario;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class CondicionDiabetes extends Condicion {
  private final String[] elementosNoRecomendables = { "azucar" };
  
  public boolean esDiabetes() {
    return true;
  }
  
  public boolean seSubsana(final Usuario unUsuario) {
    boolean _or = false;
    boolean _rutinaEsActiva = unUsuario.rutinaEsActiva();
    if (_rutinaEsActiva) {
      _or = true;
    } else {
      Double _peso = unUsuario.getPeso();
      boolean _lessEqualsThan = ((_peso).doubleValue() <= 70.0);
      _or = _lessEqualsThan;
    }
    return _or;
  }
  
  public boolean validarCondicion(final Usuario unUsuario) {
    boolean _and = false;
    String _sexo = unUsuario.getSexo();
    boolean _equals = _sexo.equals(null);
    if (!_equals) {
      _and = false;
    } else {
      boolean _isEmpty = unUsuario.preferencias.isEmpty();
      boolean _not = (!_isEmpty);
      _and = _not;
    }
    return _and;
  }
  
  public boolean ingredienteEsInadecuado(final ElementoDeReceta unElemento) {
    boolean _and = false;
    String _nombre = unElemento.getNombre();
    boolean _contains = ((List<String>)Conversions.doWrapArray(this.elementosNoRecomendables)).contains(_nombre);
    if (!_contains) {
      _and = false;
    } else {
      int _cantidad = unElemento.getCantidad();
      boolean _greaterThan = (_cantidad > 100);
      _and = _greaterThan;
    }
    return _and;
  }
}
