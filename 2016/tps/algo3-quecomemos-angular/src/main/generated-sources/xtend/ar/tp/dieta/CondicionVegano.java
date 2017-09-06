package ar.tp.dieta;

import ar.tp.dieta.Condicion;
import ar.tp.dieta.ElementoDeReceta;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class CondicionVegano extends Condicion {
  public List<String> elementosNoRecomendables = new ArrayList<String>();
  
  public CondicionVegano() {
    this.elementosNoRecomendables.add("pollo");
    this.elementosNoRecomendables.add("carne");
    this.elementosNoRecomendables.add("chivito");
    this.elementosNoRecomendables.add("chori");
    this.elementosNoRecomendables.add("lomo");
  }
  
  public boolean esVegano() {
    return true;
  }
  
  public boolean seSubsana(final Usuario unUsuario) {
    return unUsuario.meGustaLaFruta();
  }
  
  public boolean validarCondicion(final Usuario unUsuario) {
    boolean _meGustaLaCarne = unUsuario.meGustaLaCarne();
    return (!_meGustaLaCarne);
  }
  
  public boolean ingredienteEsInadecuado(final ElementoDeReceta unElemento) {
    String _nombre = unElemento.getNombre();
    return this.elementosNoRecomendables.contains(_nombre);
  }
}
