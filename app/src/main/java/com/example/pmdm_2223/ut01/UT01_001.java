package com.example.pmdm_2223.ut01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.pmdm_2223.R;

public class UT01_001 extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut01001);
        Log.d("LifeCycle", "Se ha llmado al mmétodo OnCreate");
    }

}