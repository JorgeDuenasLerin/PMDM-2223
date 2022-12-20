package com.example.pmdm_2223.ut03.listaavanzada;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2223.R;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private ArrayList<Producto> datos;

    /*
    * Relacionado con el evento.
    */
    public interface ItemClickListener {
        void onClick(View view, int position, Producto producto);
    }

    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView producto;
        private final TextView precio;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            producto = (TextView) view.findViewById(R.id.examen_t1_e1_line_producto);
            precio = (TextView) view.findViewById(R.id.examen_t1_e1_line_precio);
            view.setOnClickListener(this);
        }

        public void setInfo(String nombre, int precio_val) {
            producto.setText(nombre);
            precio.setText(String.valueOf(precio_val));
        }

        @Override
        public void onClick(View view) {
            // Si tengo un manejador de evento lo propago con el índice
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition(), datos.get(getAdapterPosition()));
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public ProductoAdapter(ArrayList<Producto> dataSet) {
        datos = new ArrayList<Producto>();
        add(dataSet);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_t1_e1_line, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Producto p = datos.get(position);
        viewHolder.setInfo(p.getNombre(),p.getPrecio());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void add(ArrayList<Producto> dataSet){
        datos.addAll(dataSet);
        notifyDataSetChanged();
    }
}