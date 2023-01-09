package com.example.pmdm_2223.ut04.mvvm.sencillo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class RandomMVVM extends AppCompatActivity {

    Button gen;
    Button get;
    TextView label;
    RandomViewModel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre_mvvm);

        gen = findViewById(R.id.id_ut04_mvvm_gen);
        get = findViewById(R.id.id_ut04_mvvm_get);
        label = findViewById(R.id.id_ut04_mvvm_label);

        gen.setOnClickListener(view -> {
            viewmodel.generarRandom();
        });

        get.setOnClickListener(view -> {
            // Lanza la petición al ViewModel
            viewmodel.generarRandom();
        });

        // Obtener el ViewModel
        // Lo gestiona Android
        viewmodel = new ViewModelProvider(this).get(RandomViewModel.class);
        viewmodel.getDato().observe(this, randomModel -> {
            label.setText(""+randomModel.getRandom());
        });
    }
}