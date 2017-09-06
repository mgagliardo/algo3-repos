package ar.tp.dieta

import java.util.List
import java.util.ArrayList

class RecetaBuilder {
	
	public static String FACIL = "Facil" 
	public static String MEDIA = "Media"
	public static String DIFICIL = "Dificil"
	public static String OTONIO = "Otonio"
	public static String VERANO = "Verano"
	public static String PRIMAVERA = "Primavera"
	public static String INVIERNO = "Invierno"
	public static String TODOELANIO = "Todo el anio"

	Receta receta
	
	new(String nombreReceta){
		receta = new Receta()
		receta.setNombreDeLaReceta(nombreReceta)
	}		

	public def List<String> getDificultades(){
		var listaTemp = new ArrayList<String>
		listaTemp.add = FACIL
		listaTemp.add = MEDIA
		listaTemp.add = DIFICIL
		listaTemp
	}
	
	public def List<String> getTemporadas(){
		var listaTemp = new ArrayList<String>
		listaTemp.add = OTONIO
		listaTemp.add = VERANO
		listaTemp.add = PRIMAVERA
		listaTemp.add = INVIERNO
		listaTemp.add = TODOELANIO
		listaTemp
	}
	
	public def RecetaBuilder calorias(double calorias){
		receta.setCalorias(calorias)
		return this
	}
	
	public def RecetaBuilder autor(String autor){
		receta.setAutor(autor)
		return this
	}
	
	public def RecetaBuilder dificultad(String dificultad){
		receta.setDificultadDePreparacion(dificultad)
		return this
	}
	
	public def RecetaBuilder procesoPreparacion(String procesoPreparacion){
		receta.setProcesoDePreparacion(procesoPreparacion)
		return this
	}
	
	public def RecetaBuilder temporada(String temporada){
		receta.setTemporadaALaQueCorresponde(temporada)
		return this
	}
	
	public def RecetaBuilder agregarIngrediente(Ingrediente unIngrediente){
		receta.agregarIngrediente(unIngrediente)
		return this
	}
	
	public def RecetaBuilder agregarCondimento(Condimento unCondimento){
		receta.agregarCondimento(unCondimento)
		return this
	}

	public def Receta build(){
		
//		if(receta.nombreDeLaReceta.length.equals(0)){
//			throw new BusinessException("El nombre no puede estar vacio")
//		}else{
			return receta
//		}
	}
	
}