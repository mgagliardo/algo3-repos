package ar.edu.unsam.algo3

import appModel.CopiarRecetaAplicationModel
import ar.tp.dieta.BusinessException

class CopiarRecetaController {
	
	CopiarRecetaAplicationModel appModel
	def errorMessage
	
	def copiarReceta(){
		errorMessage = null
		render(view:"copiarReceta", model:[errorMessage:errorMessage])
	}
	
	def copiarRecetaNombre(){
		appModel.nombreCopia = params.nombreDeCopia
		try{
			appModel.nombreRecetaVacio()
			redirect(controller:"copiarReceta", action:"copiar")
		} catch(BusinessException e) {
			errorMessage = "Nombre de la receta vacio"
			render(view:"copiarReceta", model:[errorMessage:errorMessage])
		}
	}
	
	def copiar(){	
			try{
			appModel.copiar()
			redirect(controller:"pantallaPrincipal", action:"refresh")
		} catch(BusinessException e) {
			errorMessage = "El nombre de la receta ya existe"
			render(view:"copiarReceta", model:[errorMessage:errorMessage])
		}
	}

	def volver(){
		redirect(controller: "pantallaPrincipal", action: "pantallaPrincipal")
	}

}