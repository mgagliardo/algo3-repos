package ar.tp.dieta;

import ar.tp.dieta.Busqueda;
import ar.tp.dieta.CondicionVegano;
import ar.tp.dieta.Condimento;
import ar.tp.dieta.CondimentoBuilder;
import ar.tp.dieta.ContadorConsultas;
import ar.tp.dieta.FiltroPorGustos;
import ar.tp.dieta.FiltroPorIngredienteCaro;
import ar.tp.dieta.Ingrediente;
import ar.tp.dieta.IngredienteBuilder;
import ar.tp.dieta.PosteriorBusquedaOrdenadoCalorias;
import ar.tp.dieta.Receta;
import ar.tp.dieta.RecetaBuilder;
import ar.tp.dieta.RecetarioPublico;
import ar.tp.dieta.RutinaActiva;
import ar.tp.dieta.Usuario;
import ar.tp.dieta.UsuarioBuilder;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestAccion2 {
  private ContadorConsultas observer = new ContadorConsultas();
  
  private List<Receta> recetas = new ArrayList<Receta>();
  
  private List<Usuario> usuarios = new ArrayList<Usuario>();
  
  private RecetarioPublico recetario = new RecetarioPublico();
  
  private String mensaje;
  
  private Busqueda busqueda1 = ObjectExtensions.<Busqueda>operator_doubleArrow(new Busqueda(), new Procedure1<Busqueda>() {
    @Override
    public void apply(final Busqueda it) {
      FiltroPorIngredienteCaro _filtroPorIngredienteCaro = new FiltroPorIngredienteCaro();
      it.agregarFiltro(_filtroPorIngredienteCaro);
    }
  });
  
  private Busqueda busqueda2 = ObjectExtensions.<Busqueda>operator_doubleArrow(new Busqueda(), new Procedure1<Busqueda>() {
    @Override
    public void apply(final Busqueda it) {
      PosteriorBusquedaOrdenadoCalorias _posteriorBusquedaOrdenadoCalorias = new PosteriorBusquedaOrdenadoCalorias();
      it.agregarFiltro(_posteriorBusquedaOrdenadoCalorias);
    }
  });
  
  private Busqueda busqueda3 = ObjectExtensions.<Busqueda>operator_doubleArrow(new Busqueda(), new Procedure1<Busqueda>() {
    @Override
    public void apply(final Busqueda it) {
      FiltroPorGustos _filtroPorGustos = new FiltroPorGustos();
      it.agregarFiltro(_filtroPorGustos);
    }
  });
  
  private RutinaActiva basket = ObjectExtensions.<RutinaActiva>operator_doubleArrow(new RutinaActiva(), new Procedure1<RutinaActiva>() {
    @Override
    public void apply(final RutinaActiva it) {
      it.setTiempoDeEjercicio(240);
    }
  });
  
  private Usuario usuarioVegano;
  
  private Receta arrozConPollo;
  
  private Receta fideosConManteca;
  
  private Receta lomoMostaza;
  
  private Receta gelatinaFrambuesa;
  
  private Receta ensalada;
  
  private Receta arrozBlanco;
  
  @Before
  public void init() {
    UsuarioBuilder _usuarioBuilder = new UsuarioBuilder("Miguel", "miguel");
    UsuarioBuilder _peso = _usuarioBuilder.peso(Double.valueOf(70.5));
    UsuarioBuilder _altura = _peso.altura(Double.valueOf(1.73));
    UsuarioBuilder _fechaNacimiento = _altura.fechaNacimiento(1989, 6, 28);
    UsuarioBuilder _sexo = _fechaNacimiento.sexo("M");
    UsuarioBuilder _rutina = _sexo.rutina(this.basket);
    CondicionVegano _condicionVegano = new CondicionVegano();
    UsuarioBuilder _condicion = _rutina.condicion(_condicionVegano);
    UsuarioBuilder _preferencia = _condicion.preferencia("fruta");
    UsuarioBuilder _email = _preferencia.email("soyvegano@edrans.com");
    Usuario _build = _email.build();
    this.usuarioVegano = _build;
    RecetaBuilder _recetaBuilder = new RecetaBuilder("Arroz con Pollo");
    RecetaBuilder _calorias = _recetaBuilder.calorias(500);
    RecetaBuilder _autor = _calorias.autor("Carlos Nahir");
    RecetaBuilder _dificultad = _autor.dificultad("Mediana");
    RecetaBuilder _procesoPreparacion = _dificultad.procesoPreparacion("Hervir el arroz con azafran y agregar el pollo previamente salteado");
    RecetaBuilder _temporada = _procesoPreparacion.temporada("Invierno");
    IngredienteBuilder _ingredienteBuilder = new IngredienteBuilder("arroz");
    IngredienteBuilder _cantidad = _ingredienteBuilder.cantidad(500);
    Ingrediente _build_1 = _cantidad.build();
    RecetaBuilder _agregarIngrediente = _temporada.agregarIngrediente(_build_1);
    IngredienteBuilder _ingredienteBuilder_1 = new IngredienteBuilder("pollo");
    IngredienteBuilder _cantidad_1 = _ingredienteBuilder_1.cantidad(1000);
    Ingrediente _build_2 = _cantidad_1.build();
    RecetaBuilder _agregarIngrediente_1 = _agregarIngrediente.agregarIngrediente(_build_2);
    CondimentoBuilder _condimentoBuilder = new CondimentoBuilder("azafran");
    CondimentoBuilder _cantidad_2 = _condimentoBuilder.cantidad(2);
    Condimento _build_3 = _cantidad_2.build();
    RecetaBuilder _agregarCondimento = _agregarIngrediente_1.agregarCondimento(_build_3);
    Receta _build_4 = _agregarCondimento.build();
    this.arrozConPollo = _build_4;
    RecetaBuilder _recetaBuilder_1 = new RecetaBuilder("Fideos con manteca");
    RecetaBuilder _calorias_1 = _recetaBuilder_1.calorias(600);
    RecetaBuilder _autor_1 = _calorias_1.autor("Narda Lepes");
    RecetaBuilder _dificultad_1 = _autor_1.dificultad("Facil");
    RecetaBuilder _procesoPreparacion_1 = _dificultad_1.procesoPreparacion("Hervir los fideos. Colar.");
    RecetaBuilder _temporada_1 = _procesoPreparacion_1.temporada("Invierno");
    IngredienteBuilder _ingredienteBuilder_2 = new IngredienteBuilder("pasta");
    IngredienteBuilder _cantidad_3 = _ingredienteBuilder_2.cantidad(500);
    Ingrediente _build_5 = _cantidad_3.build();
    RecetaBuilder _agregarIngrediente_2 = _temporada_1.agregarIngrediente(_build_5);
    CondimentoBuilder _condimentoBuilder_1 = new CondimentoBuilder("sal");
    CondimentoBuilder _cantidad_4 = _condimentoBuilder_1.cantidad(2);
    Condimento _build_6 = _cantidad_4.build();
    RecetaBuilder _agregarCondimento_1 = _agregarIngrediente_2.agregarCondimento(_build_6);
    IngredienteBuilder _ingredienteBuilder_3 = new IngredienteBuilder("manteca");
    IngredienteBuilder _cantidad_5 = _ingredienteBuilder_3.cantidad(10);
    Ingrediente _build_7 = _cantidad_5.build();
    RecetaBuilder _agregarIngrediente_3 = _agregarCondimento_1.agregarIngrediente(_build_7);
    Receta _build_8 = _agregarIngrediente_3.build();
    this.fideosConManteca = _build_8;
    RecetaBuilder _recetaBuilder_2 = new RecetaBuilder("Lomo a la Mostaza");
    RecetaBuilder _calorias_2 = _recetaBuilder_2.calorias(1200);
    RecetaBuilder _autor_2 = _calorias_2.autor("Mirtha Legrand");
    RecetaBuilder _dificultad_2 = _autor_2.dificultad("Dificil");
    RecetaBuilder _procesoPreparacion_2 = _dificultad_2.procesoPreparacion("Poner el lomo con la mostaza en el horno.");
    RecetaBuilder _temporada_2 = _procesoPreparacion_2.temporada("Verano");
    IngredienteBuilder _ingredienteBuilder_4 = new IngredienteBuilder("lomo");
    IngredienteBuilder _cantidad_6 = _ingredienteBuilder_4.cantidad(1000);
    Ingrediente _build_9 = _cantidad_6.build();
    RecetaBuilder _agregarIngrediente_4 = _temporada_2.agregarIngrediente(_build_9);
    CondimentoBuilder _condimentoBuilder_2 = new CondimentoBuilder("sal");
    CondimentoBuilder _cantidad_7 = _condimentoBuilder_2.cantidad(2);
    Condimento _build_10 = _cantidad_7.build();
    RecetaBuilder _agregarCondimento_2 = _agregarIngrediente_4.agregarCondimento(_build_10);
    CondimentoBuilder _condimentoBuilder_3 = new CondimentoBuilder("mostaza");
    CondimentoBuilder _cantidad_8 = _condimentoBuilder_3.cantidad(30);
    Condimento _build_11 = _cantidad_8.build();
    RecetaBuilder _agregarCondimento_3 = _agregarCondimento_2.agregarCondimento(_build_11);
    Receta _build_12 = _agregarCondimento_3.build();
    this.lomoMostaza = _build_12;
    RecetaBuilder _recetaBuilder_3 = new RecetaBuilder("Gelatina de Frambuesa");
    RecetaBuilder _calorias_3 = _recetaBuilder_3.calorias(120);
    RecetaBuilder _autor_3 = _calorias_3.autor("Dolly");
    RecetaBuilder _dificultad_3 = _autor_3.dificultad("Facil");
    RecetaBuilder _procesoPreparacion_3 = _dificultad_3.procesoPreparacion("Mezclar gelatina azucar y agua");
    RecetaBuilder _temporada_3 = _procesoPreparacion_3.temporada("Verano");
    IngredienteBuilder _ingredienteBuilder_5 = new IngredienteBuilder("gelatina");
    IngredienteBuilder _cantidad_9 = _ingredienteBuilder_5.cantidad(250);
    Ingrediente _build_13 = _cantidad_9.build();
    RecetaBuilder _agregarIngrediente_5 = _temporada_3.agregarIngrediente(_build_13);
    CondimentoBuilder _condimentoBuilder_4 = new CondimentoBuilder("azucar");
    CondimentoBuilder _cantidad_10 = _condimentoBuilder_4.cantidad(500);
    Condimento _build_14 = _cantidad_10.build();
    RecetaBuilder _agregarCondimento_4 = _agregarIngrediente_5.agregarCondimento(_build_14);
    Receta _build_15 = _agregarCondimento_4.build();
    this.gelatinaFrambuesa = _build_15;
    RecetaBuilder _recetaBuilder_4 = new RecetaBuilder("Ensalada");
    RecetaBuilder _calorias_4 = _recetaBuilder_4.calorias(10);
    RecetaBuilder _autor_4 = _calorias_4.autor("Antonio Gasalla");
    RecetaBuilder _dificultad_4 = _autor_4.dificultad("Facil");
    RecetaBuilder _procesoPreparacion_4 = _dificultad_4.procesoPreparacion("Cortar la verdura y mezclar. No olvidar de lavar");
    RecetaBuilder _temporada_4 = _procesoPreparacion_4.temporada("Verano");
    IngredienteBuilder _ingredienteBuilder_6 = new IngredienteBuilder("cebolla");
    IngredienteBuilder _cantidad_11 = _ingredienteBuilder_6.cantidad(150);
    Ingrediente _build_16 = _cantidad_11.build();
    RecetaBuilder _agregarIngrediente_6 = _temporada_4.agregarIngrediente(_build_16);
    IngredienteBuilder _ingredienteBuilder_7 = new IngredienteBuilder("lechuga");
    IngredienteBuilder _cantidad_12 = _ingredienteBuilder_7.cantidad(300);
    Ingrediente _build_17 = _cantidad_12.build();
    RecetaBuilder _agregarIngrediente_7 = _agregarIngrediente_6.agregarIngrediente(_build_17);
    IngredienteBuilder _ingredienteBuilder_8 = new IngredienteBuilder("tomate");
    IngredienteBuilder _cantidad_13 = _ingredienteBuilder_8.cantidad(150);
    Ingrediente _build_18 = _cantidad_13.build();
    RecetaBuilder _agregarIngrediente_8 = _agregarIngrediente_7.agregarIngrediente(_build_18);
    CondimentoBuilder _condimentoBuilder_5 = new CondimentoBuilder("sal");
    CondimentoBuilder _cantidad_14 = _condimentoBuilder_5.cantidad(2);
    Condimento _build_19 = _cantidad_14.build();
    RecetaBuilder _agregarCondimento_5 = _agregarIngrediente_8.agregarCondimento(_build_19);
    Receta _build_20 = _agregarCondimento_5.build();
    this.ensalada = _build_20;
    RecetaBuilder _recetaBuilder_5 = new RecetaBuilder("Arroz Blanco");
    RecetaBuilder _calorias_5 = _recetaBuilder_5.calorias(10);
    RecetaBuilder _autor_5 = _calorias_5.autor("Antonio Gasalla");
    RecetaBuilder _dificultad_5 = _autor_5.dificultad("Facil");
    RecetaBuilder _procesoPreparacion_5 = _dificultad_5.procesoPreparacion("Hervir el arroz. Comer.");
    RecetaBuilder _temporada_5 = _procesoPreparacion_5.temporada("Invierno");
    IngredienteBuilder _ingredienteBuilder_9 = new IngredienteBuilder("arroz");
    IngredienteBuilder _cantidad_15 = _ingredienteBuilder_9.cantidad(500);
    Ingrediente _build_21 = _cantidad_15.build();
    RecetaBuilder _agregarIngrediente_9 = _temporada_5.agregarIngrediente(_build_21);
    Receta _build_22 = _agregarIngrediente_9.build();
    this.arrozBlanco = _build_22;
    this.recetario.agregarReceta(this.arrozConPollo);
    this.recetario.agregarReceta(this.fideosConManteca);
    this.recetario.agregarReceta(this.lomoMostaza);
    this.recetario.agregarReceta(this.gelatinaFrambuesa);
    this.recetario.agregarReceta(this.ensalada);
    this.recetario.agregarReceta(this.arrozBlanco);
    this.usuarioVegano.recetario = this.recetario;
    this.usuarios.add(this.usuarioVegano);
    this.usuarioVegano.setObserverConsulta(this.observer);
  }
  
  @Test
  public void testeo() {
    this.usuarioVegano.agregarBusqueda(this.busqueda1);
    this.usuarioVegano.busquedaFiltrada();
    ContadorConsultas _observerConsulta = this.usuarioVegano.getObserverConsulta();
    _observerConsulta.getRecetasFinales();
    this.usuarioVegano.removerBusqueda(this.busqueda1);
    this.usuarioVegano.agregarBusqueda(this.busqueda2);
    this.usuarioVegano.busquedaFiltrada();
    ContadorConsultas _observerConsulta_1 = this.usuarioVegano.getObserverConsulta();
    _observerConsulta_1.getRecetasFinales();
  }
}
