package ar.edu.unsam.encuesta

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable

@Observable
@Accessors
class Candidato {
	String nombre
	String partido
	int votos

	new(String nombre, String partido){
		this.nombre = nombre
		this.partido = partido
	}
	
	override toString(){
		nombre + " (" + partido + ") - " + votos + " votos" 
	}
	
	def sumarVoto(){
		votos++		
	}

}