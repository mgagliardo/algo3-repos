package ar.tp.dieta;

import ar.tp.dieta.Accion;
import ar.tp.dieta.Usuario;
import java.util.List;
import java.util.function.Consumer;
import queComemos.entrega3.repositorio.BusquedaRecetas;

@SuppressWarnings("all")
public class AgregaResultadosAFavoritos implements Accion {
  @Override
  public void execute(final Usuario usuario, final BusquedaRecetas busqueda, final List<String> nombresRecetas) {
    Boolean _resultadoDeConsultasAFavoritos = usuario.getResultadoDeConsultasAFavoritos();
    if ((_resultadoDeConsultasAFavoritos).booleanValue()) {
      final Consumer<String> _function = new Consumer<String>() {
        @Override
        public void accept(final String receta) {
          usuario.agregarRecetaFavorita(receta);
        }
      };
      nombresRecetas.forEach(_function);
    }
  }
}
