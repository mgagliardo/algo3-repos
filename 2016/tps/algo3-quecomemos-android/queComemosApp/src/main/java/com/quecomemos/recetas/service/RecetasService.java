package com.quecomemos.recetas.service;

import com.quecomemos.recetas.domain.Receta;
import com.quecomemos.recetas.domain.RecetaCliente;
import com.quecomemos.recetas.domain.RecetaCliente;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by MONOLITO on 23/11/2015.
 */
public interface RecetasService {

    @GET("recetasList")
    public Call<RecetaCliente> getRecetas();

}
