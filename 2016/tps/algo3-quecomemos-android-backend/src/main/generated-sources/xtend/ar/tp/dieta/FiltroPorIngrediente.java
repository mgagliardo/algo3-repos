package ar.tp.dieta;

import ar.tp.dieta.ElementoDeReceta;
import ar.tp.dieta.Filtro;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class FiltroPorIngrediente implements Filtro {
  private String ingrediente;
  
  private List<Receta> temporal = new ArrayList<Receta>();
  
  public FiltroPorIngrediente(final String parametroIngrediente) {
    String _lowerCase = parametroIngrediente.toLowerCase();
    this.ingrediente = _lowerCase;
  }
  
  public List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetasSinFiltrar) {
    final Consumer<Receta> _function = new Consumer<Receta>() {
      public void accept(final Receta receta) {
        List<ElementoDeReceta> _elementosDeReceta = receta.getElementosDeReceta();
        final Consumer<ElementoDeReceta> _function = new Consumer<ElementoDeReceta>() {
          public void accept(final ElementoDeReceta elemento) {
            String _nombre = elemento.getNombre();
            String _lowerCase = _nombre.toLowerCase();
            boolean _contains = _lowerCase.contains(FiltroPorIngrediente.this.ingrediente);
            if (_contains) {
              FiltroPorIngrediente.this.temporal.add(receta);
            }
          }
        };
        _elementosDeReceta.forEach(_function);
      }
    };
    recetasSinFiltrar.forEach(_function);
    return this.temporal;
  }
  
  public List<Receta> aplicarFiltroGrupo(final Grupo unGrupo, final List<Receta> recetasSinFiltrar) {
    return null;
  }
}
