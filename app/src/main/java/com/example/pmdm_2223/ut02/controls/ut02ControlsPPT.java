package com.example.pmdm_2223.ut02.controls;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pmdm_2223.R;

import java.util.Random;

public class ut02ControlsPPT extends AppCompatActivity {

    enum Jugada {
        PIEDRA,
        PAPEL,
        TIJERA
    }

    ImageButton piedra;
    ImageButton tijera;
    ImageButton papel;

    TextView jugada;
    TextView result;

    TextView puntosYo;
    TextView puntosMaquina;

    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut02_controls_ppt);

        piedra = findViewById(R.id.ut02idPiedra);
        tijera = findViewById(R.id.ut02idTijera);
        papel = findViewById(R.id.ut02idPapel);

        jugada = findViewById(R.id.ut02idJugadaApp);
        result = findViewById(R.id.ut02idResult);

        puntosYo = findViewById(R.id.ut02idYo);
        puntosMaquina = findViewById(R.id.ut02idMaquina);

        reset = findViewById(R.id.ut02idReset);
        reset();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        View.OnClickListener manejador = new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Jugada maquina = maquinaJuega();
                Jugada jugador;
                if (v.getId() == piedra.getId()) {
                    jugador = Jugada.PIEDRA;
                } else if (v.getId() == papel.getId()){
                    jugador = Jugada.PAPEL;
                } else {
                    jugador = Jugada.TIJERA;
                }

                jugada.setText(""+maquina);

                if(maquina == jugador) {
                    result.setText("Empate");
                    result.setBackgroundColor(0xFFFEF5E7);
                } else if(
                        ((maquina == Jugada.PAPEL) && (jugador == Jugada.TIJERA)) ||
                        ((maquina == Jugada.PIEDRA) && (jugador == Jugada.PAPEL)) ||
                        ((maquina == Jugada.TIJERA) && (jugador == Jugada.PIEDRA))
                ) {
                    iYo++;
                    puntosYo.setText(""+iYo);
                    result.setText("¡Ganas!");
                    result.setBackgroundColor(0xFFD5F5E3);
                } else {
                    iMaquina++;
                    puntosMaquina.setText(""+iMaquina);
                    result.setText("Pierdes :(");
                    result.setBackgroundColor(0xFFFADBD8);
                }
            }
        };

        tijera.setOnClickListener(manejador);
        papel.setOnClickListener(manejador);
        piedra.setOnClickListener(manejador);
    }


    int iYo;
    int iMaquina;

    private void reset(){
        iYo = 0;
        iMaquina = 0;
        puntosYo.setText(""+iYo);
        puntosMaquina.setText(""+iMaquina);
        result.setText("");
        jugada.setText("");
    }

    private Jugada maquinaJuega(){
        return Jugada.values()[new Random().nextInt(Jugada.values().length)];
    }
}