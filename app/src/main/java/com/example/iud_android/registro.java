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

public class registro extends AppCompatActivity {

    private EditText usuario, clave;
    private Button inicio, registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuario = findViewById(R.id.txtUsuarioRegistro);
        clave = findViewById(R.id.txtPasswordRegistro);
        inicio = findViewById(R.id.btnIngresar);
        registro = findViewById(R.id.btnRegistroRegistro);

    }

    public void Login(View view){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void Registrar(View view){
        String user = usuario.getText().toString();
        String pass = clave.getText().toString();

        AdminSqlite admin = new AdminSqlite(this);
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues datos = new ContentValues();
        datos.put("user",user);
        datos.put("clave",pass);
        db.insert(AdminSqlite.TABLE_NAME,null,datos);

        Toast.makeText(this, "Usuario registrado con éxito",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}