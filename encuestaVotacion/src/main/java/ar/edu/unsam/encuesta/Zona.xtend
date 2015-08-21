package ar.edu.unsam.encuesta

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import java.util.ArrayList
import org.uqbar.commons.utils.Observable

@Observable
@Accessors
class Zona {

	String descripcion
	List<Candidato> candidatos
	
	new(String descripcion){
		this.candidatos = new ArrayList
		this.descripcion = descripcion
	}
	
	def void agregarCandidato(String nombre, String partido){
		this.candidatos.add(new Candidato(nombre, partido))
	}

	def getDescripcionLoca(){
		descripcion + " (" + candidatos.size + ")"
	}

}