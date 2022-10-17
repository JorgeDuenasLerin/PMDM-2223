package com.example.pmdm_2223.ut02.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class ut02Receptora extends AppCompatActivity {

    TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut03_receptora);

        mensaje = findViewById(R.id.ut02idRecpetora);
        Intent i = getIntent();
        mensaje.setText(i.getStringExtra(ut02Lanzadora.CLAVE_INFO));
    }
}