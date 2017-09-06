package ar.tp.dieta;

import ar.tp.dieta.Filtro;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class FiltroPorCaloriasMinimas implements Filtro {
  private int calorias;
  
  private List<Receta> temporal = new ArrayList<Receta>();
  
  public FiltroPorCaloriasMinimas(final int parametroCalorias) {
    this.calorias = parametroCalorias;
  }
  
  public List<Receta> aplicarFiltroUsuario(final Usuario unUsuario, final List<Receta> recetasSinFiltrar) {
    final Consumer<Receta> _function = new Consumer<Receta>() {
      public void accept(final Receta receta) {
        double _calorias = receta.getCalorias();
        boolean _greaterEqualsThan = (_calorias >= FiltroPorCaloriasMinimas.this.calorias);
        if (_greaterEqualsThan) {
          FiltroPorCaloriasMinimas.this.temporal.add(receta);
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
