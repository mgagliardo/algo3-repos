package ar.tp.dieta;

import ar.tp.dieta.Condimento;
import ar.tp.dieta.Ingrediente;
import ar.tp.dieta.Receta;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class RecetaBuilder {
  public static String FACIL = "Facil";
  
  public static String MEDIA = "Media";
  
  public static String DIFICIL = "Dificil";
  
  public static String OTONIO = "Otonio";
  
  public static String VERANO = "Verano";
  
  public static String PRIMAVERA = "Primavera";
  
  public static String INVIERNO = "Invierno";
  
  public static String TODOELANIO = "Todo el anio";
  
  private Receta receta;
  
  public RecetaBuilder(final String nombreReceta) {
    Receta _receta = new Receta();
    this.receta = _receta;
    this.receta.setNombreDeLaReceta(nombreReceta);
  }
  
  public List<String> getDificultades() {
    ArrayList<String> _xblockexpression = null;
    {
      ArrayList<String> listaTemp = new ArrayList<String>();
      listaTemp.add(RecetaBuilder.FACIL);
      listaTemp.add(RecetaBuilder.MEDIA);
      listaTemp.add(RecetaBuilder.DIFICIL);
      _xblockexpression = listaTemp;
    }
    return _xblockexpression;
  }
  
  public List<String> getTemporadas() {
    ArrayList<String> _xblockexpression = null;
    {
      ArrayList<String> listaTemp = new ArrayList<String>();
      listaTemp.add(RecetaBuilder.OTONIO);
      listaTemp.add(RecetaBuilder.VERANO);
      listaTemp.add(RecetaBuilder.PRIMAVERA);
      listaTemp.add(RecetaBuilder.INVIERNO);
      listaTemp.add(RecetaBuilder.TODOELANIO);
      _xblockexpression = listaTemp;
    }
    return _xblockexpression;
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
    return this.receta;
  }
}
