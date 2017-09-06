package ar.tp.dieta;

import ar.tp.dieta.BusinessException;
import ar.tp.dieta.Condimento;
import ar.tp.dieta.CondimentoBuilder;
import ar.tp.dieta.Ingrediente;
import ar.tp.dieta.IngredienteBuilder;
import ar.tp.dieta.Receta;
import ar.tp.dieta.RecetaBuilder;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class RecetarioPublico implements Cloneable {
  private List<Receta> recetas = new ArrayList<Receta>();
  
  public Receta lomoMostaza;
  
  public Receta arrozConPollo;
  
  public Receta fideosConManteca;
  
  public Receta gelatinaFrambuesa;
  
  public Receta ensalada;
  
  public Receta arrozBlanco;
  
  public RecetarioPublico() {
    RecetaBuilder _recetaBuilder = new RecetaBuilder("Arroz con Pollo");
    RecetaBuilder _calorias = _recetaBuilder.calorias(500);
    RecetaBuilder _autor = _calorias.autor("Carlos Nahir");
    RecetaBuilder _dificultad = _autor.dificultad(RecetaBuilder.FACIL);
    RecetaBuilder _procesoPreparacion = _dificultad.procesoPreparacion("Hervir el arroz con azafran y agregar el pollo previamente salteado");
    RecetaBuilder _temporada = _procesoPreparacion.temporada(RecetaBuilder.INVIERNO);
    IngredienteBuilder _ingredienteBuilder = new IngredienteBuilder("arroz");
    IngredienteBuilder _cantidad = _ingredienteBuilder.cantidad(500);
    Ingrediente _build = _cantidad.build();
    RecetaBuilder _agregarIngrediente = _temporada.agregarIngrediente(_build);
    IngredienteBuilder _ingredienteBuilder_1 = new IngredienteBuilder("pollo");
    IngredienteBuilder _cantidad_1 = _ingredienteBuilder_1.cantidad(1000);
    Ingrediente _build_1 = _cantidad_1.build();
    RecetaBuilder _agregarIngrediente_1 = _agregarIngrediente.agregarIngrediente(_build_1);
    CondimentoBuilder _condimentoBuilder = new CondimentoBuilder("azafran");
    CondimentoBuilder _cantidad_2 = _condimentoBuilder.cantidad(2);
    Condimento _build_2 = _cantidad_2.build();
    RecetaBuilder _agregarCondimento = _agregarIngrediente_1.agregarCondimento(_build_2);
    Receta _build_3 = _agregarCondimento.build();
    this.arrozConPollo = _build_3;
    RecetaBuilder _recetaBuilder_1 = new RecetaBuilder("Fideos con manteca");
    RecetaBuilder _calorias_1 = _recetaBuilder_1.calorias(600);
    RecetaBuilder _autor_1 = _calorias_1.autor("Narda Lepes");
    RecetaBuilder _dificultad_1 = _autor_1.dificultad(RecetaBuilder.MEDIA);
    RecetaBuilder _procesoPreparacion_1 = _dificultad_1.procesoPreparacion("Hervir los fideos. Colar.");
    RecetaBuilder _temporada_1 = _procesoPreparacion_1.temporada(RecetaBuilder.INVIERNO);
    IngredienteBuilder _ingredienteBuilder_2 = new IngredienteBuilder("pasta");
    IngredienteBuilder _cantidad_3 = _ingredienteBuilder_2.cantidad(500);
    Ingrediente _build_4 = _cantidad_3.build();
    RecetaBuilder _agregarIngrediente_2 = _temporada_1.agregarIngrediente(_build_4);
    CondimentoBuilder _condimentoBuilder_1 = new CondimentoBuilder("sal");
    CondimentoBuilder _cantidad_4 = _condimentoBuilder_1.cantidad(2);
    Condimento _build_5 = _cantidad_4.build();
    RecetaBuilder _agregarCondimento_1 = _agregarIngrediente_2.agregarCondimento(_build_5);
    IngredienteBuilder _ingredienteBuilder_3 = new IngredienteBuilder("manteca");
    IngredienteBuilder _cantidad_5 = _ingredienteBuilder_3.cantidad(10);
    Ingrediente _build_6 = _cantidad_5.build();
    RecetaBuilder _agregarIngrediente_3 = _agregarCondimento_1.agregarIngrediente(_build_6);
    Receta _build_7 = _agregarIngrediente_3.build();
    this.fideosConManteca = _build_7;
    RecetaBuilder _recetaBuilder_2 = new RecetaBuilder("Lomo a la Mostaza");
    RecetaBuilder _calorias_2 = _recetaBuilder_2.calorias(1200);
    RecetaBuilder _autor_2 = _calorias_2.autor("Mirtha Legrand");
    RecetaBuilder _dificultad_2 = _autor_2.dificultad(RecetaBuilder.DIFICIL);
    RecetaBuilder _procesoPreparacion_2 = _dificultad_2.procesoPreparacion("Poner el lomo con la mostaza en el horno.");
    RecetaBuilder _temporada_2 = _procesoPreparacion_2.temporada(RecetaBuilder.VERANO);
    IngredienteBuilder _ingredienteBuilder_4 = new IngredienteBuilder("lomo");
    IngredienteBuilder _cantidad_6 = _ingredienteBuilder_4.cantidad(1000);
    Ingrediente _build_8 = _cantidad_6.build();
    RecetaBuilder _agregarIngrediente_4 = _temporada_2.agregarIngrediente(_build_8);
    CondimentoBuilder _condimentoBuilder_2 = new CondimentoBuilder("sal");
    CondimentoBuilder _cantidad_7 = _condimentoBuilder_2.cantidad(2);
    Condimento _build_9 = _cantidad_7.build();
    RecetaBuilder _agregarCondimento_2 = _agregarIngrediente_4.agregarCondimento(_build_9);
    CondimentoBuilder _condimentoBuilder_3 = new CondimentoBuilder("mostaza");
    CondimentoBuilder _cantidad_8 = _condimentoBuilder_3.cantidad(30);
    Condimento _build_10 = _cantidad_8.build();
    RecetaBuilder _agregarCondimento_3 = _agregarCondimento_2.agregarCondimento(_build_10);
    Receta _build_11 = _agregarCondimento_3.build();
    this.lomoMostaza = _build_11;
    RecetaBuilder _recetaBuilder_3 = new RecetaBuilder("Gelatina de Frambuesa");
    RecetaBuilder _calorias_3 = _recetaBuilder_3.calorias(120);
    RecetaBuilder _autor_3 = _calorias_3.autor("Dolly");
    RecetaBuilder _dificultad_3 = _autor_3.dificultad(RecetaBuilder.FACIL);
    RecetaBuilder _procesoPreparacion_3 = _dificultad_3.procesoPreparacion("Mezclar gelatina azucar y agua");
    RecetaBuilder _temporada_3 = _procesoPreparacion_3.temporada(RecetaBuilder.VERANO);
    IngredienteBuilder _ingredienteBuilder_5 = new IngredienteBuilder("gelatina");
    IngredienteBuilder _cantidad_9 = _ingredienteBuilder_5.cantidad(250);
    Ingrediente _build_12 = _cantidad_9.build();
    RecetaBuilder _agregarIngrediente_5 = _temporada_3.agregarIngrediente(_build_12);
    CondimentoBuilder _condimentoBuilder_4 = new CondimentoBuilder("azucar");
    CondimentoBuilder _cantidad_10 = _condimentoBuilder_4.cantidad(500);
    Condimento _build_13 = _cantidad_10.build();
    RecetaBuilder _agregarCondimento_4 = _agregarIngrediente_5.agregarCondimento(_build_13);
    Receta _build_14 = _agregarCondimento_4.build();
    this.gelatinaFrambuesa = _build_14;
    RecetaBuilder _recetaBuilder_4 = new RecetaBuilder("Ensalada");
    RecetaBuilder _calorias_4 = _recetaBuilder_4.calorias(10);
    RecetaBuilder _autor_4 = _calorias_4.autor("Antonio Gasalla");
    RecetaBuilder _dificultad_4 = _autor_4.dificultad(RecetaBuilder.FACIL);
    RecetaBuilder _procesoPreparacion_4 = _dificultad_4.procesoPreparacion("Cortar la verdura y mezclar. No olvidar de lavar");
    RecetaBuilder _temporada_4 = _procesoPreparacion_4.temporada(RecetaBuilder.PRIMAVERA);
    IngredienteBuilder _ingredienteBuilder_6 = new IngredienteBuilder("cebolla");
    IngredienteBuilder _cantidad_11 = _ingredienteBuilder_6.cantidad(150);
    Ingrediente _build_15 = _cantidad_11.build();
    RecetaBuilder _agregarIngrediente_6 = _temporada_4.agregarIngrediente(_build_15);
    IngredienteBuilder _ingredienteBuilder_7 = new IngredienteBuilder("lechuga");
    IngredienteBuilder _cantidad_12 = _ingredienteBuilder_7.cantidad(300);
    Ingrediente _build_16 = _cantidad_12.build();
    RecetaBuilder _agregarIngrediente_7 = _agregarIngrediente_6.agregarIngrediente(_build_16);
    IngredienteBuilder _ingredienteBuilder_8 = new IngredienteBuilder("tomate");
    IngredienteBuilder _cantidad_13 = _ingredienteBuilder_8.cantidad(150);
    Ingrediente _build_17 = _cantidad_13.build();
    RecetaBuilder _agregarIngrediente_8 = _agregarIngrediente_7.agregarIngrediente(_build_17);
    CondimentoBuilder _condimentoBuilder_5 = new CondimentoBuilder("sal");
    CondimentoBuilder _cantidad_14 = _condimentoBuilder_5.cantidad(2);
    Condimento _build_18 = _cantidad_14.build();
    RecetaBuilder _agregarCondimento_5 = _agregarIngrediente_8.agregarCondimento(_build_18);
    Receta _build_19 = _agregarCondimento_5.build();
    this.ensalada = _build_19;
    RecetaBuilder _recetaBuilder_5 = new RecetaBuilder("Arroz Blanco");
    RecetaBuilder _calorias_5 = _recetaBuilder_5.calorias(10);
    RecetaBuilder _autor_5 = _calorias_5.autor("Antonio Gasalla");
    RecetaBuilder _dificultad_5 = _autor_5.dificultad(RecetaBuilder.FACIL);
    RecetaBuilder _procesoPreparacion_5 = _dificultad_5.procesoPreparacion("Hervir el arroz. Comer.");
    RecetaBuilder _temporada_5 = _procesoPreparacion_5.temporada(RecetaBuilder.OTOÑO);
    IngredienteBuilder _ingredienteBuilder_9 = new IngredienteBuilder("arroz");
    IngredienteBuilder _cantidad_15 = _ingredienteBuilder_9.cantidad(500);
    Ingrediente _build_20 = _cantidad_15.build();
    RecetaBuilder _agregarIngrediente_9 = _temporada_5.agregarIngrediente(_build_20);
    Receta _build_21 = _agregarIngrediente_9.build();
    this.arrozBlanco = _build_21;
    this.recetas.add(this.arrozConPollo);
    this.recetas.add(this.fideosConManteca);
    this.recetas.add(this.lomoMostaza);
    this.recetas.add(this.gelatinaFrambuesa);
    this.recetas.add(this.arrozBlanco);
    this.recetas.add(this.ensalada);
  }
  
  public void agregarReceta(final Receta unaReceta) {
    this.recetas.add(unaReceta);
  }
  
  public void mirarRecetario() {
    final Consumer<Receta> _function = new Consumer<Receta>() {
      @Override
      public void accept(final Receta receta) {
        String _nombreDeLaReceta = receta.getNombreDeLaReceta();
        InputOutput.<String>println(_nombreDeLaReceta);
      }
    };
    this.recetas.forEach(_function);
  }
  
  public Receta elegirReceta(final String nombre) {
    Receta _xblockexpression = null;
    {
      Receta _busquedaReceta = this.busquedaReceta(nombre);
      boolean _equals = Objects.equal(_busquedaReceta, null);
      if (_equals) {
        throw new BusinessException("La receta buscada no existe.");
      }
      _xblockexpression = this.busquedaReceta(nombre);
    }
    return _xblockexpression;
  }
  
  public Receta busquedaReceta(final String nombreReceta) {
    final Function1<Receta, Boolean> _function = new Function1<Receta, Boolean>() {
      @Override
      public Boolean apply(final Receta receta) {
        String _nombreDeLaReceta = receta.getNombreDeLaReceta();
        return Boolean.valueOf(_nombreDeLaReceta.equals(nombreReceta));
      }
    };
    return IterableExtensions.<Receta>findFirst(this.recetas, _function);
  }
  
  /**
   * copiarReceta inicializa una nueva variable recetaTemporal, a
   * la que se le va a asignar la coincidencia de buscar la receta
   * requerida en el listado de recetas (metodo busquedaReceta)
   * luego se copiaran todos los atributos 1x1 de una receta a otra y
   *  se retornara la nueva Receta con todos los atributos copiados
   */
  public Receta copiarReceta(final Receta unaReceta, final String nombreReceta) {
    Receta _xblockexpression = null;
    {
      Receta recetaTemporal = this.busquedaReceta(nombreReceta);
      String _nombreDeLaReceta = recetaTemporal.getNombreDeLaReceta();
      unaReceta.setNombreDeLaReceta(_nombreDeLaReceta);
      double _calorias = recetaTemporal.getCalorias();
      unaReceta.setCalorias(_calorias);
      String _procesoDePreparacion = recetaTemporal.getProcesoDePreparacion();
      unaReceta.setProcesoDePreparacion(_procesoDePreparacion);
      String _dificultadDePreparacion = recetaTemporal.getDificultadDePreparacion();
      unaReceta.setDificultadDePreparacion(_dificultadDePreparacion);
      String _temporadaALaQueCorresponde = recetaTemporal.getTemporadaALaQueCorresponde();
      unaReceta.setTemporadaALaQueCorresponde(_temporadaALaQueCorresponde);
      List<Ingrediente> _ingredientes = recetaTemporal.getIngredientes();
      ArrayList<Ingrediente> _arrayList = new ArrayList<Ingrediente>(_ingredientes);
      unaReceta.setIngredientes(_arrayList);
      List<Condimento> _condimentos = recetaTemporal.getCondimentos();
      ArrayList<Condimento> _arrayList_1 = new ArrayList<Condimento>(_condimentos);
      unaReceta.setCondimentos(_arrayList_1);
      _xblockexpression = unaReceta;
    }
    return _xblockexpression;
  }
  
  @Pure
  public List<Receta> getRecetas() {
    return this.recetas;
  }
  
  public void setRecetas(final List<Receta> recetas) {
    this.recetas = recetas;
  }
  
  @Pure
  public Receta getLomoMostaza() {
    return this.lomoMostaza;
  }
  
  public void setLomoMostaza(final Receta lomoMostaza) {
    this.lomoMostaza = lomoMostaza;
  }
  
  @Pure
  public Receta getArrozConPollo() {
    return this.arrozConPollo;
  }
  
  public void setArrozConPollo(final Receta arrozConPollo) {
    this.arrozConPollo = arrozConPollo;
  }
  
  @Pure
  public Receta getFideosConManteca() {
    return this.fideosConManteca;
  }
  
  public void setFideosConManteca(final Receta fideosConManteca) {
    this.fideosConManteca = fideosConManteca;
  }
  
  @Pure
  public Receta getGelatinaFrambuesa() {
    return this.gelatinaFrambuesa;
  }
  
  public void setGelatinaFrambuesa(final Receta gelatinaFrambuesa) {
    this.gelatinaFrambuesa = gelatinaFrambuesa;
  }
  
  @Pure
  public Receta getEnsalada() {
    return this.ensalada;
  }
  
  public void setEnsalada(final Receta ensalada) {
    this.ensalada = ensalada;
  }
  
  @Pure
  public Receta getArrozBlanco() {
    return this.arrozBlanco;
  }
  
  public void setArrozBlanco(final Receta arrozBlanco) {
    this.arrozBlanco = arrozBlanco;
  }
}
