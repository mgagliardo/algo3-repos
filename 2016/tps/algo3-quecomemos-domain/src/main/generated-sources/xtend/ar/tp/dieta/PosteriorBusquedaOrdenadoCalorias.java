package ar.tp.dieta;

import ar.tp.dieta.Filtro;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class PosteriorBusquedaOrdenadoCalorias implements Filtro {
  @Override
  public List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetasSinFiltrar) {
    final Function1<Receta, Double> _function = new Function1<Receta, Double>() {
      @Override
      public Double apply(final Receta it) {
        return Double.valueOf(it.getCalorias());
      }
    };
    return IterableExtensions.<Receta, Double>sortBy(recetasSinFiltrar, _function);
  }
  
  @Override
  public List<Receta> aplicarFiltroGrupo(final Grupo unGrupo, final List<Receta> recetasSinFiltrar) {
    final Function1<Receta, Double> _function = new Function1<Receta, Double>() {
      @Override
      public Double apply(final Receta it) {
        return Double.valueOf(it.getCalorias());
      }
    };
    return IterableExtensions.<Receta, Double>sortBy(recetasSinFiltrar, _function);
  }
}
