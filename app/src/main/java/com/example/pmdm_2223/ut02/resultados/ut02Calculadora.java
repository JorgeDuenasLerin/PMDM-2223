package com.example.pmdm_2223.ut02.resultados;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class ut02Calculadora extends AppCompatActivity {

    Button boton;
    String datos;
    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut02_calculadora);
        boton = findViewById(R.id.ut02idRecibeBoton);
        label = findViewById(R.id.ut02idRecibeLabel);

        Intent i = getIntent();
        datos = i.getStringExtra("DATOS");

        label.setText(datos);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra("DATOS", datos.toUpperCase());
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}