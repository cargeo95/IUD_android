package com.example.iud_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;

public class login extends AppCompatActivity {
    private EditText usuario, clave;
    private Button inicio, registro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.txtUsuario);
        clave = findViewById(R.id.txtPassword);
        inicio = findViewById(R.id.btnIngresar);
        registro = findViewById(R.id.btnRegistro);

    }
    public void Validar(View view){
        String user = usuario.getText().toString();
        String pass = clave.getText().toString();

        if(user.isEmpty()){
            Toast.makeText(getApplicationContext(),"Usuario erroneo", Toast.LENGTH_LONG).show();
            usuario.setError("Usuario Vacio");
            usuario.requestFocus();

        } else if(pass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Clave erronea", Toast.LENGTH_LONG).show();
            clave.setError("Clave Vacio");
            clave.requestFocus();

        } else if (user.equals("admin") && pass.equals("1234")) {
            Toast.makeText(this, "Ingreso con éxito",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }

    }

    public void Registro(View view){
        Intent intent = new Intent(this, registro.class);
        startActivity(intent);
    }




}