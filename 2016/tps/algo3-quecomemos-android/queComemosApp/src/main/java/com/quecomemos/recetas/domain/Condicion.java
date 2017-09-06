package com.quecomemos.recetas.domain;

import java.io.Serializable;

/**
 * Created by gaglim on 11/24/15.
 */
public class Condicion implements Serializable {
    String nombre;

    public void setNombre(String nombreCondicion){
        this.nombre=nombreCondicion;
    }

    public String getNombre(){
        return nombre;
    }

}
