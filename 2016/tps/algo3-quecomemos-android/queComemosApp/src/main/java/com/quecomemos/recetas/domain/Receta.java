package com.quecomemos.recetas.domain;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 17/11/2015.
 */
public class Receta implements Serializable {
    public Long id;
    public int calorias;
    public String nombreDeLaReceta;
    public String temporadaALaQueCorresponde;
    public String dificultadDePreparacion;
    public String procesoDePreparacion;
    public String autor;
    public boolean favorita;

    public List<Ingrediente> ingredientes;
    public String nombresIngredientes;
    public String cantidadIngredientes;

    public List<Condimento> condimentos;
    public String condimentosList;


    public List<String> condicionesPreexistentes;
    public String condiciones;


    public Receta (String nombreDeLaReceta, int calorias,String temporadaALaQueCorresponde, String dif, String procesoDePreparacion, String autor){
        this.calorias = calorias ;
        this.nombreDeLaReceta = nombreDeLaReceta;
        this.temporadaALaQueCorresponde=temporadaALaQueCorresponde;
        this.dificultadDePreparacion=dificultadDePreparacion;
        this.procesoDePreparacion=procesoDePreparacion;
        this.autor=autor;
    }


    public void setId(Long id){
        this.id=id;
    }

    public Long getId(){
        return id;
    }

    public void setCalorias(int calorias){
        this.calorias=calorias;
    }

    public int getCalorias(){
        return calorias;
    }

    public void setNombreDeLaReceta(String nombre){
        this.nombreDeLaReceta=nombre;
    }

    public String getNombreDeLaReceta(){
        return nombreDeLaReceta;
    }

    public void setFavorita(boolean fav){
        this.favorita=fav;
    }

    public boolean getFavorita(){
        return favorita;
    }

    public String toString() {
        return nombreDeLaReceta;
    }

    public void setTemporadaALaQueCorresponde(String temporada){
        this.temporadaALaQueCorresponde=temporada;
    }

    public String getTemporadaALaQueCorresponde(){
        return temporadaALaQueCorresponde;
    }

    public void setDificultadDePreparacion(String dificultad){
        this.dificultadDePreparacion=dificultad;
    }

    public String getDificultadDePreparacion(){
        return dificultadDePreparacion;
    }

    public String getProcesoDePreparacion(){
        return procesoDePreparacion;
    }

    public String getAutor(){
        return autor;
    }
    public List<Ingrediente> getIngrediente(){
        return ingredientes;
    }

    public String getNombresIngredientes() {
        int max = ingredientes.size();
        nombresIngredientes = "";
        for (int i =0; i<max; i++ ){
            nombresIngredientes=nombresIngredientes + ingredientes.get(i).getNombre() +  " ";
        }
        return nombresIngredientes;
    }

    public String getCantIngredientes() {
        int max = ingredientes.size();
        cantidadIngredientes = "";
        for (int i =0; i<max; i++ ){
            cantidadIngredientes=cantidadIngredientes + ingredientes.get(i).getCantidad() +  " ";
        }
        return cantidadIngredientes;
    }

    public List<Condimento> getCondimento(){
        return condimentos;
    }

    public String getCondimentos() {
        int max = condimentos.size();
        condimentosList = "";
        for (int i =0; i<max; i++ ){
            condimentosList=condimentosList + condimentos.get(i).getNombre() +  ", ";
        }
        return condimentosList;
    }


    public List<String> getCondicionesPreexistentes() {
        return condicionesPreexistentes;
    }

    public String getCondiciones() {
        int max = condicionesPreexistentes.size();
        condiciones = "";
        for (int i =0; i<max; i++ ){
            condiciones=condiciones + condicionesPreexistentes.get(i) +  ", ";
        }
        return condiciones;
    }

}
