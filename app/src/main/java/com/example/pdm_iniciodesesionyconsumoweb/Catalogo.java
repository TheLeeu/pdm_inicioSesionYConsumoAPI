package com.example.pdm_iniciodesesionyconsumoweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pdm_iniciodesesionyconsumoweb.modelo.Data;
import com.example.pdm_iniciodesesionyconsumoweb.modelo.Phone;
import com.example.pdm_iniciodesesionyconsumoweb.modelo.modelo;
import com.example.pdm_iniciodesesionyconsumoweb.modelo.services;
import com.example.pdm_iniciodesesionyconsumoweb.serviceUtils.apiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Catalogo extends AppCompatActivity {

    public services servicioImplementado;
    ArrayList<Phone> data;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        list = (ListView)findViewById(R.id.listCatalogo);
        data = new ArrayList<Phone>();
        llenar();
    }

    public void llenar(){
        servicioImplementado = apiUtils.getServices();
        servicioImplementado.getDatos().enqueue(new Callback<modelo>() {
            @Override
            public void onResponse(Call<modelo> call, Response<modelo> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Catalogo.this, "Entra", Toast.LENGTH_SHORT).show();

                    modelo m = response.body();
                    List<Phone> p = m.data.phones;
                    for (Phone item: p) {
                        data.add(item);
                    }
                    adaptadorPhone adap =new adaptadorPhone(data,getApplicationContext());
                    list.setAdapter(adap);
                    //Log.d("E", String.valueOf(m.data.phones.get(0).phoneName));

                }else{
                    Toast.makeText(Catalogo.this, "Error: "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Call<modelo> call, Throwable t) {
                Log.d("Failure",t.getMessage());
            }
        });
    }
}