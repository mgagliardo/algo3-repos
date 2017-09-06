package ar.tp.dieta;

import ar.tp.dieta.Condicion;
import ar.tp.dieta.ElementoDeReceta;

@SuppressWarnings("all")
public class CondicionCeliaco extends Condicion {
  public boolean esCeliaco() {
    return true;
  }
  
  public boolean ingredienteEsInadecuado(final ElementoDeReceta unElemento) {
    return false;
  }
}
