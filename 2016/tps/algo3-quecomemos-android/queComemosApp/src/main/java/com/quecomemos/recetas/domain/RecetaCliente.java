package com.quecomemos.recetas.domain;


import com.quecomemos.recetas.domain.Receta;

import java.util.ArrayList;
import java.util.List;

public class RecetaCliente {

    public List<Receta> recetas;
    public List<Boolean> favs;


    public void agregarIdReceta() {
        for (int i=0; i<recetas.size(); i++) {
            recetas.get(i).setId(new Long (i));
            recetas.get(i).setFavorita(favs.get(i));
        }
    }

    public List<Receta> getRecetalist(){
        return this.recetas;
    }

}