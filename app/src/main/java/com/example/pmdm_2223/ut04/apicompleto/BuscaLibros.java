package com.example.pmdm_2223.ut04.apicompleto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.pmdm_2223.R;
import com.example.pmdm_2223.ut04.apicompleto.models.VolumesResponse;

public class BuscaLibros extends AppCompatActivity {
    private BookSearchViewModel viewModel;
    private BookSearchResultsAdapter adapter;
    Button buscar;
    RecyclerView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_libros);

        adapter = new BookSearchResultsAdapter();
        listado = findViewById(R.id.id04ListView);
        listado.setLayoutManager(new LinearLayoutManager(this));
        listado.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(BookSearchViewModel.class);
        viewModel.init();
        viewModel.getVolumesResponseLiveData().observe(this, new Observer<VolumesResponse>() {
            @Override
            public void onChanged(VolumesResponse volumesResponse) {
                if (volumesResponse != null) {
                    adapter.setResults(volumesResponse.getItems());
                }
            }
        });

        buscar = findViewById(R.id.id04Buscar);

        buscar.setOnClickListener((v)->{
            Log.d("Yo", "Click!");
            viewModel.searchVolumes("Asimov","");
        });

    }
}