package com.example.pmdm_2223.ut02.resultados;

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
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class ut02Lanzadora extends AppCompatActivity {

    TextView datos;
    Button lanzar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut02_lanzadora);
        datos = findViewById(R.id.ut02idResultadosText);
        lanzar = findViewById(R.id.ut02idResultadosBoton);
        resultado = findViewById(R.id.ut02idResultadosLabel);

        /*
        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // Here, no request code
                            Intent data = result.getData();
                            resultado.setText(data.getStringExtra("DATOS"));
                        }
                    }
                }
        );*/
        ActivityResultLauncher<Intent> lanzadora = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), (result)->{
                if (result.getResultCode() == Activity.RESULT_OK) {
                    // Here, no request code
                    Intent data = result.getData();
                    resultado.setText(data.getStringExtra("DATOS"));
                }
            }
        );

        lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ut02Lanzadora.this, ut02Calculadora.class);
                intent.putExtra("DATOS", datos.getText().toString());
                lanzadora.launch(intent);
            }
        });
    }
}