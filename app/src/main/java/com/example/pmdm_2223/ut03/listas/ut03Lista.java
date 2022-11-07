package com.example.pmdm_2223.ut03.listas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pmdm_2223.R;

public class ut03Lista extends AppCompatActivity {

    RecyclerView reyclerViewUser;
    Button add;
    ut03PartidoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut03_lista);

        reyclerViewUser = (RecyclerView) findViewById(R.id.ut03ListaContenedor);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);

        adapter = new ut03PartidoAdapter(ut03Partido.generatePartidos(ut03Partido.PARTIDOS_INICIALES));
        reyclerViewUser.setAdapter(adapter);

        add = findViewById(R.id.ut03idListaAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(ut03Partido.generatePartidos(ut03Partido.PARTIDOS_INICIALES));
            }
        });

        //adapter.notifyDataSetChanged();
    }
}