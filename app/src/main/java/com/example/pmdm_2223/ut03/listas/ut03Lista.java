package com.example.pmdm_2223.ut03.listas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pmdm_2223.R;

public class ut03Lista extends AppCompatActivity {

    RecyclerView reyclerViewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut03_lista);

        reyclerViewUser = (RecyclerView) findViewById(R.id.ut03ListaContenedor);
        PartidoAdapter adapter = new PartidoAdapter(Partido.generateData(Partido.PARTIDOS_INICIALES));
        reyclerViewUser.setAdapter(adapter);
    }
}