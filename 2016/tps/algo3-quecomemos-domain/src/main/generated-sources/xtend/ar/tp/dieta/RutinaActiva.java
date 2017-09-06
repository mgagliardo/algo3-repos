package ar.tp.dieta;

import ar.tp.dieta.Rutina;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RutinaActiva extends Rutina {
  private int tiempoDeEjercicio;
  
  @Override
  public boolean rutinaEsNula() {
    return false;
  }
  
  @Override
  public boolean rutinaEsLeve() {
    return false;
  }
  
  @Override
  public boolean rutinaEsMedia() {
    return false;
  }
  
  @Override
  public boolean rutinaEsActiva() {
    return true;
  }
  
  @Override
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
