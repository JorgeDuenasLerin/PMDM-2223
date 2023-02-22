package com.example.pmdm_2223.ut05.api;

import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionRepositorio {
    private static final String API_URL = "http://192.168.20.200:8000";

    private static QuestionRepositorio instancia;

    private QuestionService service;

    private QuestionRepositorio(){
        service = new retrofit2.Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(QuestionService.class);
    };

    public static QuestionRepositorio getInstance(){
        if(instancia==null){
            instancia = new QuestionRepositorio();
        }
        return instancia;
    }

    public Call<LoginResponse> login(String username, String password){
        return service.login(new LoginCredencial(username, password));
        //return service.login(username, password);
        /*LoginCredencial credential = new LoginCredencial();
        credential.username = username;
        credential.password = password;
        return service.login(credential.username, credential.password);*/
    }



}
