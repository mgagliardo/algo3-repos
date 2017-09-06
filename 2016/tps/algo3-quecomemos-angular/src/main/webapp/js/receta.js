function Receta(){
	this.nombreDeLaReceta= null ;
}

Receta.asReceta = function(jsonReceta) {
	return angular.extend(new Receta(), jsonReceta);
};