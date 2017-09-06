package ar.tp.dieta;

import ar.tp.dieta.Filtro;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("all")
public class PosteriorBusquedaDiezPrimeros implements Filtro {
  @Override
  public List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetasSinFiltrar) {
    List<Receta> _xblockexpression = null;
    {
      List<Receta> recetasADevolver = new ArrayList<Receta>();
      Iterator<Receta> iterRecetas = recetasSinFiltrar.iterator();
      int contador = 0;
      while (((contador < 10) && (contador < recetasSinFiltrar.size()))) {
        {
          Receta _next = iterRecetas.next();
          recetasADevolver.add(_next);
          contador++;
        }
      }
      _xblockexpression = recetasADevolver;
    }
    return _xblockexpression;
  }
  
  @Override
  public List<Receta> aplicarFiltroGrupo(final Grupo unGrupo, final List<Receta> recetasSinFiltrar) {
    List<Receta> _xblockexpression = null;
    {
      List<Receta> recetasADevolver = new ArrayList<Receta>();
      Iterator<Receta> iterRecetas = recetasSinFiltrar.iterator();
      int contador = 0;
      while ((contador < 5)) {
        {
          Receta _next = iterRecetas.next();
          recetasADevolver.add(_next);
          contador++;
        }
      }
      _xblockexpression = recetasADevolver;
    }
    return _xblockexpression;
  }
}
