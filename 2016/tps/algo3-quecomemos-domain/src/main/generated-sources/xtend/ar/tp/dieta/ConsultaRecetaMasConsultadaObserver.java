package ar.tp.dieta;

import ar.tp.dieta.ConsultaObserver;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import queComemos.entrega3.repositorio.BusquedaRecetas;

@SuppressWarnings("all")
public class ConsultaRecetaMasConsultadaObserver implements ConsultaObserver {
  public Map<String, Integer> recetasMasConsultadas = new HashMap<String, Integer>();
  
  private List<String> nombresRecetas = new ArrayList<String>();
  
  public String nombreMaximo;
  
  @Override
  public void actualizar(final Usuario usuario, final List<String> nombres, final BusquedaRecetas busqueda) {
    final Consumer<String> _function = new Consumer<String>() {
      @Override
      public void accept(final String nombre) {
        boolean _containsKey = ConsultaRecetaMasConsultadaObserver.this.recetasMasConsultadas.containsKey(nombre);
        boolean _not = (!_containsKey);
        if (_not) {
          ConsultaRecetaMasConsultadaObserver.this.recetasMasConsultadas.put(nombre, Integer.valueOf(1));
          ConsultaRecetaMasConsultadaObserver.this.nombresRecetas.add(nombre);
        } else {
          Integer _get = ConsultaRecetaMasConsultadaObserver.this.recetasMasConsultadas.get(nombre);
          int _plus = ((_get).intValue() + 1);
          ConsultaRecetaMasConsultadaObserver.this.recetasMasConsultadas.put(nombre, Integer.valueOf(_plus));
        }
      }
    };
    nombres.forEach(_function);
  }
  
  public String recetaMasConsultada() {
    return this.masConsultada(this.recetasMasConsultadas);
  }
  
  protected String masConsultada(final Map<String, Integer> unMap) {
    String _xblockexpression = null;
    {
      int i = 0;
      Integer valorMaximo = Integer.valueOf(0);
      for (i = 0; (i < this.nombresRecetas.size()); i++) {
        String _get = this.nombresRecetas.get(i);
        Integer _get_1 = unMap.get(_get);
        boolean _greaterThan = (_get_1.compareTo(valorMaximo) > 0);
        if (_greaterThan) {
          String _get_2 = this.nombresRecetas.get(i);
          Integer _get_3 = unMap.get(_get_2);
          valorMaximo = _get_3;
          String _get_4 = this.nombresRecetas.get(i);
          this.nombreMaximo = _get_4;
        }
      }
      _xblockexpression = this.nombreMaximo;
    }
    return _xblockexpression;
  }
  
  public String mostrarRecetaMasConsultada() {
    return this.nombreMaximo;
  }
}
