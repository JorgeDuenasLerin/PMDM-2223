package com.example.pmdm_2223.ut05.api;

import com.google.gson.annotations.SerializedName;

public class LoginCredencial {
    @SerializedName("username")
    String username;
    @SerializedName("password")
    String password;

    public LoginCredencial(String name, String pass){
        username = name;
        password = pass;
    }
}
