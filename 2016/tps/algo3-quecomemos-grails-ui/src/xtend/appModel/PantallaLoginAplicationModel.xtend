package appModel

import ar.tp.dieta.RepositorioUsuarios
import ar.tp.dieta.Usuario
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class PantallaLoginAplicationModel {

	public RepositorioUsuarios repoUsuarios 
	String nombre
	String contrasenia
	public Usuario usuario
	
	new(String unUsuario, String password) {
		nombre = unUsuario
		contrasenia = password
		repoUsuarios = new RepositorioUsuarios
	}

	def validar() {
		repoUsuarios.validarLogin(nombre, contrasenia)
	}
	
	
}