package com.example.pdm_iniciodesesionyconsumoweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Registrarse extends AppCompatActivity {
    private EditText et_email, et_c1,et_c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        et_email = (EditText) findViewById(R.id.etEmailR);
        et_c1 = (EditText) findViewById(R.id.etContrasenia1);
        et_c2 = (EditText) findViewById(R.id.etContrasenia2);
    }
}