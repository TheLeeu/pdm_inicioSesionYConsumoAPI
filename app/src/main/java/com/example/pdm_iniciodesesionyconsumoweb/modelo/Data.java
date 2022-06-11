package com.example.pdm_iniciodesesionyconsumoweb.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("current_page")
    @Expose
    public Integer currentPage;
    @SerializedName("last_page")
    @Expose
    public Integer lastPage;
    @SerializedName("phones")
    @Expose
    public List<Phone> phones = null;

    public Data(String title, Integer currentPage, Integer lastPage, List<Phone> phones) {
        this.title = title;
        this.currentPage = currentPage;
        this.lastPage = lastPage;
        this.phones = phones;
    }
}
