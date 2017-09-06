package ar.tp.dieta;

import ar.tp.dieta.Filtro;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class FiltroPorTemporada implements Filtro {
  private String temporada;
  
  private List<Receta> temporal = new ArrayList<Receta>();
  
  public FiltroPorTemporada(final String parametroTemporada) {
    this.temporada = parametroTemporada;
  }
  
  public List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetasSinFiltrar) {
    final Consumer<Receta> _function = new Consumer<Receta>() {
      public void accept(final Receta receta) {
        String _temporadaALaQueCorresponde = receta.getTemporadaALaQueCorresponde();
        boolean _equals = _temporadaALaQueCorresponde.equals(FiltroPorTemporada.this.temporada);
        if (_equals) {
          FiltroPorTemporada.this.temporal.add(receta);
        }
      }
    };
    recetasSinFiltrar.forEach(_function);
    return this.temporal;
  }
  
  public List<Receta> aplicarFiltroGrupo(final Grupo unGrupo, final List<Receta> recetasSinFiltrar) {
    return null;
  }
}
