package ar.tp.dieta;

import ar.tp.dieta.Usuario;
import java.util.List;
import queComemos.entrega3.repositorio.BusquedaRecetas;

@SuppressWarnings("all")
public interface Accion {
  public abstract void execute(final Usuario usuario, final BusquedaRecetas busqueda, final List<String> nombresRecetas);
}
