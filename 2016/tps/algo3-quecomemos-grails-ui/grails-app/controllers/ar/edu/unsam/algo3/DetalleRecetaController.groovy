package ar.edu.unsam.algo3

import appModel.DetalleRecetaAplicationModel;

class DetalleRecetaController {

	DetalleRecetaAplicationModel detalleRecetaAppModel
	
    def pantallaReceta() {
		render(view:"/detalleReceta/detalleReceta", model:[appModel:detalleRecetaAppModel])
	}
	
	def volver(){
		redirect(controller: "pantallaPrincipal", action: "pantallaPrincipal")
	}
}
