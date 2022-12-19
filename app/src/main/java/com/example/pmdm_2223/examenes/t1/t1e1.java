package com.example.pmdm_2223.examenes.t1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pmdm_2223.R;
public class t1e1 extends AppCompatActivity {

    RecyclerView rcv;
    ProductoAdapter a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t1e1);

        rcv = findViewById(R.id.examen_t1_e1_rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        a = new ProductoAdapter(Producto.generador());
        rcv.setAdapter(a);

        a.setClickListener(new ProductoAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(t1e1.this,"Pulsado"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}