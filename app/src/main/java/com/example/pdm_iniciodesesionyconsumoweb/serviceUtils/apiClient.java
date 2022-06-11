package com.example.pdm_iniciodesesionyconsumoweb.serviceUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiClient {
    private static Retrofit retrofit = null;
    public static Retrofit getClient(String urlBase){
        //si retrofit = null se hace la conexion
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(urlBase)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
