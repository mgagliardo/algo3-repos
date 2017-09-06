package ar.edu.unsam.algo3

import appModel.PantallaLoginAplicationModel
import appModel.PantallaPrincipalAplicationModel
import ar.tp.dieta.RepositorioUsuarios

class LoginController {

	static scope="session"
	RepositorioUsuarios repoUsuarios = new RepositorioUsuarios()
	PantallaPrincipalAplicationModel pantallaPrincipalAppModel
	def errorMessage = null
	
	def index() {
		render(view:"login", model:[errorMessage:errorMessage])
	}
	
	def login(){
		def loginAppModel = new PantallaLoginAplicationModel(params.nombre, params.contrasenia)
		if (loginAppModel.validar()!=null) {
			def usuario = repoUsuarios.validarLogin(params.nombre, params.contrasenia)
			pantallaPrincipalAppModel = new PantallaPrincipalAplicationModel(usuario)
			pantallaPrincipalAppModel.busquedaUsuario.caloriasMinimas=null
			pantallaPrincipalAppModel.busquedaUsuario.caloriasMaximas=null
			this.list()
		}
		else{
			errorMessage = "Usuario o Contraseña Incorrecto"
			render(view:"login", model:[errorMessage:errorMessage])
		}
	}
	
	def list(){
		PantallaPrincipalController principalControl = new PantallaPrincipalController()
		principalControl.pantallaPrincipalAppModel = pantallaPrincipalAppModel
		redirect(controller: "pantallaPrincipal", action: "pantallaPrincipal")
	}
	
	def volver(){
		errorMessage = null
		redirect(action:"index")
	}

}