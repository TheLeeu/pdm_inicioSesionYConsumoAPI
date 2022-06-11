package com.example.pdm_iniciodesesionyconsumoweb.serviceUtils;

import com.example.pdm_iniciodesesionyconsumoweb.modelo.services;

public class apiUtils {
    public static final String base = "https://api-mobilespecs.azharimm.site/v2/brands/";
    public static services getServices(){
        return apiClient.getClient(base).create(services.class);
    }
}
