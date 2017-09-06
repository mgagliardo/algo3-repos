package ar.tp.dieta;

import ar.tp.dieta.Condicion;
import ar.tp.dieta.ElementoDeReceta;

@SuppressWarnings("all")
public class CondicionCeliaco extends Condicion {
  @Override
  public boolean esCeliaco() {
    return true;
  }
  
  @Override
  public boolean ingredienteEsInadecuado(final ElementoDeReceta unElemento) {
    return false;
  }
}
