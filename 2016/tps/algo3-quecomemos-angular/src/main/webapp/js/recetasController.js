app.controller('RecetasController', function(Service,$state) {

	var self = this;
	this.recetas = [];
	this.inforeceta= new Receta();
	this.criterioBusqueda = new CriterioBusqueda;
	this.mensaje = null;

	this.buscar = function(){
		Service.buscar(self.criterioBusqueda,function(){
      self.getRecetas( );
		});
	};
	
	this.getRecetas = function() {
	    Service.findAll(function(data) {
	    	 self.recetas = data.data.recetas;
	    	 Service.recetas = self.recetas;
         self.mensaje = data.data.mensaje;
	    	  for (var i = 0; i < self.recetas.length; i++){
	    	  	self.recetas[i].favorita = data.data.favs[i];
	    	  }
	    });
	};	

    this.marcarfavorita = function(nombre) {
      self.inforeceta.nombreDeLaReceta = nombre;
        Service.marcarfavorita(self.inforeceta, function() {
            self.getRecetas();
        });

    };

	this.copiarReceta = function(nombre) {
		Service.nombre = nombre;
		$state.go("copiarReceta");
	};

	self.getRecetas();

});