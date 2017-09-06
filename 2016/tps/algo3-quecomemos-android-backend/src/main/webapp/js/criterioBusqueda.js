function CriterioBusqueda(){
	this.aplicarFiltro = false;
	this.dificultad = "";
	this.nombre = null;
	this.ingrediente = null;
	this.caloriasMinimas = null;
	this.caloriasMaximas = null;
	this.temporada = "";

	this.temporadasPosibles = [ new Parametro('Invierno'), new Parametro('Verano'),new Parametro('Todo el anio'),new Parametro('Otonio') ];
	this.dificultadesPosibles = [ new Parametro('Facil'), new Parametro('Media'), new Parametro('Dificil') ];
}

CriterioBusqueda.asCriterioBusqueda = function (jsonCriterioBusqueda) {
	  return angular.extend(new CriterioBusqueda(), jsonCriterioBusqueda);
};