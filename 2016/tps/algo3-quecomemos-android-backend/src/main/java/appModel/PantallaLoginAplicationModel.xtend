package appModel

import ar.tp.dieta.RepositorioUsuarios
import ar.tp.dieta.Usuario
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class PantallaLoginAplicationModel {

	public RepositorioUsuarios repoUsuarios 
	String nombre = "Miguel"
	String contrasenia = "miguel"
	public Usuario usuario
	
	new() {
		repoUsuarios = new RepositorioUsuarios
	}

	def validar() {
		usuario = repoUsuarios.validarLogin(nombre, contrasenia)
	}
	
	
}