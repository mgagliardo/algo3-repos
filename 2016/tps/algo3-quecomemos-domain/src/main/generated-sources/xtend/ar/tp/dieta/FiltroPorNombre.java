package ar.tp.dieta;

import ar.tp.dieta.Filtro;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class FiltroPorNombre implements Filtro {
  private String nombre;
  
  private List<Receta> temporal = new ArrayList<Receta>();
  
  public FiltroPorNombre(final String parametroNombre) {
    this.nombre = parametroNombre;
  }
  
  @Override
  public List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetasSinFiltrar) {
    final Consumer<Receta> _function = new Consumer<Receta>() {
      @Override
      public void accept(final Receta receta) {
        String _nombreDeLaReceta = receta.getNombreDeLaReceta();
        boolean _equals = _nombreDeLaReceta.equals(FiltroPorNombre.this.nombre);
        if (_equals) {
          FiltroPorNombre.this.temporal.add(receta);
        }
      }
    };
    recetasSinFiltrar.forEach(_function);
    return this.temporal;
  }
  
  @Override
  public List<Receta> aplicarFiltroGrupo(final Grupo unGrupo, final List<Receta> recetasSinFiltrar) {
    return null;
  }
}
