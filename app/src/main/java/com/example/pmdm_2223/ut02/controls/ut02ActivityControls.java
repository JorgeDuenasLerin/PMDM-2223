package com.example.pmdm_2223.ut02.controls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class ut02ActivityControls extends AppCompatActivity {

    TextView tvArriba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);
        tvArriba = findViewById(R.id.tvPhone);
    }
}