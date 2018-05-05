package com.programacion3.androidlatte.cafeteria_androidlatte.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.programacion3.androidlatte.cafeteria_androidlatte.Usuario;

import java.util.LinkedList;
import java.util.List;

public class Almacenamiento extends SQLiteOpenHelper {

    public Almacenamiento(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE 'USUARIOS' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Usuario' TEXT, 'CodigoUPB' INTEGER UNIQUE, 'Password' TEXT, 'isAdmin' INTEGER)");
        //Codigo UPB? Para relacionar tablas
        sqLiteDatabase.execSQL("CREATE TABLE 'INVENTARIO' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Codigo' INTEGER UNIQUE, 'Nombre' TEXT, 'Cantidad' INTEGER, 'Precio' INTEGER)");
        //TODO Horario con datetime()
        sqLiteDatabase.execSQL("CREATE TABLE 'RESERVAS' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'CodigoUPB' INTEGER, 'Codigo' INTEGER, 'Horario' TEXT)");
        insertAdmin("Adela1", 1, "1234");
        insertAdmin("Adela2", 2, "1234");
        insertAdmin("Adela3", 3, "1234");
        insertAdmin("Adela4", 4, "1234");
        insertAdmin("Adela5", 5, "1234");
        insertAdmin("Adela6", 6, "1234");
        insertAdmin("Adela7", 7, "1234");
        insertAdmin("Adela8", 8, "1234");
        insertAdmin("Adela9", 9, "1234");
        insertAdmin("Adela10", 10, "1234");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'USUARIOS'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'INVENTARIO'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'RESERVAS'");
        onCreate(sqLiteDatabase);
    }

    public boolean insertAdmin(String nombre, int codigo, String password) {
        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put("Usuario", nombre);
            contentValues.put("CodigoUPB", codigo);
            contentValues.put("Password", password);
            contentValues.put("isAdmin", 1);

            getWritableDatabase().insertOrThrow("USUARIO", null, contentValues);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean insertUsuario(String nombre, int codigo, String password) {
        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put("Usuario", nombre);
            contentValues.put("CodigoUPB", codigo);
            contentValues.put("Password", password);
            contentValues.put("isAdmin", 0);

            getWritableDatabase().insertOrThrow("USUARIO", null, contentValues);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

//    public List<Usuario> selectAllUsuarios() {
//        List<Usuario> usuariosList = new LinkedList<>();
//        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM USUARIOS", null);
//        while (cursor.moveToNext()) {
//            usuariosList.add(new Usuario(cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
//        }
//        return usuariosList;
//    }

    public boolean updateUsuario(String nombre, int codigoUpb, String password) {
        try {
            getWritableDatabase().execSQL("UPDATE USUARIOS SET Usuario = '" + nombre + "', CodigoUPB = '" + codigoUpb + "' Password = " + password);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean deleteUsuario(int codigoUpb) {
        try {
            getWritableDatabase().delete("USUARIOS", "CodigoUpb = " + codigoUpb, null);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}


