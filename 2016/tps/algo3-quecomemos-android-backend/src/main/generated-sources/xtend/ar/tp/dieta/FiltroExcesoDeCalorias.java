package ar.tp.dieta;

import ar.tp.dieta.Filtro;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FiltroExcesoDeCalorias implements Filtro {
  public List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetas) {
    List<Receta> _xifexpression = null;
    boolean _tieneSobrepeso = unUsuario.tieneSobrepeso();
    if (_tieneSobrepeso) {
      List<Receta> _xblockexpression = null;
      {
        List<Receta> recetasADevolver = new ArrayList<Receta>();
        final Function1<Receta, Boolean> _function = new Function1<Receta, Boolean>() {
          public Boolean apply(final Receta receta) {
            boolean _exesoDeCalorias = receta.exesoDeCalorias();
            return Boolean.valueOf((!_exesoDeCalorias));
          }
        };
        Iterable<Receta> _filter = IterableExtensions.<Receta>filter(recetas, _function);
        for (final Receta elemento : _filter) {
          recetasADevolver.add(elemento);
        }
        _xblockexpression = recetasADevolver;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = recetas;
    }
    return _xifexpression;
  }
  
  public List<Receta> aplicarFiltroGrupo(final Grupo unGrupo, final List<Receta> recetasSinFiltrar) {
    return null;
  }
}
