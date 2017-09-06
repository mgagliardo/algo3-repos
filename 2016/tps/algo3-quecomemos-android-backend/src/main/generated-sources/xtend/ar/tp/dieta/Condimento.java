package ar.tp.dieta;

import ar.tp.dieta.Condicion;
import ar.tp.dieta.ElementoDeReceta;

@SuppressWarnings("all")
public class Condimento extends ElementoDeReceta {
  public boolean soyInadecuadoParaCondicion(final Condicion unaCondicion) {
    return unaCondicion.ingredienteEsInadecuado(this);
  }
  
  public String toString() {
    return this.getNombre();
  }
}
