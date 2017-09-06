package ar.tp.dieta;

import ar.tp.dieta.Condimento;

@SuppressWarnings("all")
public class CondimentoBuilder {
  private Condimento condimento;
  
  public CondimentoBuilder(final String nombreCondimento) {
    Condimento _condimento = new Condimento();
    this.condimento = _condimento;
    this.condimento.setNombre(nombreCondimento);
  }
  
  public CondimentoBuilder cantidad(final int cantidad) {
    this.condimento.setCantidad(cantidad);
    return this;
  }
  
  public Condimento build() {
    return this.condimento;
  }
}
