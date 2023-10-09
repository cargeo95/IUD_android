package com.example.iud_android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSqlite extends SQLiteOpenHelper {

    //Table name
    public static final String TABLE_NAME ="usuario";

    private String user = "user";
    private String clave = "clave";
    private String id = "id";

    static final String DB_NAME = "clientes";
    static final int DB_VERSION = 1;

    public AdminSqlite(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                user + " TEXT NOT NULL," +
                clave + " TEXT NOT NULL" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
}
