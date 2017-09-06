package ar.tp.dieta;

import ar.tp.dieta.Ingrediente;

@SuppressWarnings("all")
public class IngredienteBuilder {
  private Ingrediente ingrediente;
  
  public IngredienteBuilder(final String nombreIngrediente) {
    Ingrediente _ingrediente = new Ingrediente();
    this.ingrediente = _ingrediente;
    this.ingrediente.setNombre(nombreIngrediente);
  }
  
  public IngredienteBuilder cantidad(final int cantidad) {
    this.ingrediente.setCantidad(cantidad);
    return this;
  }
  
  public Ingrediente build() {
    return this.ingrediente;
  }
}
