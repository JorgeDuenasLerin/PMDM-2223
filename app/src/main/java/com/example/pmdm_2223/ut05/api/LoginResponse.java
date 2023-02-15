package com.example.pmdm_2223.ut05.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse {
    @Expose
    public String token;

    @SerializedName("non_field_errors")
    @Expose
    public List<String> nonFieldErrors;
}
