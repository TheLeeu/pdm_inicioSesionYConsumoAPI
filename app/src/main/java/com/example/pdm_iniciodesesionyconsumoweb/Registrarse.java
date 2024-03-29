package com.example.pdm_iniciodesesionyconsumoweb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registrarse extends AppCompatActivity {
    private EditText et_email, et_c1,et_c2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        et_email = (EditText) findViewById(R.id.etEmailR);
        et_c1 = (EditText) findViewById(R.id.etContrasenia1);
        et_c2 = (EditText) findViewById(R.id.etContrasenia2);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }

    public void btnRegistro(View view) {
        //Validar que los campos no esten vacios
        if(!et_email.getText().toString().isEmpty() && !et_c1.getText().toString().isEmpty()
        && !et_c2.getText().toString().isEmpty()){

            //Validar que las contrasenias sean las mismas
            if(et_c1.getText().toString().equals(et_c2.getText().toString())){

                //Validar que las contrasenias tengan almenos 6 caracteres
                if(et_c1.getText().toString().length() >= 6){
                    //Crear nuevo usuario
                    mAuth.createUserWithEmailAndPassword(et_email.getText().toString(),et_c1.getText().toString())
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Registrarse.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }else{
                                        Toast.makeText(Registrarse.this, "Fallo al registrar", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }else{
                    Toast.makeText(this, "La contrasenia debe tener al menos 6 caracteres", Toast.LENGTH_LONG).show();
                }



            }else{
                Toast.makeText(this, "Las contrasenias no son iguales", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }
}