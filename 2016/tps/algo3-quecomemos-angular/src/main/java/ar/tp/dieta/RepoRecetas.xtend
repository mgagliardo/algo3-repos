package ar.tp.dieta

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class RepoRecetas {

	protected Ingrediente pollo
	protected Ingrediente arroz
	protected Condimento azafran
	protected Condimento sal
	protected Ingrediente cebolla
	protected Ingrediente lomo
	protected Condimento azucar
	protected Ingrediente cereal
	protected Ingrediente pasta
	protected Ingrediente mostaza
	protected Ingrediente manteca
	protected Ingrediente gelatina
	protected Ingrediente tomate
	protected Ingrediente lechuga
	protected Ingrediente salmon
	protected Ingrediente lechon
	protected Ingrediente molleja
	protected Ingrediente vacio
	protected Ingrediente pechitoDeCerdo	
		
	public Receta lomoMostaza
	public Receta arrozConPollo	
	public Receta fideosConManteca
	public Receta gelatinaFrambuesa
	public Receta ensalada
	public Receta arrozBlanco
	public Receta asado
	
	public RecetarioPublico recetarioPublico
	
	new(){	
		arroz = new IngredienteBuilder("arroz").cantidad(500).build()
		pollo = new IngredienteBuilder("pollo").cantidad(1000).build()
		lomo = new IngredienteBuilder("lomo").cantidad(1000).build()
		pasta = new IngredienteBuilder("pasta").cantidad(500).build()

		cebolla = new IngredienteBuilder("cebolla").cantidad(150).build()
		mostaza = new IngredienteBuilder("mostaza").cantidad(30).build()
		manteca= new IngredienteBuilder("manteca").cantidad(10).build()
		gelatina= new IngredienteBuilder("gelatina").cantidad(250).build()
		tomate = new IngredienteBuilder("tomate").cantidad(150).build()
		lechuga = new IngredienteBuilder("lechuga").cantidad(300).build()
		molleja = new IngredienteBuilder("molleja").cantidad(300).build()
		vacio = new IngredienteBuilder("vacio").cantidad(1500).build()
		pechitoDeCerdo = new IngredienteBuilder("pechito de cerdo").cantidad(1500).build

		azucar = new CondimentoBuilder("azucar").cantidad(500).build()
		azafran = new CondimentoBuilder("azafran").cantidad(2).build()
		sal = new CondimentoBuilder("sal").cantidad(2).build()
				
		arrozConPollo = new RecetaBuilder("Arroz con Pollo").calorias(500).autor("Carlos Nahir").dificultad(RecetaBuilder.MEDIA).procesoPreparacion("Hervir el arroz con azafran y agregar el pollo previamente salteado").temporada(RecetaBuilder.OTONIO).agregarIngrediente(arroz).agregarIngrediente(pollo).agregarCondimento(azafran).build()
		fideosConManteca = new RecetaBuilder("Fideos con manteca").calorias(600).autor("Narda Lepes").dificultad(RecetaBuilder.FACIL).procesoPreparacion("Hervir los fideos. Colar.").temporada(RecetaBuilder.INVIERNO).agregarIngrediente(pasta).agregarCondimento(sal).agregarIngrediente(manteca).build()
		lomoMostaza = new RecetaBuilder("Lomo a la Mostaza").calorias(1200).autor("Mirtha Legrand").dificultad(RecetaBuilder.DIFICIL).procesoPreparacion("Poner el lomo con la mostaza en el horno.").temporada(RecetaBuilder.VERANO).agregarIngrediente(lomo).agregarCondimento(sal).agregarIngrediente(mostaza).build()
		gelatinaFrambuesa = new RecetaBuilder("Gelatina de Frambuesa").calorias(120).autor("Dolly").dificultad(RecetaBuilder.FACIL).procesoPreparacion("Mezclar gelatina azucar y agua").temporada(RecetaBuilder.VERANO).agregarIngrediente(gelatina).agregarCondimento(azucar).build()
		ensalada = new RecetaBuilder("Ensalada").calorias(100).autor("Antonio Gasalla").dificultad(RecetaBuilder.FACIL).procesoPreparacion("Cortar la verdura y mezclar. No olvidar de lavar").temporada(RecetaBuilder.TODOELANIO).agregarIngrediente(cebolla).agregarIngrediente(lechuga).agregarIngrediente(tomate).agregarCondimento(sal).build()
		arrozBlanco = new RecetaBuilder("Arroz Blanco").calorias(250).autor("Antonio Gasalla").dificultad(RecetaBuilder.FACIL).procesoPreparacion("Hervir el arroz. Comer.").temporada(RecetaBuilder.INVIERNO).agregarIngrediente(arroz).build()
		asado = new RecetaBuilder("Asado").calorias(2500).autor("Francis Mallman").dificultad(RecetaBuilder.MEDIA).procesoPreparacion("Prender el fuego y asar la carne. Condimentar a gusto").temporada(RecetaBuilder.TODOELANIO).agregarIngrediente(pechitoDeCerdo).agregarIngrediente(vacio).agregarIngrediente(pollo).agregarIngrediente(molleja).build()		

		recetarioPublico = new RecetarioPublico
		recetarioPublico.recetas.add(arrozConPollo)
		recetarioPublico.recetas.add(lomoMostaza)
		recetarioPublico.recetas.add(fideosConManteca)
		recetarioPublico.recetas.add(gelatinaFrambuesa)
		recetarioPublico.recetas.add(ensalada)
		recetarioPublico.recetas.add(arrozBlanco)
		recetarioPublico.recetas.add(asado)

	}	
		
}