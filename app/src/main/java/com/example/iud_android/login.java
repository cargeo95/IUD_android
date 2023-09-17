package com.example.iud_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText usuario, clave;
    private Button inicio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.txtUsuario);
        clave = findViewById(R.id.txtPassword);

        inicio = findViewById(R.id.btnIngresar);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Pulse el boton", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void Validar(View view){
        String user = usuario.getText().toString();
        String pass = clave.getText().toString();
        //Toast.makeText(getApplicationContext(),"Pulse de nuevo el boton", Toast.LENGTH_LONG).show();

    }
}