package ar.tp.dieta

import java.util.ArrayList
import java.util.List

class FiltroPorNombre implements Filtro{
	
	String nombre
	List<Receta> temporal = new ArrayList<Receta>
	
	new(String parametroNombre){
		nombre = parametroNombre
	}
	
	override aplicarFiltroUsuario(Usuario unUsuario, List<Receta> recetasSinFiltrar) {
		recetasSinFiltrar.forEach[receta | if(receta.nombreDeLaReceta.equals(nombre)){
												temporal.add(receta)}]
		return temporal
	}
	
	override aplicarFiltroGrupo(Grupo unGrupo, List<Receta> recetasSinFiltrar) {
	}
	
	
}