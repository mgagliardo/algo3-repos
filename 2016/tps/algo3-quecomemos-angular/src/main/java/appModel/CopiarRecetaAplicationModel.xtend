package appModel

import ar.tp.dieta.Receta
import ar.tp.dieta.Usuario
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class CopiarRecetaAplicationModel {
	
	String nombreCopia  
	Receta receta
	Usuario usuario
	
	new(){}
	
	new(Receta parametroReceta, Usuario parametroUsuario){
		receta = parametroReceta
		usuario = parametroUsuario
	}
	
	def copiar(){
		usuario.existeReceta(receta, nombreCopia)
	}
	
	def nombreRecetaVacio(){
		usuario.nombreRecetaVacio(this.nombreCopia)
	}
	
	def copiar(String nombre){
		usuario.existeReceta(usuario.devolverReceta(nombre), nombre)
	}
}