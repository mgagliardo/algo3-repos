package ar.tp.dieta;

import ar.tp.dieta.Filtro;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("all")
public class PosteriorBusquedaPares implements Filtro {
  public List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetasSinFiltrar) {
    List<Receta> _xblockexpression = null;
    {
      List<Receta> recetasADevolver = new ArrayList<Receta>();
      Iterator<Receta> iterRecetas = recetasSinFiltrar.iterator();
      int contador = 1;
      while ((contador <= 10)) {
        {
          boolean _equals = Integer.valueOf((contador % 2)).equals(Integer.valueOf(0));
          if (_equals) {
            Receta _next = iterRecetas.next();
            recetasADevolver.add(_next);
          }
          contador++;
        }
      }
      _xblockexpression = recetasADevolver;
    }
    return _xblockexpression;
  }
  
  public List<Receta> aplicarFiltroGrupo(final Grupo unGrupo, final List<Receta> recetasSinFiltrar) {
    List<Receta> _xblockexpression = null;
    {
      List<Receta> recetasADevolver = new ArrayList<Receta>();
      Iterator<Receta> iterRecetas = recetasSinFiltrar.iterator();
      int contador = 1;
      while ((contador <= 10)) {
        {
          boolean _equals = Integer.valueOf((contador % 2)).equals(Integer.valueOf(0));
          if (_equals) {
            Receta _next = iterRecetas.next();
            recetasADevolver.add(_next);
          }
          contador++;
        }
      }
      _xblockexpression = recetasADevolver;
    }
    return _xblockexpression;
  }
}
