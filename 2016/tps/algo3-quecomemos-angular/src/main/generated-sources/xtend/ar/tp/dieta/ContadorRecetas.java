package ar.tp.dieta;

import ar.tp.dieta.Receta;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class ContadorRecetas {
  private Receta receta;
  
  private int cantidad;
  
  public ContadorRecetas(final Receta unaReceta, final int unaCantidad) {
    this.cantidad = unaCantidad;
    this.receta = unaReceta;
  }
  
  @Pure
  public Receta getReceta() {
    return this.receta;
  }
  
  public void setReceta(final Receta receta) {
    this.receta = receta;
  }
  
  @Pure
  public int getCantidad() {
    return this.cantidad;
  }
  
  public void setCantidad(final int cantidad) {
    this.cantidad = cantidad;
  }
}
