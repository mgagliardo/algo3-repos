package com.quecomemos.recetas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.quecomemos.R;
import com.quecomemos.recetas.domain.Receta;

import java.util.List;

/**
 * Created by daniel on 17/11/2015.
 */
public class RecetaAdapter extends ArrayAdapter<Receta> {

    public RecetaAdapter(Context context, List<Receta> recetas) {
        super(context, R.layout.receta_row, recetas);
    }

    @Override
    public long getItemId(int position) {
        //return position;
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.receta_row, parent, false);
        final Receta receta = getItem(position);

        TextView tvReceta = (TextView) rowView.findViewById(R.id.lblReceta);
        tvReceta.setText(receta.toString());

        TextView tvCalorias = (TextView) rowView.findViewById(R.id.lblCalorias);
        tvCalorias.setText("Calorias: " + String.valueOf(receta.getCalorias()));

        TextView tvTemporadaALaQueCorresponde = (TextView) rowView.findViewById(R.id.lblTemporadaALaQueCorresponde);
        tvTemporadaALaQueCorresponde.setText("Temporada: " + receta.getTemporadaALaQueCorresponde());

        TextView tvDificultadDePreparacion = (TextView) rowView.findViewById(R.id.lblDificultadDePreparacion);
        tvDificultadDePreparacion.setText("Dificultad: " + receta.getDificultadDePreparacion());

          //FIXEAR FAV BUTTON Y COMPORTAMIENTO
//        CheckBox checkFav = (CheckBox) rowView.findViewById(R.id.checkFavorita);
//        checkFav.setChecked(receta.getFavorita());

        return rowView;
    }
}
