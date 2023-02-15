package com.example.pmdm_2223.ut05.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface QuestionService {
    @POST("/polls/api-token-auth/")
    Call<LoginResponse> login(@Body LoginCredencial credenciales);
}
