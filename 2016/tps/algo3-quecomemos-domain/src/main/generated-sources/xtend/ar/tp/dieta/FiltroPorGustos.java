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
public class FiltroPorGustos implements Filtro {
  @Override
  public List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetas) {
    List<Receta> _xblockexpression = null;
    {
      List<Receta> recetasADevolver = new ArrayList<Receta>();
      final Function1<Receta, Boolean> _function = new Function1<Receta, Boolean>() {
        @Override
        public Boolean apply(final Receta receta) {
          boolean _noMeGustaEstaReceta = unUsuario.noMeGustaEstaReceta(receta);
          return Boolean.valueOf((!_noMeGustaEstaReceta));
        }
      };
      Iterable<Receta> _filter = IterableExtensions.<Receta>filter(recetas, _function);
      for (final Receta elemento : _filter) {
        recetasADevolver.add(elemento);
      }
      _xblockexpression = recetasADevolver;
    }
    return _xblockexpression;
  }
  
  @Override
  public List<Receta> aplicarFiltroGrupo(final Grupo unGrupo, final List<Receta> recetasSinFiltrar) {
    return null;
  }
}
