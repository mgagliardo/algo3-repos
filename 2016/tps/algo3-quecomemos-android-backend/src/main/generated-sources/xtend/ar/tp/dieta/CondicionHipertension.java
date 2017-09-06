package ar.tp.dieta;

import ar.tp.dieta.Condicion;
import ar.tp.dieta.ElementoDeReceta;
import ar.tp.dieta.Usuario;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class CondicionHipertension extends Condicion {
  private final String[] elementosNoRecomendables = { "sal", "caldo" };
  
  public boolean esHipertension() {
    return true;
  }
  
  public boolean seSubsana(final Usuario unUsuario) {
    return unUsuario.rutinaEsIntensiva();
  }
  
  public boolean validarCondicion(final Usuario unUsuario) {
    boolean _isEmpty = unUsuario.preferencias.isEmpty();
    return (!_isEmpty);
  }
  
  public boolean ingredienteEsInadecuado(final ElementoDeReceta unElemento) {
    String _nombre = unElemento.getNombre();
    return ((List<String>)Conversions.doWrapArray(this.elementosNoRecomendables)).contains(_nombre);
  }
}
