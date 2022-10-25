package com.example.pmdm_2223.ut02.ejercicios;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm_2223.R;

public class ut02Lanza1 extends AppCompatActivity {

    private static final String DATOS = "DATOS";
    Button lanzar;
    Button finalizar;
    EditText datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut02_lanza1);
        lanzar = findViewById(R.id.ut02idLanzaUnoBoton);
        finalizar = findViewById(R.id.ut02idLanzaUnoFin);
        datos = findViewById(R.id.ut02idLanzaUnoText);

        ActivityResultLauncher<Intent> actividad1 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    switch (result.getResultCode()){
                        case Activity.RESULT_CANCELED:
                            datos.setText("");
                            break;
                        case Activity.RESULT_OK:
                            // Nada, se deja la información
                            break;
                        case Activity.RESULT_FIRST_USER:
                            Intent data = result.getData();
                            datos.setText(data.getStringExtra(ut02Lanza1.DATOS));
                            break;
                    }
                }
            }
        );

        lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ut02Lanza1.this, ut02Lanza2.class);
                i.putExtra(ut02Lanza1.DATOS, datos.getText().toString());
                actividad1.launch(i);
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}