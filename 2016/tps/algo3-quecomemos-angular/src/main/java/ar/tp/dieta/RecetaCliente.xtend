package ar.tp.dieta

import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class RecetaCliente{
	
	List<Receta> recetas = new ArrayList<Receta>
	List<Boolean> favs = new ArrayList<Boolean>
	List<String> dificultades= new ArrayList<String>
	List<String> temporadas= new ArrayList<String>
	String mensaje
	new(String mensa,List<Receta> recetaList,Usuario usuario,List<String> dificultad,List<String> temporada){
		this.dificultades.addAll(dificultad)
		this.mensaje = mensa
		this.temporadas.addAll(temporada)
		recetaList.forEach[ receta | if(!(this.tenesEstaReceta(receta.nombreDeLaReceta))){
													recetas.add(receta)
		}]
		recetas.forEach[ receta | favs.add(usuario.contenesEstaRecetaEnFavs(receta)) ]
	}
	def boolean tenesEstaReceta(String nombre){
		return recetas.exists[receta| receta.nombreDeLaReceta.equals(nombre)]
	}
									
}