package ar.tp.dieta;

import ar.tp.dieta.Accion;
import ar.tp.dieta.Usuario;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import queComemos.entrega3.dominio.Dificultad;
import queComemos.entrega3.repositorio.BusquedaRecetas;

@SuppressWarnings("all")
public class LogeoConsultas implements Accion {
  private int max = 2;
  
  private final static Logger logger = LogManager.getLogger(LogeoConsultas.class);
  
  @Override
  public void execute(final Usuario usuario, final BusquedaRecetas busqueda, final List<String> nombresRecetas) {
    int _size = nombresRecetas.size();
    boolean _greaterEqualsThan = (_size >= this.max);
    if (_greaterEqualsThan) {
      LogeoConsultas.logger.trace("Log de recetas");
      String _nombre = busqueda.getNombre();
      LogeoConsultas.logger.trace(_nombre);
      Dificultad _dificultad = busqueda.getDificultad();
      LogeoConsultas.logger.trace(_dificultad);
      LogeoConsultas.logger.trace("Fin de log");
    }
  }
}
