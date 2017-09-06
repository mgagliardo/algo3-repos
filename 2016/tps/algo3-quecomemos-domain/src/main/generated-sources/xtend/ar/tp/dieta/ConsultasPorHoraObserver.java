package ar.tp.dieta;

import ar.tp.dieta.ConsultaObserver;
import ar.tp.dieta.Usuario;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import queComemos.entrega3.repositorio.BusquedaRecetas;

@SuppressWarnings("all")
public class ConsultasPorHoraObserver implements ConsultaObserver {
  private Map<Integer, Integer> consultasPorHora = new HashMap<Integer, Integer>();
  
  private Calendar calendario = new GregorianCalendar();
  
  @Override
  public void actualizar(final Usuario usuario, final List<String> nombres, final BusquedaRecetas busqueda) {
    final int hora = this.calendario.get(Calendar.HOUR_OF_DAY);
    boolean _containsKey = this.consultasPorHora.containsKey(Integer.valueOf(hora));
    boolean _not = (!_containsKey);
    if (_not) {
      this.consultasPorHora.put(Integer.valueOf(hora), Integer.valueOf(1));
    } else {
      Integer _get = this.consultasPorHora.get(Integer.valueOf(hora));
      int _plus = ((_get).intValue() + 1);
      this.consultasPorHora.put(Integer.valueOf(hora), Integer.valueOf(_plus));
    }
  }
  
  public Integer mostrarConsultasDeHora(final int hora) {
    return this.consultasPorHora.get(Integer.valueOf(hora));
  }
}
