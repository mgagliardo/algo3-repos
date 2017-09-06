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
public class ConsultaRecetaMasConsultadaPorSexoObserver implements ConsultaObserver {
  private List<String> nombresRecetas = new ArrayList<String>();
  
  protected String nombreMaximo;
  
  private Map<String, Integer> recetasMasConsultadasPorHombres = new HashMap<String, Integer>();
  
  private Map<String, Integer> recetasMasConsultadasPorMujeres = new HashMap<String, Integer>();
  
  @Override
  public void actualizar(final Usuario usuario, final List<String> nombres, final BusquedaRecetas busqueda) {
    final Consumer<String> _function = new Consumer<String>() {
      @Override
      public void accept(final String nombre) {
        String _sexo = usuario.getSexo();
        boolean _equals = _sexo.equals("F");
        if (_equals) {
          ConsultaRecetaMasConsultadaPorSexoObserver.this.actualizarMap(ConsultaRecetaMasConsultadaPorSexoObserver.this.recetasMasConsultadasPorMujeres, nombre);
        } else {
          ConsultaRecetaMasConsultadaPorSexoObserver.this.actualizarMap(ConsultaRecetaMasConsultadaPorSexoObserver.this.recetasMasConsultadasPorHombres, nombre);
        }
        ConsultaRecetaMasConsultadaPorSexoObserver.this.nombresRecetas.add(nombre);
      }
    };
    nombres.forEach(_function);
  }
  
  protected Integer actualizarMap(final Map<String, Integer> elMap, final String nombre) {
    Integer _xblockexpression = null;
    {
      String clave = nombre;
      Integer _xifexpression = null;
      boolean _containsKey = elMap.containsKey(clave);
      boolean _not = (!_containsKey);
      if (_not) {
        _xifexpression = elMap.put(clave, Integer.valueOf(1));
      } else {
        Integer _xblockexpression_1 = null;
        {
          Integer _get = elMap.get(clave);
          Integer valorActualizado = Integer.valueOf(((_get).intValue() + 1));
          _xblockexpression_1 = elMap.put(clave, valorActualizado);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String recetasMasConsultadasHombres() {
    return this.masConsultada(this.recetasMasConsultadasPorHombres);
  }
  
  public String recetasMasConsultadasMujeres() {
    return this.masConsultada(this.recetasMasConsultadasPorMujeres);
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
}
