app.controller('detalleRecetaController', function($stateParams, Service) {
	this.receta = Service.getRecetaByNombre($stateParams.nombre);
});