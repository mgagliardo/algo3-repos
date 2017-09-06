package ar.tp.dieta;

import ar.tp.dieta.Condicion;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public abstract class ElementoDeReceta {
  private String nombre = new String();
  
  private int cantidad;
  
  public abstract boolean soyInadecuadoParaCondicion(final Condicion unaCondicion);
  
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public int getCantidad() {
    return this.cantidad;
  }
  
  public void setCantidad(final int cantidad) {
    this.cantidad = cantidad;
  }
}
