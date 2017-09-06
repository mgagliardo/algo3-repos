app.service('Service', function($http) {

	var self = this;

    this.logear = function(infologin, callbackOk,callbackError) {     
        $http.post('/login/', infologin).then(callbackOk,callbackError);
    };

    this.findAll = function(callback) {
        $http.get('/recetasList').then(callback);
    };

    this.marcarfavorita = function (inforeceta,callback){
        $http.post('/recetasList/', inforeceta).then(callback);
    };

    this.getRecetaByNombre = function(nombre) {
         return _.find(this.recetas, function(receta) {
             return receta.nombreDeLaReceta == nombre;
         });
    };

    this.copiar = function(infoCopia, callbackOk,callbackError) {
         $http.post('/copiarReceta/', infoCopia).then(callbackOk,callbackError);
    };

    this.buscar = function (criterioBusqueda,callback){
    	$http.post('/buscar/', criterioBusqueda).then(callback);
    };
});