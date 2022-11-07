package com.example.pmdm_2223.ut03.datos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2223.R;

import java.nio.file.Files;
import java.util.List;

public class ut03Datos extends AppCompatActivity {

    Button add;
    Button recargar;
    EditText nombre;
    EditText tipo;
    TextView datos;
    AppDatabase db;
    AnimalDAO animalDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut03_datos);

        add = findViewById(R.id.ut03idAnimalAdd);
        recargar = findViewById(R.id.ut03idAnimalRefresca);
        nombre = findViewById(R.id.ut03idAnimalNombre);
        tipo = findViewById(R.id.ut03idAnimalTipo);
        datos = findViewById(R.id.ut03idAnimalDatos);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "animales").allowMainThreadQueries().build();
        animalDao = db.animalDao();

        recargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Animal> animales = animalDao.getAll();
                String sData = "";
                for(Animal a : animales ){
                    sData += a.nombre + " - " + a.tipo + "\n";
                }
                datos.setText(sData);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal a = new Animal();
                a.nombre = nombre.getText().toString();
                a.tipo = tipo.getText().toString();
                animalDao.insertAll(a);
            }
        });


    }
}