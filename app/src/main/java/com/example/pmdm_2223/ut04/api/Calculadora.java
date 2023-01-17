package com.example.pmdm_2223.ut04.api;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdm_2223.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Calculadora extends AppCompatActivity {

    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        label = findViewById(R.id.idAPIlabel);
        Call<Resultado> llamada = MatesAPI.getInstance().suma(7,8);
        llamada.enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                Resultado res = response.body();
                label.setText(res.resultado);
            }

            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {
                label.setText("error" + t.getMessage());
            }
        });
    }
}