package ar.tp.dieta

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.ArrayList
import java.util.GregorianCalendar
import java.util.Iterator
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

//ENTREGA 1
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors
class Usuario extends Miembro {
	String contrasenia
	Double peso
	Double altura
	GregorianCalendar fechaDeNacimiento
	GregorianCalendar diaDeHoy
	String sexo
	Rutina rutina
	List<Condicion> condicionesPreexistentes = new ArrayList<Condicion>
	List<String> comidasQueNoMeGustan = new ArrayList<String>
	List<Receta> misRecetas = new ArrayList<Receta>
	List<Grupo> misGrupos = new ArrayList<Grupo>
	List<String> recetasFavoritas = new ArrayList<String>
	Busqueda busqueda = new Busqueda
	// BusquedaRecetas busqueda = new BusquedaRecetas
	String direccionCorreo
	Boolean resultadoDeConsultasAFavoritos = false
	List<Receta> recetasFavoritas2 = new ArrayList<Receta>
	ContadorConsultas observerConsulta
	List<Receta> recetasBuscadas = new ArrayList<Receta>

	public def setFechaDeNacimiento(int ano, int mes, int diaDelMes) {
		fechaDeNacimiento = new GregorianCalendar(ano, mes, diaDelMes)
	}

	// Calcular indice de masa corporal
	public def indiceDeMasaCorporal() {
		peso / (Math.pow(altura, 2))
	}

	protected def validarIMC() {
		(18 >= this.indiceDeMasaCorporal) && (this.indiceDeMasaCorporal <= 30)
	}

	public def boolean sigoUnaRutinaSaludable() {
		rutina.rutinaSaludable(this)
	}

	// Agregar condiciones preexistentes
	public def void agregarCondicion(Condicion unaCondicion) {
		condicionesPreexistentes.add(unaCondicion)
	}

	public def void agregarPreferencia(String unaComida) {
		preferencias.add(unaComida)
	}

	public def void agregarComidaQueMeDisgusta(String unaComida) {
		comidasQueNoMeGustan.add(unaComida)
	}

	protected def subsanaTodasLasCondiciones() {
		// T o F. Segun si las condiciones preexistentes estan subsanadas.
		(condicionesPreexistentes.exists[condicion|!condicion.seSubsana(this)]
		)			
	}

	protected def rutinaEsIntensiva() {
		rutina.rutinaEsIntensiva
	}

	protected def rutinaEsActiva() {
		rutina.rutinaEsActiva
	}

	protected def boolean meGustaLaCarne() {
		preferencias.contains("carne")
	}

	protected def boolean meGustaLaFruta() {
		preferencias.contains("fruta")
	}

	// Copiar una recetaPublica a la coleccion de recetas del usuario
	public def void agregarRecetaPublicaAMiColeccion(Receta unaReceta, String nombreReceta) {
		var Receta recetaTemporal = recetario.copiarReceta(unaReceta.nombreDeLaReceta, nombreReceta)
		misRecetas.add(recetaTemporal)
		//this.agregarRecetaFavorita(recetaTemporal)
	}
	
//	public def void agregarRecetaPublicaAMiColeccion(String nombreReceta) {
//		var Receta recetaNueva = new Receta
//		misRecetas.add(recetario.copiarReceta(recetaNueva, nombreReceta))
//	}

	public def void agregarRecetaDeGrupo(Grupo unGrupo, String nombreReceta) {
		var Receta recetaNueva = new Receta
		misRecetas.add(unGrupo.copiarReceta(this, unGrupo, recetaNueva, nombreReceta))

	}

	// Crear una receta privada
	public def void crearReceta(String nombre, int calorias, String autor, String dificultad, String preparacion,
		String temporada, Ingrediente ingrediente1, Ingrediente ingrediente2) {

		misRecetas.add(
			new RecetaBuilder(nombre).autor(autor).calorias(calorias).dificultad(dificultad).
				procesoPreparacion(preparacion).temporada(temporada).agregarIngrediente(ingrediente1).
				agregarIngrediente(ingrediente2).build()
		)
	}

	// Devuelve una receta buscandola por su nombre.
	public def devolverReceta(String nombre) { 
		var Receta receta = misRecetas.findFirst[receta|receta.devolverNombre.equals(nombre)]
		/*if (receta.equals(null)) {
		 * 	throw new BusinessException("No existe la receta en la lista de recetas.")
		 }*/
		receta
	}

	// Devuelve una subreceta
	public def devolverSubReceta(String nombreReceta, String nombreSubreceta) {
		var ElementoDeReceta subReceta = devolverReceta(nombreReceta).elementosDeReceta.findFirst [ subReceta |
			subReceta.getNombre.equals(nombreSubreceta)
		]
		if (subReceta.equals(null)) {
			throw new BusinessException("No existe la subreceta en la lista de subrecetas.")
		}
		subReceta
	}

	// Modificacion de receta.
	public def void modificarReceta(String nombreOriginal, String nombreNuevo, int calorias, String proceso,
		String dificultad, String temporada) {

		var Receta nuevaReceta = new Receta
		nuevaReceta = devolverReceta(nombreOriginal) // nuevaReceta ahora apunta a la receta buscada (si es que existe)
		nuevaReceta => [
			setProcesoDePreparacion(proceso)
			setCalorias(calorias)
			setDificultadDePreparacion(dificultad)
			setTemporadaALaQueCorresponde(temporada)
			cambiarNombre(nombreNuevo)
		]
	}

	def boolean meConvieneReceta(Receta receta) {
		receta.esInadecuadaParaUsuario(this)
	}

	// FAVORITAS
	def void agregarRecetaFavorita(String nombre) {
		if (!recetasFavoritas.contains(nombre)) {
			recetasFavoritas.add(nombre)
		}
	}

	def void agregarRecetaFavorita(Grupo unGrupo, String nombre) {
		recetasFavoritas.add(unGrupo.devolverRecetaDeMiembro(nombre).getNombreDeLaReceta)
	}

	def void agregarResultadosDeConsultasAFavoritos() {
		resultadoDeConsultasAFavoritos = true
	}

	def void noAgregarResultadosDeConsultasAFavoritos() {
		resultadoDeConsultasAFavoritos = false
	}

	def boolean contenesEstaRecetaEnFavs(String nombreReceta) {
		recetasFavoritas.contains(nombreReceta)
	}

	// FIN DE FAVORITAS
	// FAVORITAS 2
	def void agregarRecetaFavorita(Receta receta) {
		if (!recetasFavoritas2.contains(receta)) {
			recetasFavoritas2.add(receta)
		}
	}

	def void eliminarRecetaFavorita(Receta receta) {
		if (recetasFavoritas2.contains(receta)) {
			recetasFavoritas2.remove(receta)
		}
	}

	def boolean contenesEstaRecetaEnFavs(Receta receta) {
		recetasFavoritas2.contains(receta)
	}

	// FIN DE FAVORITAS 2
	def List<Receta> recetasQuePuedoVer() {
		val List<Receta> recetasQueVeo = new ArrayList<Receta>
		recetario.recetas.forEach[receta|recetasQueVeo.add(receta)]
		misGrupos.forEach[grupo|recetasQueVeo.addAll[grupo.recetasDelGrupoPara(this).iterator]]
		recetasQueVeo.addAll[misRecetas.iterator]
		recetasQueVeo
	}

	def tePuedoSugerirEstaReceta(Receta receta) {
		!(receta.esInadecuadaParaUsuario(this)) && !noMeGustaEstaReceta(receta)

	}

	def noMeGustaEstaReceta(Receta receta) {
		(comidasQueNoMeGustan.exists [ ingrediente |
			receta.elementosDeReceta.exists(elem|elem.getNombre.equals(ingrediente))
		]
		)
	}

	def tieneSobrepeso() {
		indiceDeMasaCorporal >= 30
	}

	def boolean tenesEstaCondicion(Condicion unaCondicion) {
		// Si existe un objeto de la misma clase que alguna de las condiciones en la coleccion condicionesPreexistentes, devuelvo true.
		condicionesPreexistentes.exists[condicion|condicion.getClass().equals(unaCondicion.getClass())]
	}

	// /////////////////////////////////// METODO PARA FILTRAR BUSQUEDAS /////////////////////////////////////
	def List<Receta> busquedaFiltrada() {
		var List<Receta> recetasFiltradas = recetasQuePuedoVer()

		if (!misBusquedas.empty) {
			var Iterator<Busqueda> iterBusqueda = misBusquedas.iterator()
			while (iterBusqueda.hasNext) {
				recetasFiltradas = (iterBusqueda.next).aplicarBusquedaUsuario(this, recetasFiltradas)
			}
		}
		observerConsulta.seRealizoBusqueda(recetasFiltradas)
		agregarRecetasBuscadas(recetasFiltradas)
		recetasFiltradas
	}

	def List<Receta> busquedaFiltrada2(List<Receta> recetasFiltradas) {

		var temporal = recetasFiltradas

		if (!misBusquedas.empty) {
			var Iterator<Busqueda> iterBusqueda = misBusquedas.iterator()
			while (iterBusqueda.hasNext) {
				temporal = (iterBusqueda.next).aplicarBusquedaUsuario(this, temporal)
			}
			observerConsulta.seRealizoBusqueda(temporal)
			this.agregarRecetasBuscadas(recetasFiltradas)
			return temporal
		}
	}

	def repitoReceta(String nombre) {
		misRecetas.exists[receta|receta.nombreDeLaReceta.equals(nombre)]
	}

	def agregarRecetasBuscadas(List<Receta> recetas) {
		recetas.forEach [ receta |
			if (!recetasBuscadas.contains(receta)) {
				recetasBuscadas.add(receta)
			}
		]
	}

	def existeReceta(Receta unaReceta, String nombreReceta) {
		if((nombreReceta==null) || (nombreReceta=="")){
			throw new RuntimeException("Nombre de receta vacio")
		}
		else{
			if (this.existeRecetaConNombre(nombreReceta)) {
				throw new RuntimeException("Ya existe una receta con ese nombre en su recetario.")
			}
			else{
				this.agregarRecetaPublicaAMiColeccion(unaReceta, nombreReceta)
			}
		}
	}
	
	def nombreRecetaVacio(String nombreReceta) {
		if (nombreReceta==null || nombreReceta==""){
				throw new RuntimeException("Nombre de receta vacio")
		}
	}

	def existeRecetaConNombre(String nombreReceta){
		misRecetas.exists[ receta | receta.nombreDeLaReceta.equals(nombreReceta) ]
	}
	
	def buscarRecetaPorNombre(String string) {
		this.recetasQuePuedoVer.findFirst[ receta | receta.nombreDeLaReceta.equals(string)]
	}
	def  AgregaroRemoverFavorita (String nombre){
		var receta= this.buscarRecetaPorNombre(nombre)
		if (!this.contenesEstaRecetaEnFavs(receta)){
			recetasFavoritas2.add(receta)
		}else {recetasFavoritas2.remove(receta)}
	}
}
	
	