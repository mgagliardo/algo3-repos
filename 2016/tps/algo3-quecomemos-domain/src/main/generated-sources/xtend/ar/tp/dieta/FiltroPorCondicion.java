package ar.tp.dieta;

import ar.tp.dieta.Filtro;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class FiltroPorCondicion implements Filtro {
  @Override
  public List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetas) {
    List<Receta> _xblockexpression = null;
    {
      final Consumer<Receta> _function = new Consumer<Receta>() {
        @Override
        public void accept(final Receta receta) {
          boolean _esInadecuadaParaUsuario = receta.esInadecuadaParaUsuario(unUsuario);
          if (_esInadecuadaParaUsuario) {
            recetas.remove(receta);
          }
        }
      };
      recetas.forEach(_function);
      _xblockexpression = recetas;
    }
    return _xblockexpression;
  }
  
  @Override
  public List<Receta> aplicarFiltroGrupo(final Grupo unGrupo, final List<Receta> recetasSinFiltrar) {
    List<Receta> _xblockexpression = null;
    {
      final List<Receta> recetasFiltradas = new ArrayList<Receta>();
      final Consumer<Receta> _function = new Consumer<Receta>() {
        @Override
        public void accept(final Receta receta) {
          boolean _esInadecuadaParaGrupo = receta.esInadecuadaParaGrupo(unGrupo);
          boolean _not = (!_esInadecuadaParaGrupo);
          if (_not) {
            recetasFiltradas.add(receta);
          }
        }
      };
      recetasSinFiltrar.forEach(_function);
      _xblockexpression = recetasFiltradas;
    }
    return _xblockexpression;
  }
}
