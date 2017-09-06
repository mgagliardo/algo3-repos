package ar.tp.dieta;

import ar.tp.dieta.Filtro;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class FiltroPorDificultad implements Filtro {
  private String dificultad;
  
  private List<Receta> temporal = new ArrayList<Receta>();
  
  public FiltroPorDificultad(final String parametroDificultad) {
    this.dificultad = parametroDificultad;
  }
  
  @Override
  public List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetasSinFiltrar) {
    final Consumer<Receta> _function = new Consumer<Receta>() {
      @Override
      public void accept(final Receta receta) {
        String _dificultadDePreparacion = receta.getDificultadDePreparacion();
        boolean _equals = _dificultadDePreparacion.equals(FiltroPorDificultad.this.dificultad);
        if (_equals) {
          FiltroPorDificultad.this.temporal.add(receta);
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
