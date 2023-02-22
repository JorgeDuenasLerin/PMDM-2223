package com.example.pmdm_2223.ut05.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface QuestionService {
    /*
    @POST("/polls/api-token-auth/")
    @FormUrlEncoded
    Call<LoginResponse> login(@Field("username") String username, @Field("username") String password);

     */
    @POST("/polls/api-token-auth/")
    Call<LoginResponse> login(@Body LoginCredencial login);
}