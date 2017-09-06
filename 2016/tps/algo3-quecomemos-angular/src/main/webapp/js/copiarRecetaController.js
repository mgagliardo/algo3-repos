app.controller('CopiarRecetaController', function(Service, $state, $timeout) {

	var self = this;
	this.infoCopia = new Receta();
  this.errors= [];

  function notificarError(mensaje) {
    self.errors.push(mensaje.data);
    timeout(function() {
      while(self.errors.length > 0) self.errors.pop();
    }, 5000);
  };

	this.copiarReceta = function(){
		self.infoCopia.nombre = Service.nombre;
		Service.copiar(self.infoCopia,function() {
        $state.go("recetas");
    }, notificarError);
	};

});