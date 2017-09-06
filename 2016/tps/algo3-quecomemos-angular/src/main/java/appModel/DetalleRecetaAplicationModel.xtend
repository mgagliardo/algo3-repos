package appModel

import ar.tp.dieta.Receta
import ar.tp.dieta.Usuario
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class DetalleRecetaAplicationModel {
	
	Usuario usuario
	Receta receta
	
	new (Receta recetaSeleccionada, Usuario usuarioSeleccionado) {
		receta = recetaSeleccionada
		usuario = usuarioSeleccionado
	} 
	
	def boolean getFavorita() {
		usuario.contenesEstaRecetaEnFavs(receta)
	}
	def getEsFavorita(){
		usuario.contenesEstaRecetaEnFavs(receta)
	}
	
	def void setEsFavorita(boolean unBool){
		if(unBool){
			usuario.agregarRecetaFavorita(receta)
		}
		else{
			usuario.eliminarRecetaFavorita(receta)
		}
	}
	
	
	def boolean getEditable() {
		false
	}
	
}