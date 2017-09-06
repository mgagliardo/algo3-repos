package ar.tp.dieta

import java.util.ArrayList
import java.util.List

class CondicionVegano extends Condicion {
	//Lista de "elementos" que no son buenos para una condicion
	public List<String> elementosNoRecomendables = new ArrayList<String>
	
	new(){
		elementosNoRecomendables.add("pollo")
		elementosNoRecomendables.add("carne")
		elementosNoRecomendables.add("chivito")
		elementosNoRecomendables.add("chori")
		elementosNoRecomendables.add("lomo")
	}

	override esVegano() {
		true
	}

	override seSubsana(Usuario unUsuario) {
		(unUsuario.meGustaLaFruta())
	}
	
	override validarCondicion(Usuario unUsuario){
		!(unUsuario.meGustaLaCarne())
	}

	override ingredienteEsInadecuado(ElementoDeReceta unElemento) {
		//Si entre los elementos no recomendables esta alguno de los contenidos de la receta.
		elementosNoRecomendables.contains(unElemento.getNombre())
	}
}