package ar.edu.unsam.algo3

import appModel.PantallaPrincipalAplicationModel

class BusquedaController {

	PantallaPrincipalAplicationModel appModel
		
    def index() {
		appModel = params.appModel
		appModel.limpiarCriterioBusqueda()
		render(view:"busqueda")
	}
	
	def buscar(){
		appModel.busquedaUsuario.nombre = params.nombre
		appModel.busquedaUsuario.dificultad = params.dificultad
		appModel.busquedaUsuario.temporada = params.temporada
		appModel.busquedaUsuario.aplicarFiltro = params.filtro
		appModel.busquedaUsuario.ingrediente = params.ingrediente
		appModel.busquedaUsuario.caloriasMinimas = params.calMin
		appModel.busquedaUsuario.caloriasMaximas = params.calMax
		appModel.filtrar()
//		render(view:"pantallaPrincipal",model:[appModel:appModel,resultadoBusqueda:appModel.filtrar()])
		redirect(controller:"PantallaPrincipal",action:"pantallaPrincipal")
	}
	
	def volver(){
		redirect(controller: "pantallaPrincipal", action: "pantallaPrincipal")
	}
}
