package com.example.pmdm_2223.ut01;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Manejador implements View.OnClickListener{

    Contador contador;
    TextView salida;
    Button suma;
    Button reset;
    UT01_002 actividad;

    public Manejador(TextView s, Button sum, Button res, UT01_002 acti) {
        contador = new Contador();
        salida = s;
        suma = sum;
        reset = res;
        actividad = acti;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == suma.getId()) {
            actividad.add();
            contador.add();
        } else {
            actividad.resta(contador);
            contador.reset();
        }
        salida.setText(contador.getCounter());
    }

    public void reset() {
        contador.reset();
        salida.setText(contador.getCounter());
    }
}
