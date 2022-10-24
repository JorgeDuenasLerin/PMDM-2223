package com.example.pmdm_2223.ut02.resultados;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class ut02LanzadoraAntigua extends AppCompatActivity {

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

        lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ut02LanzadoraAntigua.this, ut02Calculadora.class);
                intent.putExtra("DATOS", datos.getText().toString());
                startActivityForResult(intent, LAUNCH_CODE);
            }
        });
    }

    private static int LAUNCH_CODE = 42;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LAUNCH_CODE){
            if(resultCode == Activity.RESULT_OK){
                resultado.setText(data.getStringExtra("DATOS"));
            }
        }
    }
}