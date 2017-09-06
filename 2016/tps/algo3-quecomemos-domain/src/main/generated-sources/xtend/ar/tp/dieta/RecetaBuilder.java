package ar.tp.dieta;

import ar.tp.dieta.Condimento;
import ar.tp.dieta.Ingrediente;
import ar.tp.dieta.Receta;
import org.uqbar.commons.model.UserException;

@SuppressWarnings("all")
public class RecetaBuilder {
  public static String FACIL = "Facil";
  
  public static String MEDIA = "Media";
  
  public static String DIFICIL = "Dificil";
  
  public static String OTOÑO = "Otoño";
  
  public static String VERANO = "Verano";
  
  public static String PRIMAVERA = "Primavera";
  
  public static String INVIERNO = "Invierno";
  
  public static String TODOELAÑO = "Todo el año";
  
  private Receta receta;
  
  public RecetaBuilder(final String nombreReceta) {
    Receta _receta = new Receta();
    this.receta = _receta;
    this.receta.setNombreDeLaReceta(nombreReceta);
  }
  
  public RecetaBuilder calorias(final double calorias) {
    this.receta.setCalorias(calorias);
    return this;
  }
  
  public RecetaBuilder autor(final String autor) {
    this.receta.setAutor(autor);
    return this;
  }
  
  public RecetaBuilder dificultad(final String dificultad) {
    this.receta.setDificultadDePreparacion(dificultad);
    return this;
  }
  
  public RecetaBuilder procesoPreparacion(final String procesoPreparacion) {
    this.receta.setProcesoDePreparacion(procesoPreparacion);
    return this;
  }
  
  public RecetaBuilder temporada(final String temporada) {
    this.receta.setTemporadaALaQueCorresponde(temporada);
    return this;
  }
  
  public RecetaBuilder agregarIngrediente(final Ingrediente unIngrediente) {
    this.receta.agregarIngrediente(unIngrediente);
    return this;
  }
  
  public RecetaBuilder agregarCondimento(final Condimento unCondimento) {
    this.receta.agregarCondimento(unCondimento);
    return this;
  }
  
  public Receta build() {
    String _nombreDeLaReceta = this.receta.getNombreDeLaReceta();
    int _length = _nombreDeLaReceta.length();
    boolean _equals = Integer.valueOf(_length).equals(Integer.valueOf(0));
    if (_equals) {
      throw new UserException("El nombre no puede estar vacio");
    } else {
      return this.receta;
    }
  }
}
