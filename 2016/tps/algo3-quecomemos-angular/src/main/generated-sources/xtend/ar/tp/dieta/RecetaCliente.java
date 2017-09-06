package ar.tp.dieta;

import ar.tp.dieta.Receta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RecetaCliente {
  private List<Receta> recetas = new ArrayList<Receta>();
  
  private List<Boolean> favs = new ArrayList<Boolean>();
  
  private List<String> dificultades = new ArrayList<String>();
  
  private List<String> temporadas = new ArrayList<String>();
  
  private String mensaje;
  
  public RecetaCliente(final String mensa, final List<Receta> recetaList, final Usuario usuario, final List<String> dificultad, final List<String> temporada) {
    this.dificultades.addAll(dificultad);
    this.mensaje = mensa;
    this.temporadas.addAll(temporada);
    final Consumer<Receta> _function = new Consumer<Receta>() {
      public void accept(final Receta receta) {
        String _nombreDeLaReceta = receta.getNombreDeLaReceta();
        boolean _tenesEstaReceta = RecetaCliente.this.tenesEstaReceta(_nombreDeLaReceta);
        boolean _not = (!_tenesEstaReceta);
        if (_not) {
          RecetaCliente.this.recetas.add(receta);
        }
      }
    };
    recetaList.forEach(_function);
    final Consumer<Receta> _function_1 = new Consumer<Receta>() {
      public void accept(final Receta receta) {
        boolean _contenesEstaRecetaEnFavs = usuario.contenesEstaRecetaEnFavs(receta);
        RecetaCliente.this.favs.add(Boolean.valueOf(_contenesEstaRecetaEnFavs));
      }
    };
    this.recetas.forEach(_function_1);
  }
  
  public boolean tenesEstaReceta(final String nombre) {
    final Function1<Receta, Boolean> _function = new Function1<Receta, Boolean>() {
      public Boolean apply(final Receta receta) {
        String _nombreDeLaReceta = receta.getNombreDeLaReceta();
        return Boolean.valueOf(_nombreDeLaReceta.equals(nombre));
      }
    };
    return IterableExtensions.<Receta>exists(this.recetas, _function);
  }
  
  @Pure
  public List<Receta> getRecetas() {
    return this.recetas;
  }
  
  public void setRecetas(final List<Receta> recetas) {
    this.recetas = recetas;
  }
  
  @Pure
  public List<Boolean> getFavs() {
    return this.favs;
  }
  
  public void setFavs(final List<Boolean> favs) {
    this.favs = favs;
  }
  
  @Pure
  public List<String> getDificultades() {
    return this.dificultades;
  }
  
  public void setDificultades(final List<String> dificultades) {
    this.dificultades = dificultades;
  }
  
  @Pure
  public List<String> getTemporadas() {
    return this.temporadas;
  }
  
  public void setTemporadas(final List<String> temporadas) {
    this.temporadas = temporadas;
  }
  
  @Pure
  public String getMensaje() {
    return this.mensaje;
  }
  
  public void setMensaje(final String mensaje) {
    this.mensaje = mensaje;
  }
}
