package appModel

import ar.tp.dieta.ContadorConsultas
import ar.tp.dieta.CriterioBusqueda
import ar.tp.dieta.Filtro
import ar.tp.dieta.PosteriorBusquedaDiezPrimeros
import ar.tp.dieta.Receta
import ar.tp.dieta.RecetaBuilder
import ar.tp.dieta.RecetaCliente
import ar.tp.dieta.Usuario
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class PantallaPrincipalAplicationModel {

	CriterioBusqueda busquedaUsuario = new CriterioBusqueda
	Receta recetaSeleccionada
	ContadorConsultas accion = new ContadorConsultas
	List<Receta> recetas = new ArrayList<Receta>
	Usuario usuario
	String mensaje
	Filtro filtroPrimeras
	List<String> dificultades
	List<String> temporadas

	new(Usuario parametroUsuario) {
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

	def limpiarRecetas() {
		recetas.removeAll
	}

	def filtrar() {
		mensaje = "Estas son sus recetas buscadas"
		recetas = busquedaUsuario.filtrar(usuario, usuario.recetasQuePuedoVer)
		usuario.getObserverConsulta.seRealizoBusqueda(recetas)
		usuario.agregarRecetasBuscadas(recetas)
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
	
	def recetasCliente(){
		new RecetaCliente(recetas,usuario)
	}
}