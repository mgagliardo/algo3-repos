package ar.tp.dieta

import java.util.ArrayList
import java.util.List

class FiltroPorNombre implements Filtro{
	
	String nombre
	List<Receta> temporal = new ArrayList<Receta>
	
	new(String parametroNombre){
		nombre = parametroNombre.toLowerCase()
	}
	
	override aplicarFiltroUsuario(Usuario unUsuario, List<Receta> recetasSinFiltrar) {
		recetasSinFiltrar.forEach[receta | if(receta.nombreDeLaReceta.toLowerCase().contains(nombre.toLowerCase())){
												temporal.add(receta)}]
		return temporal
	}
	
	override aplicarFiltroGrupo(Grupo unGrupo, List<Receta> recetasSinFiltrar) {
	}
	
	
}