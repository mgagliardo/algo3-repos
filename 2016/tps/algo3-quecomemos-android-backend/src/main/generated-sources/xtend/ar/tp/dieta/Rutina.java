package ar.tp.dieta;

import ar.tp.dieta.Condicion;
import ar.tp.dieta.Usuario;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class Rutina {
  public abstract boolean rutinaEsNula();
  
  public abstract boolean rutinaEsLeve();
  
  public abstract boolean rutinaEsMedia();
  
  public abstract boolean rutinaEsActiva();
  
  public abstract boolean rutinaEsIntensiva();
  
  public boolean rutinaSaludable(final Usuario unUsuario) {
    boolean _or = false;
    boolean _and = false;
    boolean _validarIMC = unUsuario.validarIMC();
    if (!_validarIMC) {
      _and = false;
    } else {
      List<Condicion> _condicionesPreexistentes = unUsuario.getCondicionesPreexistentes();
      boolean _isEmpty = _condicionesPreexistentes.isEmpty();
      _and = _isEmpty;
    }
    if (_and) {
      _or = true;
    } else {
      List<Condicion> _condicionesPreexistentes_1 = unUsuario.getCondicionesPreexistentes();
      final Function1<Condicion, Boolean> _function = new Function1<Condicion, Boolean>() {
        public Boolean apply(final Condicion condicion) {
          return Boolean.valueOf(condicion.seSubsana(unUsuario));
        }
      };
      boolean _forall = IterableExtensions.<Condicion>forall(_condicionesPreexistentes_1, _function);
      _or = _forall;
    }
    return _or;
  }
}
