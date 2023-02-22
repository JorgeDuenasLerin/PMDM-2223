package com.example.pmdm_2223.ut05.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmdm_2223.R;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText user;
    EditText password;
    TextView mensaje;
    ProgressBar pro;

    LoginViewModel vml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut05_login);
        login = findViewById(R.id.ut05_id_button_login);
        user = findViewById(R.id.ut05_id_login);
        password = findViewById(R.id.ut05_id_password);
        mensaje = findViewById(R.id.ut05_id_error);
        pro = findViewById(R.id.ut05_id_login_progress);

        /* Recoger el ViewModel de esta actividad */
        vml = new ViewModelProvider(this).get(LoginViewModel.class);

        /* Observar cuando el ViewModel tenga respuesta */
        vml.getLoginResponse().observe(this, (respuesta) -> {
            login.setVisibility(View.VISIBLE);
            pro.setVisibility(View.INVISIBLE);
            if(respuesta.nonFieldErrors.size()>0){
                mensaje.setText(respuesta.nonFieldErrors.get(0));
            } else {
                /* Pasar a la siguiente Actividad */
                Toast.makeText(this, "Login OK", Toast.LENGTH_LONG).show();
            }
        });

        /* Al hacer click en login hacer llamada de ViewModel */
        login.setOnClickListener((v)->{
            login.setVisibility(View.INVISIBLE);
            pro.setVisibility(View.VISIBLE);
            vml.hacerLogin(user.getText().toString(), password.getText().toString());
        });
    }
}