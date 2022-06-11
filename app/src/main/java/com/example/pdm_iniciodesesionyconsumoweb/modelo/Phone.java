package com.example.pdm_iniciodesesionyconsumoweb.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Phone {
    @SerializedName("brand")
    @Expose
    public String brand;
    @SerializedName("phone_name")
    @Expose
    public String phoneName;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("detail")
    @Expose
    public String detail;

    public Phone(String brand, String phoneName, String slug, String image, String detail) {
        this.brand = brand;
        this.phoneName = phoneName;
        this.slug = slug;
        this.image = image;
        this.detail = detail;
    }
}
