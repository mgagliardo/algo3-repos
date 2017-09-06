package ar.tp.dieta;

import ar.tp.dieta.Rutina;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RutinaSedentaria extends Rutina {
  private int tiempoDeEjercicio;
  
  @Override
  public boolean rutinaEsNula() {
    return Integer.valueOf(this.tiempoDeEjercicio).equals(Integer.valueOf(0));
  }
  
  @Override
  public boolean rutinaEsLeve() {
    return (this.tiempoDeEjercicio < 30);
  }
  
  @Override
  public boolean rutinaEsMedia() {
    return (this.tiempoDeEjercicio > 30);
  }
  
  @Override
  public boolean rutinaEsActiva() {
    return false;
  }
  
  @Override
  public boolean rutinaEsIntensiva() {
    return false;
  }
  
  @Pure
  public int getTiempoDeEjercicio() {
    return this.tiempoDeEjercicio;
  }
  
  public void setTiempoDeEjercicio(final int tiempoDeEjercicio) {
    this.tiempoDeEjercicio = tiempoDeEjercicio;
  }
}
