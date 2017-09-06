package ar.edu.unsam.algo3

import java.awt.event.ItemEvent;

import appModel.CopiarRecetaAplicationModel
import appModel.DetalleRecetaAplicationModel
import appModel.PantallaPrincipalAplicationModel
import ar.tp.dieta.Busqueda

class PantallaPrincipalController {

	static scope="session"
	PantallaPrincipalAplicationModel pantallaPrincipalAppModel

	def pantallaPrincipal() {
		render(view:"pantallaPrincipal", model:[recetaList: pantallaPrincipalAppModel.getRecetas(), appModel: pantallaPrincipalAppModel])
	}

	def ver(){
		def receta = this.buscarReceta(params.nombreReceta)
		DetalleRecetaController detalleControl = new DetalleRecetaController()
		detalleControl.detalleRecetaAppModel = new DetalleRecetaAplicationModel(receta,pantallaPrincipalAppModel.usuario)
		//detalleControl.detalleRecetaAppModel = new DetalleRecetaAplicationModel(pantallaPrincipalAppModel.establecerRecetas().get(0),pantallaPrincipalAppModel.usuario)
		redirect(controller: 'detalleReceta', action: "pantallaReceta")
	}

	def marcarFavorita(){
		def receta = this.buscarReceta(params.nombreReceta)
		pantallaPrincipalAppModel.agregarORemoverRecetaFavorita(receta)
		render(view:"pantallaPrincipal", model:[recetaList: pantallaPrincipalAppModel.getRecetas(), appModel: pantallaPrincipalAppModel])
	}

	def irAPantallaDeCopia(){
		def receta = this.buscarReceta(params.nombreReceta)
		CopiarRecetaController copiaControl = new CopiarRecetaController()
		copiaControl.appModel = new CopiarRecetaAplicationModel(receta, pantallaPrincipalAppModel.usuario)
		redirect(controller: 'copiarReceta', action: "copiarReceta")
	}
	
	def irAPantallaDeLogin(){
		redirect(controller: "Login", action: "volver")
	}
	
	def irAPantallaDeBusqueda(){
		redirect(controller:"Busqueda", action: "index",params:[appModel:pantallaPrincipalAppModel])
	}
	
	def refresh(){
		pantallaPrincipalAppModel.establecerRecetas()
		redirect(action: "pantallaPrincipal")
	}
	
	def buscarReceta(String nombreDeReceta){
		pantallaPrincipalAppModel.devolverReceta(nombreDeReceta)
	}
	
	def buscar(){
		pantallaPrincipalAppModel.busquedaUsuario.nombre = params.nombre
		pantallaPrincipalAppModel.busquedaUsuario.dificultad = params.dificultad
		pantallaPrincipalAppModel.busquedaUsuario.temporada = params.temporada
		pantallaPrincipalAppModel.busquedaUsuario.aplicarFiltro = params.filtro
		pantallaPrincipalAppModel.busquedaUsuario.ingrediente = params.ingrediente
		pantallaPrincipalAppModel.busquedaUsuario.caloriasMinimas = params.caloriasMinimas? new Integer(params.caloriasMinimas):0
		pantallaPrincipalAppModel.busquedaUsuario.caloriasMaximas = params.caloriasMaximas? new Integer(params.caloriasMaximas):0
		pantallaPrincipalAppModel.filtrar()
		pantallaPrincipalAppModel.busquedaUsuario.busquedaFinal = new Busqueda()
//		render(view:"pantallaPrincipal",model:[appModel:appModel,resultadoBusqueda:appModel.filtrar()])
		redirect(action:"pantallaPrincipal")
	}
}