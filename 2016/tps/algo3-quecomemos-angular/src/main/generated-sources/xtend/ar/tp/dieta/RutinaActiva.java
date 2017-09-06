package ar.tp.dieta;

import ar.tp.dieta.Rutina;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RutinaActiva extends Rutina {
  private int tiempoDeEjercicio;
  
  public boolean rutinaEsNula() {
    return false;
  }
  
  public boolean rutinaEsLeve() {
    return false;
  }
  
  public boolean rutinaEsMedia() {
    return false;
  }
  
  public boolean rutinaEsActiva() {
    return true;
  }
  
  public boolean rutinaEsIntensiva() {
    return (this.tiempoDeEjercicio > 30);
  }
  
  @Pure
  public int getTiempoDeEjercicio() {
    return this.tiempoDeEjercicio;
  }
  
  public void setTiempoDeEjercicio(final int tiempoDeEjercicio) {
    this.tiempoDeEjercicio = tiempoDeEjercicio;
  }
}
