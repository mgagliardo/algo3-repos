package ar.tp.dieta;

import ar.tp.dieta.ConsultaObserver;
import ar.tp.dieta.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import queComemos.entrega3.repositorio.BusquedaRecetas;

@Accessors
@SuppressWarnings("all")
public abstract class ConsultaBase {
  private List<ConsultaObserver> observadores = new ArrayList<ConsultaObserver>();
  
  public void actualizarObservers(final Usuario usuario, final List<String> nombres, final BusquedaRecetas busqueda) {
    final Consumer<ConsultaObserver> _function = new Consumer<ConsultaObserver>() {
      @Override
      public void accept(final ConsultaObserver observador) {
        observador.actualizar(usuario, nombres, busqueda);
      }
    };
    this.observadores.forEach(_function);
  }
  
  @Pure
  public List<ConsultaObserver> getObservadores() {
    return this.observadores;
  }
  
  public void setObservadores(final List<ConsultaObserver> observadores) {
    this.observadores = observadores;
  }
}
