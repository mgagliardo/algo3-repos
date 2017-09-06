package com.quecomemos.recetasApp;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.quecomemos.R;
import com.quecomemos.recetas.domain.Receta;
import com.quecomemos.recetas.service.RecetasService;

/**
 * A fragment representing a single receta detail screen.
 * This fragment is either contained in a {@link RecetaListActivity}
 * in two-pane mode (on tablets) or a {@link RecetaDetailActivity}
 * on handsets.
 */
public class RecetaDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Receta receta;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecetaDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {

            receta = (Receta) getArguments().get(ARG_ITEM_ID);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(receta.getNombreDeLaReceta());
            } else {
                activity.setTitle(receta.getNombreDeLaReceta());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_receta_detail, container, false);
        CheckBox boton;

        // Show the dummy content as text in a TextView.
        if (receta != null) {
            //((TextView) rootView.findViewById(R.id.receta_nombre)).setText(receta.getNombreDeLaReceta());
            ((TextView) rootView.findViewById(R.id.receta_calorias)).setText(String.valueOf(receta.getCalorias()) + " calorias");
            ((TextView) rootView.findViewById(R.id.receta_autor)).setText("Creado por: " + receta.getAutor());
            ((TextView) rootView.findViewById(R.id.receta_dificultad)).setText("Dificultad: " + receta.getDificultadDePreparacion());
            ((TextView) rootView.findViewById(R.id.receta_temporada)).setText("Temporada: " + receta.getTemporadaALaQueCorresponde());
            ((TextView) rootView.findViewById(R.id.receta_proceso)).setText("Proceso: " + receta.getProcesoDePreparacion());
            ((TextView) rootView.findViewById(R.id.receta_condiciones)).setText("Condiciones: " + receta.getCondiciones());
            ((TextView) rootView.findViewById(R.id.receta_condimentos)).setText("Condimentos: " + receta.getCondimentos());
            ((TextView) rootView.findViewById(R.id.receta_nombres_ing)).setText("Ingredientes nombres: " + receta.getNombresIngredientes());
            ((TextView) rootView.findViewById(R.id.receta_cant_ing)).setText("Ingredientes cant: " + receta.getCantIngredientes());
            boton=(CheckBox) rootView.findViewById(R.id.receta_favorita);
            boton.setChecked(receta.getFavorita());
            boton.setEnabled(false);
        }

        return rootView;
    }}