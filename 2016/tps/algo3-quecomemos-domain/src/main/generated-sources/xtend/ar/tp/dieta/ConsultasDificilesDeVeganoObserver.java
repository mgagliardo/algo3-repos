package ar.tp.dieta;

import ar.tp.dieta.CondicionVegano;
import ar.tp.dieta.ConsultaObserver;
import ar.tp.dieta.Usuario;
import java.util.List;
import queComemos.entrega3.dominio.Dificultad;
import queComemos.entrega3.repositorio.BusquedaRecetas;

@SuppressWarnings("all")
public class ConsultasDificilesDeVeganoObserver implements ConsultaObserver {
  private int contadorDeVeganos;
  
  @Override
  public void actualizar(final Usuario usuario, final List<String> nombres, final BusquedaRecetas busqueda) {
    boolean _and = false;
    Dificultad _dificultad = busqueda.getDificultad();
    boolean _equals = _dificultad.equals("DIFICIL");
    if (!_equals) {
      _and = false;
    } else {
      CondicionVegano _condicionVegano = new CondicionVegano();
      boolean _tenesEstaCondicion = usuario.tenesEstaCondicion(_condicionVegano);
      _and = _tenesEstaCondicion;
    }
    if (_and) {
      this.contadorDeVeganos++;
    }
  }
  
  public int mostrarCantidadDeVeganos() {
    return this.contadorDeVeganos;
  }
}
