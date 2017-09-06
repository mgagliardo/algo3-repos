package ar.tp.dieta;

import ar.tp.dieta.Usuario;
import java.util.List;
import queComemos.entrega3.repositorio.BusquedaRecetas;

@SuppressWarnings("all")
public interface ConsultaObserver {
  public abstract void actualizar(final Usuario usuario, final List<String> nombres, final BusquedaRecetas busqueda);
}
