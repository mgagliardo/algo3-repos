package ar.tp.dieta;

import ar.tp.dieta.BusinessException;
import ar.tp.dieta.Condimento;
import ar.tp.dieta.Ingrediente;
import ar.tp.dieta.Receta;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RecetarioPublico implements Cloneable {
  private List<Receta> recetas = new ArrayList<Receta>();
  
  public void agregarReceta(final Receta unaReceta) {
    this.recetas.add(unaReceta);
  }
  
  public void mirarRecetario() {
    final Consumer<Receta> _function = new Consumer<Receta>() {
      public void accept(final Receta receta) {
        String _nombreDeLaReceta = receta.getNombreDeLaReceta();
        InputOutput.<String>println(_nombreDeLaReceta);
      }
    };
    this.recetas.forEach(_function);
  }
  
  public Receta elegirReceta(final String nombre) {
    Receta _xblockexpression = null;
    {
      Receta _busquedaReceta = this.busquedaReceta(nombre);
      boolean _equals = Objects.equal(_busquedaReceta, null);
      if (_equals) {
        throw new BusinessException("La receta buscada no existe.");
      }
      _xblockexpression = this.busquedaReceta(nombre);
    }
    return _xblockexpression;
  }
  
  public Receta busquedaReceta(final String nombreReceta) {
    final Function1<Receta, Boolean> _function = new Function1<Receta, Boolean>() {
      public Boolean apply(final Receta receta) {
        String _nombreDeLaReceta = receta.getNombreDeLaReceta();
        return Boolean.valueOf(_nombreDeLaReceta.equals(nombreReceta));
      }
    };
    return IterableExtensions.<Receta>findFirst(this.recetas, _function);
  }
  
  /**
   * copiarReceta inicializa una nueva variable recetaTemporal, a
   * la que se le va a asignar la coincidencia de buscar la receta
   * requerida en el listado de recetas (metodo busquedaReceta)
   * luego se copiaran todos los atributos 1x1 de una receta a otra y
   *  se retornara la nueva Receta con todos los atributos copiados
   */
  public Receta copiarReceta(final String nombreReceta, final String nuevoNombreReceta) {
    Receta _xblockexpression = null;
    {
      final Receta recetaTemporal = this.busquedaReceta(nombreReceta);
      Receta unaReceta = new Receta();
      String _nombreDeLaReceta = recetaTemporal.getNombreDeLaReceta();
      boolean _equals = _nombreDeLaReceta.equals(nuevoNombreReceta);
      boolean _not = (!_equals);
      if (_not) {
        unaReceta.setNombreDeLaReceta(nuevoNombreReceta);
      } else {
        String _nombreDeLaReceta_1 = recetaTemporal.getNombreDeLaReceta();
        unaReceta.setNombreDeLaReceta(_nombreDeLaReceta_1);
      }
      double _calorias = recetaTemporal.getCalorias();
      unaReceta.setCalorias(_calorias);
      String _procesoDePreparacion = recetaTemporal.getProcesoDePreparacion();
      unaReceta.setProcesoDePreparacion(_procesoDePreparacion);
      String _dificultadDePreparacion = recetaTemporal.getDificultadDePreparacion();
      unaReceta.setDificultadDePreparacion(_dificultadDePreparacion);
      String _temporadaALaQueCorresponde = recetaTemporal.getTemporadaALaQueCorresponde();
      unaReceta.setTemporadaALaQueCorresponde(_temporadaALaQueCorresponde);
      List<Ingrediente> _ingredientes = recetaTemporal.getIngredientes();
      ArrayList<Ingrediente> _arrayList = new ArrayList<Ingrediente>(_ingredientes);
      unaReceta.setIngredientes(_arrayList);
      List<Condimento> _condimentos = recetaTemporal.getCondimentos();
      ArrayList<Condimento> _arrayList_1 = new ArrayList<Condimento>(_condimentos);
      unaReceta.setCondimentos(_arrayList_1);
      _xblockexpression = unaReceta;
    }
    return _xblockexpression;
  }
  
  @Pure
  public List<Receta> getRecetas() {
    return this.recetas;
  }
  
  public void setRecetas(final List<Receta> recetas) {
    this.recetas = recetas;
  }
}
