package com.example.pdm_iniciodesesionyconsumoweb.modelo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface services {
    @GET("apple-phones-48")
    Call<modelo> getDatos();
}
