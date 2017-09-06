package appModel

import ar.tp.dieta.Busqueda
import ar.tp.dieta.ContadorConsultas
import ar.tp.dieta.CriterioBusqueda
import ar.tp.dieta.Filtro
import ar.tp.dieta.FiltroPorGustos
import ar.tp.dieta.FiltroPorIngredienteCaro
import ar.tp.dieta.PosteriorBusquedaDiezPrimeros
import ar.tp.dieta.PosteriorBusquedaOrdenadoCalorias
import ar.tp.dieta.Receta
import ar.tp.dieta.RecetarioPublico
import ar.tp.dieta.Usuario
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import ar.tp.dieta.RecetaBuilder

@Accessors
class PantallaPrincipalAplicationModel {

	CriterioBusqueda busquedaUsuario = new CriterioBusqueda
	Receta recetaSeleccionada
	ContadorConsultas accion = new ContadorConsultas
	List<Receta> recetas = new ArrayList<Receta>
	Usuario usuario
	RecetarioPublico recetario = new RecetarioPublico
	String mensaje
//	Busqueda busqueda1
//	Busqueda busqueda2
//	Busqueda busqueda3
	Filtro filtroPrimeras
	List<String> dificultades
	List<String> temporadas

	new(Usuario parametroUsuario) {
//		busqueda1 = new Busqueda
//		busqueda1.agregarFiltro(new FiltroPorIngredienteCaro)
//		busqueda2 = new Busqueda
//		busqueda2.agregarFiltro(new PosteriorBusquedaOrdenadoCalorias)
//		busqueda3 = new Busqueda
//		busqueda3.agregarFiltro(new FiltroPorGustos)
		filtroPrimeras = new PosteriorBusquedaDiezPrimeros

		dificultades = ((new RecetaBuilder("a")).dificultades)
		temporadas = ((new RecetaBuilder("a")).temporadas)
		this.usuario = parametroUsuario
		this.establecerRecetas()
	}

	def establecerRecetas() {

		if (!usuario.recetasFavoritas2.isEmpty) {
			mensaje = "Estas son sus recetas favoritas"
			recetas = filtroPrimeras.aplicarFiltroUsuario(usuario, usuario.recetasFavoritas2)
		} else {
			if (!usuario.recetasBuscadas.isEmpty) {
				mensaje = "Este es el resultado de su ultima consulta"
				recetas = filtroPrimeras.aplicarFiltroUsuario(usuario, usuario.busquedaFiltrada)
			} else {
				mensaje = "Estas son las recetas mas consultadas"
				recetas = filtroPrimeras.aplicarFiltroUsuario(usuario, usuario.getObserverConsulta.getRecetasFinales)
			}
		}
	}

	def colorear(Receta receta) {
		if (this.usuario.misRecetas.contains(receta)) {
			return "YELLOW"
		} else {
			if (this.usuario.recetario.recetas.contains(receta)) {
				return "RED"
			} else {
				return "BLUE"
			}
		}
	}

	def limpiarRecetas() {
		recetas.removeAll
	}

	def filtrar() {
//		var List<Receta> recetasTemp = new ArrayList<Receta>
		recetas = busquedaUsuario.filtrar(usuario, usuario.recetasQuePuedoVer)
		usuario.getObserverConsulta.seRealizoBusqueda(recetas)
		usuario.agregarRecetasBuscadas(recetas)
//		recetasTemp
	}

	def void agregarORemoverRecetaFavorita(Receta receta) {
		if (usuario.recetasFavoritas2.contains(receta)) {
			usuario.eliminarRecetaFavorita(receta)
		} else {
			usuario.agregarRecetaFavorita(receta)
		}
	}

	def devolverReceta(String nombreReceta) {
		usuario.buscarRecetaPorNombre(nombreReceta)
	}

	def limpiarCriterioBusqueda() {
		busquedaUsuario = new CriterioBusqueda
	}
}