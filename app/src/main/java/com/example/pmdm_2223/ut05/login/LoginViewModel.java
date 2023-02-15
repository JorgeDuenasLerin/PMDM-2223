package com.example.pmdm_2223.ut05.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pmdm_2223.ut05.api.LoginResponse;

import java.util.ArrayList;

public class LoginViewModel extends ViewModel {
    private static final double TEST_WAIT = 2000;
    private static final double SUCCESS_PROBABILITY = 0.5;
    private MutableLiveData<LoginResponse> mlData;

    public LoginViewModel(){
        mlData = new MutableLiveData<LoginResponse>();
    }

    public LiveData<LoginResponse> getLoginResponse(){
        return mlData;
    }

    public void hacerLogin(String user, String pass){
        new Thread(()->{
            try {
                Thread.sleep((long) (Math.random()*TEST_WAIT));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LoginResponse respuesta = new LoginResponse();
            if(Math.random()>SUCCESS_PROBABILITY){
                respuesta.token="LOHASCONSEGUIDOCAMPEON";
                respuesta.nonFieldErrors = new ArrayList<String>();
            } else {
                respuesta.token="";
                respuesta.nonFieldErrors = new ArrayList<String>();
                respuesta.nonFieldErrors.add("Ha ocurrido un error");
            }
            mlData.postValue(respuesta);
        }).start();
    }
}
