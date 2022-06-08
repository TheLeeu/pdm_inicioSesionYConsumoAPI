package com.example.pdm_iniciodesesionyconsumoweb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText et_email, et_contrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        et_email = (EditText)  findViewById(R.id.etEmail);
        et_contrasenia = (EditText) findViewById(R.id.etContrasenia);

    }

    public void btnRegistrarse(View view) {
        Intent intent = new Intent(this, Registrarse.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(this, "Sesion esta iniciada", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnLogin(View view) {
        //Valida que campos no esten vacios
        if(!et_email.getText().toString().isEmpty() && !et_contrasenia.getText().toString().isEmpty()){
            //Acceder al usuario
            mAuth.signInWithEmailAndPassword(et_email.getText().toString(), et_contrasenia.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Iniciando sesion", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MainActivity.this, "Fallo al iniciar sesion", Toast.LENGTH_SHORT).show();
                                et_email.setText("");
                                et_contrasenia.setText("");

                            }
                        }
                    });
        }else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}