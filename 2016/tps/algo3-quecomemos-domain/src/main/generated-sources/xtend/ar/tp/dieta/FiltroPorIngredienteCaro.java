package ar.tp.dieta;

import ar.tp.dieta.Filtro;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class FiltroPorIngredienteCaro implements Filtro {
  private final String[] elementosCaros = { "lechon", "lomo", "salmon", "alcaparras" };
  
  @Override
  public List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetas) {
    List<Receta> _xblockexpression = null;
    {
      final List<Receta> recetasFinal = new ArrayList<Receta>();
      final Consumer<Receta> _function = new Consumer<Receta>() {
        @Override
        public void accept(final Receta receta) {
          boolean _contieneAlguno = receta.contieneAlguno(((List<String>)Conversions.doWrapArray(FiltroPorIngredienteCaro.this.elementosCaros)));
          boolean _not = (!_contieneAlguno);
          if (_not) {
            recetasFinal.add(receta);
          }
        }
      };
      recetas.forEach(_function);
      _xblockexpression = recetasFinal;
    }
    return _xblockexpression;
  }
  
  /**
   * override aplicarFiltroUsuario(Usuario unUsuario, List<Receta> recetas){
   * val List<Receta> recetasFiltradas = new ArrayList<Receta>
   * recetas.forEach[receta | if(!receta.elementosDeReceta.contains("lechon") || !receta.elementosDeReceta.contains("lomo") || !receta.elementosDeReceta.contains("salmon") || !receta.elementosDeReceta.contains("alcaparras")){
   * recetasFiltradas.add(receta)}]
   * recetasFiltradas
   * 
   * }
   */
  @Override
  public List<Receta> aplicarFiltroGrupo(final Grupo unGrupo, final List<Receta> recetasSinFiltrar) {
    return null;
  }
}
