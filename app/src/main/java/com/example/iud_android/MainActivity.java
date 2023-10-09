package com.example.iud_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, clave;
    private Button actualizar, consultar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.txtUsuarioActivity);
        clave = findViewById(R.id.txtPasswordActivity);
        actualizar = findViewById(R.id.btnConsultar);
        consultar = findViewById(R.id.btnActualizar);
        eliminar = findViewById(R.id.btnEliminar);

    }


    public void Consultar(View view){
        String user = usuario.getText().toString();
        String columns[] = new String[]{"user","clave"};

        AdminSqlite admin = new AdminSqlite(this);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM usuario WHERE user = '"+user+"'", null);

        if(cursor!=null){
            if(cursor.moveToFirst()){
                clave.setText(cursor.getString(2));
            }
        }

    }

    public void Eliminar(View view){
        String user = usuario.getText().toString();

        AdminSqlite admin = new AdminSqlite(this);
        SQLiteDatabase db = admin.getWritableDatabase();

        int res = db.delete("usuario","user='"+user+"'",null);
        if(res!=0){
            Toast.makeText(this, "Usuario eliminado con éxito",Toast.LENGTH_SHORT).show();
            usuario.setText("");
            clave.setText("");
        }else{
            Toast.makeText(this, "Usuario no encontrado",Toast.LENGTH_SHORT).show();
        }

    }

    public void Actualizar(View view){
        String user = usuario.getText().toString();
        String pass = clave.getText().toString();

        AdminSqlite admin = new AdminSqlite(this);
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("clave",pass);

        int res = db.update("usuario",valores,"user='"+user+"'",null);

        if(res!=0){
            Toast.makeText(this, "Actualizado con éxito",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No se actualizó",Toast.LENGTH_SHORT).show();
        }

        usuario.setText("");
        clave.setText("");


    }


}