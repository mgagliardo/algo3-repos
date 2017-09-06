package com.quecomemos.recetas.domain;

import java.io.Serializable;

/**
 * Created by daniel on 22/11/2015.
 */
public class Ingrediente  implements Serializable {
    String nombre;
    int cantidad;

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setCantidad(int cantidad){
        this.cantidad= cantidad;
    }

    public String getCantidad() {
        return String.valueOf(cantidad);
    }

}

