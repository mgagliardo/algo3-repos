package ar.tp.dieta;

import ar.tp.dieta.Condicion;
import ar.tp.dieta.ElementoDeReceta;

@SuppressWarnings("all")
public class Ingrediente extends ElementoDeReceta {
  @Override
  public boolean soyInadecuadoParaCondicion(final Condicion unaCondicion) {
    return unaCondicion.ingredienteEsInadecuado(this);
  }
}
