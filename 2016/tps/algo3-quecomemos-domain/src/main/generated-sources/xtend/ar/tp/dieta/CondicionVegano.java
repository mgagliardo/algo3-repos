package ar.tp.dieta;

import ar.tp.dieta.Condicion;
import ar.tp.dieta.ElementoDeReceta;
import ar.tp.dieta.Usuario;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class CondicionVegano extends Condicion {
  private List<String> elementosNoRecomendables = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("pollo", "carne", "chivito", "chori", "lomo"));
  
  @Override
  public boolean esVegano() {
    return true;
  }
  
  @Override
  public boolean seSubsana(final Usuario unUsuario) {
    return unUsuario.meGustaLaFruta();
  }
  
  @Override
  public boolean validarCondicion(final Usuario unUsuario) {
    boolean _meGustaLaCarne = unUsuario.meGustaLaCarne();
    return (!_meGustaLaCarne);
  }
  
  @Override
  public boolean ingredienteEsInadecuado(final ElementoDeReceta unElemento) {
    String _nombre = unElemento.getNombre();
    return this.elementosNoRecomendables.contains(_nombre);
  }
}
