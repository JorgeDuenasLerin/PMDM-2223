package com.example.pmdm_2223.ut03.listas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2223.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ut03PartidoAdapter extends RecyclerView.Adapter<ut03PartidoAdapter.ViewHolder> {

    private ArrayList<ut03Partido> datos;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView partido;
        private final TextView resultado;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            partido = (TextView) view.findViewById(R.id.ut03ListaNombre);
            resultado = (TextView) view.findViewById(R.id.ut03ListaResultado);
        }

        public TextView getTextPartido() {
            return partido;
        }

        public TextView getTextResultado() {
            return resultado;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public ut03PartidoAdapter(ut03Partido[] dataSet) {
        datos = new ArrayList<ut03Partido>();
        add(dataSet);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_partido, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextPartido().setText(datos.get(position).local + " vs " + datos.get(position).visitante);
        viewHolder.getTextResultado().setText(datos.get(position).resultado);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void add(ut03Partido[] dataSet){
        datos.addAll(Arrays.asList(dataSet));
        notifyDataSetChanged();
    }
}
