package ar.tp.dieta;

import ar.tp.dieta.Busqueda;
import ar.tp.dieta.CondicionCeliaco;
import ar.tp.dieta.CondicionDiabetes;
import ar.tp.dieta.CondicionHipertension;
import ar.tp.dieta.CondicionVegano;
import ar.tp.dieta.Condimento;
import ar.tp.dieta.CondimentoBuilder;
import ar.tp.dieta.Grupo;
import ar.tp.dieta.Ingrediente;
import ar.tp.dieta.IngredienteBuilder;
import ar.tp.dieta.Receta;
import ar.tp.dieta.RecetaBuilder;
import ar.tp.dieta.RecetarioPublico;
import ar.tp.dieta.RutinaActiva;
import ar.tp.dieta.RutinaSedentaria;
import ar.tp.dieta.Usuario;
import ar.tp.dieta.UsuarioBuilder;
import java.util.List;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Before;

@SuppressWarnings("all")
public abstract class TestRepositorio {
  protected Ingrediente pollo;
  
  protected Ingrediente arroz;
  
  protected Condimento azafran;
  
  protected Condimento sal;
  
  protected Ingrediente cebolla;
  
  protected Ingrediente lomo;
  
  protected Condimento azucar;
  
  protected Ingrediente cereal;
  
  protected Ingrediente pasta;
  
  protected Ingrediente mostaza;
  
  protected Ingrediente manteca;
  
  protected Ingrediente gelatina;
  
  protected Ingrediente tomate;
  
  protected Ingrediente lechuga;
  
  protected Receta arrozConPollo;
  
  protected Receta lomoMostaza;
  
  protected Receta fideosConManteca;
  
  protected Receta gelatinaFrambuesa;
  
  protected Receta ensalada;
  
  protected Receta arrozBlanco;
  
  protected RecetarioPublico recetarioPublico;
  
  protected Usuario usuarioVegano;
  
  protected Usuario usuarioHipertenso;
  
  protected Usuario usuarioSinCondicion;
  
  protected Usuario usuarioCeliaco;
  
  protected Usuario usuarioDiabetico;
  
  protected Usuario usuarioMujerDiabetica;
  
  protected Usuario usuarioMujerSinCondicion;
  
  protected Grupo grupoHipertenso = new Grupo();
  
  protected RutinaActiva taeBo;
  
  protected RutinaActiva basket;
  
  protected RutinaSedentaria gaming;
  
  protected RutinaSedentaria programacion;
  
  protected Busqueda busqueda;
  
  @Before
  public void init() {
    IngredienteBuilder _ingredienteBuilder = new IngredienteBuilder("arroz");
    IngredienteBuilder _cantidad = _ingredienteBuilder.cantidad(500);
    Ingrediente _build = _cantidad.build();
    this.arroz = _build;
    CondimentoBuilder _condimentoBuilder = new CondimentoBuilder("azafran");
    CondimentoBuilder _cantidad_1 = _condimentoBuilder.cantidad(2);
    Condimento _build_1 = _cantidad_1.build();
    this.azafran = _build_1;
    IngredienteBuilder _ingredienteBuilder_1 = new IngredienteBuilder("pollo");
    IngredienteBuilder _cantidad_2 = _ingredienteBuilder_1.cantidad(1000);
    Ingrediente _build_2 = _cantidad_2.build();
    this.pollo = _build_2;
    IngredienteBuilder _ingredienteBuilder_2 = new IngredienteBuilder("lomo");
    IngredienteBuilder _cantidad_3 = _ingredienteBuilder_2.cantidad(1000);
    Ingrediente _build_3 = _cantidad_3.build();
    this.lomo = _build_3;
    CondimentoBuilder _condimentoBuilder_1 = new CondimentoBuilder("azucar");
    CondimentoBuilder _cantidad_4 = _condimentoBuilder_1.cantidad(500);
    Condimento _build_4 = _cantidad_4.build();
    this.azucar = _build_4;
    IngredienteBuilder _ingredienteBuilder_3 = new IngredienteBuilder("pasta");
    IngredienteBuilder _cantidad_5 = _ingredienteBuilder_3.cantidad(500);
    Ingrediente _build_5 = _cantidad_5.build();
    this.pasta = _build_5;
    CondimentoBuilder _condimentoBuilder_2 = new CondimentoBuilder("sal");
    CondimentoBuilder _cantidad_6 = _condimentoBuilder_2.cantidad(2);
    Condimento _build_6 = _cantidad_6.build();
    this.sal = _build_6;
    IngredienteBuilder _ingredienteBuilder_4 = new IngredienteBuilder("cebolla");
    IngredienteBuilder _cantidad_7 = _ingredienteBuilder_4.cantidad(150);
    Ingrediente _build_7 = _cantidad_7.build();
    this.cebolla = _build_7;
    IngredienteBuilder _ingredienteBuilder_5 = new IngredienteBuilder("mostaza");
    IngredienteBuilder _cantidad_8 = _ingredienteBuilder_5.cantidad(30);
    Ingrediente _build_8 = _cantidad_8.build();
    this.mostaza = _build_8;
    IngredienteBuilder _ingredienteBuilder_6 = new IngredienteBuilder("manteca");
    IngredienteBuilder _cantidad_9 = _ingredienteBuilder_6.cantidad(10);
    Ingrediente _build_9 = _cantidad_9.build();
    this.manteca = _build_9;
    IngredienteBuilder _ingredienteBuilder_7 = new IngredienteBuilder("gelatina");
    IngredienteBuilder _cantidad_10 = _ingredienteBuilder_7.cantidad(250);
    Ingrediente _build_10 = _cantidad_10.build();
    this.gelatina = _build_10;
    IngredienteBuilder _ingredienteBuilder_8 = new IngredienteBuilder("tomate");
    IngredienteBuilder _cantidad_11 = _ingredienteBuilder_8.cantidad(150);
    Ingrediente _build_11 = _cantidad_11.build();
    this.tomate = _build_11;
    IngredienteBuilder _ingredienteBuilder_9 = new IngredienteBuilder("lechuga");
    IngredienteBuilder _cantidad_12 = _ingredienteBuilder_9.cantidad(300);
    Ingrediente _build_12 = _cantidad_12.build();
    this.lechuga = _build_12;
    RecetaBuilder _recetaBuilder = new RecetaBuilder("Arroz con Pollo");
    RecetaBuilder _calorias = _recetaBuilder.calorias(500);
    RecetaBuilder _autor = _calorias.autor("Carlos Nahir");
    RecetaBuilder _dificultad = _autor.dificultad("Mediana");
    RecetaBuilder _procesoPreparacion = _dificultad.procesoPreparacion("Hervir el arroz con azafran y agregar el pollo previamente salteado");
    RecetaBuilder _temporada = _procesoPreparacion.temporada("Invierno");
    RecetaBuilder _agregarIngrediente = _temporada.agregarIngrediente(this.arroz);
    RecetaBuilder _agregarIngrediente_1 = _agregarIngrediente.agregarIngrediente(this.pollo);
    RecetaBuilder _agregarCondimento = _agregarIngrediente_1.agregarCondimento(this.azafran);
    Receta _build_13 = _agregarCondimento.build();
    this.arrozConPollo = _build_13;
    RecetaBuilder _recetaBuilder_1 = new RecetaBuilder("Fideos con manteca");
    RecetaBuilder _calorias_1 = _recetaBuilder_1.calorias(600);
    RecetaBuilder _autor_1 = _calorias_1.autor("Narda Lepes");
    RecetaBuilder _dificultad_1 = _autor_1.dificultad("Facil");
    RecetaBuilder _procesoPreparacion_1 = _dificultad_1.procesoPreparacion("Hervir los fideos. Colar.");
    RecetaBuilder _temporada_1 = _procesoPreparacion_1.temporada("Invierno");
    RecetaBuilder _agregarIngrediente_2 = _temporada_1.agregarIngrediente(this.pasta);
    RecetaBuilder _agregarCondimento_1 = _agregarIngrediente_2.agregarCondimento(this.sal);
    RecetaBuilder _agregarIngrediente_3 = _agregarCondimento_1.agregarIngrediente(this.manteca);
    Receta _build_14 = _agregarIngrediente_3.build();
    this.fideosConManteca = _build_14;
    RecetaBuilder _recetaBuilder_2 = new RecetaBuilder("Lomo a la Mostaza");
    RecetaBuilder _calorias_2 = _recetaBuilder_2.calorias(1200);
    RecetaBuilder _autor_2 = _calorias_2.autor("Mirtha Legrand");
    RecetaBuilder _dificultad_2 = _autor_2.dificultad("Dificil");
    RecetaBuilder _procesoPreparacion_2 = _dificultad_2.procesoPreparacion("Poner el lomo con la mostaza en el horno.");
    RecetaBuilder _temporada_2 = _procesoPreparacion_2.temporada("Verano");
    RecetaBuilder _agregarIngrediente_4 = _temporada_2.agregarIngrediente(this.lomo);
    RecetaBuilder _agregarCondimento_2 = _agregarIngrediente_4.agregarCondimento(this.sal);
    RecetaBuilder _agregarIngrediente_5 = _agregarCondimento_2.agregarIngrediente(this.mostaza);
    Receta _build_15 = _agregarIngrediente_5.build();
    this.lomoMostaza = _build_15;
    RecetaBuilder _recetaBuilder_3 = new RecetaBuilder("Gelatina de Frambuesa");
    RecetaBuilder _calorias_3 = _recetaBuilder_3.calorias(120);
    RecetaBuilder _autor_3 = _calorias_3.autor("Dolly");
    RecetaBuilder _dificultad_3 = _autor_3.dificultad("Facil");
    RecetaBuilder _procesoPreparacion_3 = _dificultad_3.procesoPreparacion("Mezclar gelatina azucar y agua");
    RecetaBuilder _temporada_3 = _procesoPreparacion_3.temporada("Verano");
    RecetaBuilder _agregarIngrediente_6 = _temporada_3.agregarIngrediente(this.gelatina);
    RecetaBuilder _agregarCondimento_3 = _agregarIngrediente_6.agregarCondimento(this.azucar);
    Receta _build_16 = _agregarCondimento_3.build();
    this.gelatinaFrambuesa = _build_16;
    RecetaBuilder _recetaBuilder_4 = new RecetaBuilder("Ensalada");
    RecetaBuilder _calorias_4 = _recetaBuilder_4.calorias(10);
    RecetaBuilder _autor_4 = _calorias_4.autor("Antonio Gasalla");
    RecetaBuilder _dificultad_4 = _autor_4.dificultad("Facil");
    RecetaBuilder _procesoPreparacion_4 = _dificultad_4.procesoPreparacion("Cortar la verdura y mezclar. No olvidar de lavar");
    RecetaBuilder _temporada_4 = _procesoPreparacion_4.temporada("Verano");
    RecetaBuilder _agregarIngrediente_7 = _temporada_4.agregarIngrediente(this.cebolla);
    RecetaBuilder _agregarIngrediente_8 = _agregarIngrediente_7.agregarIngrediente(this.lechuga);
    RecetaBuilder _agregarIngrediente_9 = _agregarIngrediente_8.agregarIngrediente(this.tomate);
    RecetaBuilder _agregarCondimento_4 = _agregarIngrediente_9.agregarCondimento(this.sal);
    Receta _build_17 = _agregarCondimento_4.build();
    this.ensalada = _build_17;
    RecetaBuilder _recetaBuilder_5 = new RecetaBuilder("Arroz Blanco");
    RecetaBuilder _calorias_5 = _recetaBuilder_5.calorias(10);
    RecetaBuilder _autor_5 = _calorias_5.autor("Antonio Gasalla");
    RecetaBuilder _dificultad_5 = _autor_5.dificultad("Facil");
    RecetaBuilder _procesoPreparacion_5 = _dificultad_5.procesoPreparacion("Hervir el arroz. Comer.");
    RecetaBuilder _temporada_5 = _procesoPreparacion_5.temporada("Invierno");
    RecetaBuilder _agregarIngrediente_10 = _temporada_5.agregarIngrediente(this.arroz);
    Receta _build_18 = _agregarIngrediente_10.build();
    this.arrozBlanco = _build_18;
    RecetarioPublico _recetarioPublico = new RecetarioPublico();
    this.recetarioPublico = _recetarioPublico;
    List<Receta> _recetas = this.recetarioPublico.getRecetas();
    _recetas.add(this.arrozConPollo);
    List<Receta> _recetas_1 = this.recetarioPublico.getRecetas();
    _recetas_1.add(this.lomoMostaza);
    Busqueda _busqueda = new Busqueda();
    this.busqueda = _busqueda;
    RutinaActiva _rutinaActiva = new RutinaActiva();
    final Procedure1<RutinaActiva> _function = new Procedure1<RutinaActiva>() {
      @Override
      public void apply(final RutinaActiva it) {
        it.setTiempoDeEjercicio(90);
      }
    };
    RutinaActiva _doubleArrow = ObjectExtensions.<RutinaActiva>operator_doubleArrow(_rutinaActiva, _function);
    this.taeBo = _doubleArrow;
    RutinaSedentaria _rutinaSedentaria = new RutinaSedentaria();
    final Procedure1<RutinaSedentaria> _function_1 = new Procedure1<RutinaSedentaria>() {
      @Override
      public void apply(final RutinaSedentaria it) {
        it.setTiempoDeEjercicio(0);
      }
    };
    RutinaSedentaria _doubleArrow_1 = ObjectExtensions.<RutinaSedentaria>operator_doubleArrow(_rutinaSedentaria, _function_1);
    this.gaming = _doubleArrow_1;
    RutinaSedentaria _rutinaSedentaria_1 = new RutinaSedentaria();
    final Procedure1<RutinaSedentaria> _function_2 = new Procedure1<RutinaSedentaria>() {
      @Override
      public void apply(final RutinaSedentaria it) {
        it.setTiempoDeEjercicio(30);
      }
    };
    RutinaSedentaria _doubleArrow_2 = ObjectExtensions.<RutinaSedentaria>operator_doubleArrow(_rutinaSedentaria_1, _function_2);
    this.programacion = _doubleArrow_2;
    RutinaActiva _rutinaActiva_1 = new RutinaActiva();
    final Procedure1<RutinaActiva> _function_3 = new Procedure1<RutinaActiva>() {
      @Override
      public void apply(final RutinaActiva it) {
        it.setTiempoDeEjercicio(240);
      }
    };
    RutinaActiva _doubleArrow_3 = ObjectExtensions.<RutinaActiva>operator_doubleArrow(_rutinaActiva_1, _function_3);
    this.basket = _doubleArrow_3;
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
    Usuario _build_19 = _email.build();
    this.usuarioVegano = _build_19;
    UsuarioBuilder _usuarioBuilder_1 = new UsuarioBuilder("Juan", "juan");
    UsuarioBuilder _peso_1 = _usuarioBuilder_1.peso(Double.valueOf(70.4));
    UsuarioBuilder _altura_1 = _peso_1.altura(Double.valueOf(1.83));
    UsuarioBuilder _fechaNacimiento_1 = _altura_1.fechaNacimiento(1992, 6, 4);
    UsuarioBuilder _sexo_1 = _fechaNacimiento_1.sexo("M");
    UsuarioBuilder _rutina_1 = _sexo_1.rutina(this.gaming);
    UsuarioBuilder _preferencia_1 = _rutina_1.preferencia("carne");
    UsuarioBuilder _preferencia_2 = _preferencia_1.preferencia("pescado");
    UsuarioBuilder _email_1 = _preferencia_2.email("usuariosincondicion@mail.com");
    Usuario _build_20 = _email_1.build();
    this.usuarioSinCondicion = _build_20;
    UsuarioBuilder _usuarioBuilder_2 = new UsuarioBuilder("Marcela", "marcela");
    UsuarioBuilder _peso_2 = _usuarioBuilder_2.peso(Double.valueOf(60.4));
    UsuarioBuilder _altura_2 = _peso_2.altura(Double.valueOf(1.83));
    UsuarioBuilder _fechaNacimiento_2 = _altura_2.fechaNacimiento(1992, 6, 4);
    UsuarioBuilder _sexo_2 = _fechaNacimiento_2.sexo("F");
    UsuarioBuilder _rutina_2 = _sexo_2.rutina(this.basket);
    UsuarioBuilder _preferencia_3 = _rutina_2.preferencia("carne");
    UsuarioBuilder _preferencia_4 = _preferencia_3.preferencia("pescado");
    UsuarioBuilder _email_2 = _preferencia_4.email("mujersincondicion@test.com");
    Usuario _build_21 = _email_2.build();
    this.usuarioMujerSinCondicion = _build_21;
    UsuarioBuilder _usuarioBuilder_3 = new UsuarioBuilder("Daniel", "daniel");
    UsuarioBuilder _peso_3 = _usuarioBuilder_3.peso(Double.valueOf(103.1));
    UsuarioBuilder _altura_3 = _peso_3.altura(Double.valueOf(1.85));
    UsuarioBuilder _fechaNacimiento_3 = _altura_3.fechaNacimiento(1992, 11, 20);
    UsuarioBuilder _sexo_3 = _fechaNacimiento_3.sexo("M");
    UsuarioBuilder _rutina_3 = _sexo_3.rutina(this.basket);
    CondicionCeliaco _condicionCeliaco = new CondicionCeliaco();
    UsuarioBuilder _condicion_1 = _rutina_3.condicion(_condicionCeliaco);
    UsuarioBuilder _preferencia_5 = _condicion_1.preferencia("fideos");
    UsuarioBuilder _email_3 = _preferencia_5.email("userceliaco@email.com");
    Usuario _build_22 = _email_3.build();
    this.usuarioCeliaco = _build_22;
    UsuarioBuilder _usuarioBuilder_4 = new UsuarioBuilder("Gabriel", "gabriel");
    UsuarioBuilder _peso_4 = _usuarioBuilder_4.peso(Double.valueOf(83.8));
    UsuarioBuilder _altura_4 = _peso_4.altura(Double.valueOf(1.83));
    UsuarioBuilder _fechaNacimiento_4 = _altura_4.fechaNacimiento(1987, 1, 8);
    UsuarioBuilder _sexo_4 = _fechaNacimiento_4.sexo("M");
    UsuarioBuilder _rutina_4 = _sexo_4.rutina(this.taeBo);
    UsuarioBuilder _preferencia_6 = _rutina_4.preferencia("limon");
    CondicionHipertension _condicionHipertension = new CondicionHipertension();
    UsuarioBuilder _condicion_2 = _preferencia_6.condicion(_condicionHipertension);
    UsuarioBuilder _email_4 = _condicion_2.email("usuariohipertenso@mail.com");
    Usuario _build_23 = _email_4.build();
    this.usuarioHipertenso = _build_23;
    UsuarioBuilder _usuarioBuilder_5 = new UsuarioBuilder("Nicolas", "nicolas");
    UsuarioBuilder _peso_5 = _usuarioBuilder_5.peso(Double.valueOf(78.8));
    UsuarioBuilder _altura_5 = _peso_5.altura(Double.valueOf(1.76));
    UsuarioBuilder _fechaNacimiento_5 = _altura_5.fechaNacimiento(1980, 2, 12);
    UsuarioBuilder _sexo_5 = _fechaNacimiento_5.sexo("M");
    UsuarioBuilder _rutina_5 = _sexo_5.rutina(this.programacion);
    CondicionDiabetes _condicionDiabetes = new CondicionDiabetes();
    UsuarioBuilder _condicion_3 = _rutina_5.condicion(_condicionDiabetes);
    UsuarioBuilder _preferencia_7 = _condicion_3.preferencia("ensalada");
    UsuarioBuilder _email_5 = _preferencia_7.email("usuariodiabetico@tutopia.com");
    Usuario _build_24 = _email_5.build();
    this.usuarioDiabetico = _build_24;
    UsuarioBuilder _usuarioBuilder_6 = new UsuarioBuilder("Marina", "marina");
    UsuarioBuilder _peso_6 = _usuarioBuilder_6.peso(Double.valueOf(55.8));
    UsuarioBuilder _altura_6 = _peso_6.altura(Double.valueOf(1.66));
    UsuarioBuilder _fechaNacimiento_6 = _altura_6.fechaNacimiento(1965, 2, 12);
    UsuarioBuilder _sexo_6 = _fechaNacimiento_6.sexo("F");
    UsuarioBuilder _rutina_6 = _sexo_6.rutina(this.taeBo);
    CondicionDiabetes _condicionDiabetes_1 = new CondicionDiabetes();
    UsuarioBuilder _condicion_4 = _rutina_6.condicion(_condicionDiabetes_1);
    UsuarioBuilder _preferencia_8 = _condicion_4.preferencia("fruta");
    UsuarioBuilder _email_6 = _preferencia_8.email("mujerdiabetica@gratis1.com");
    Usuario _build_25 = _email_6.build();
    this.usuarioMujerDiabetica = _build_25;
  }
}
