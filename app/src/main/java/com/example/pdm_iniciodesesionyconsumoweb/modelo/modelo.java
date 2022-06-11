package com.example.pdm_iniciodesesionyconsumoweb.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class modelo {
    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("data")
    @Expose
    public Data data;

    public modelo(Boolean status, Data data) {
        this.status = status;
        this.data = data;
    }
}
