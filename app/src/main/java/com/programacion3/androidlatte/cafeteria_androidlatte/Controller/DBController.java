package com.programacion3.androidlatte.cafeteria_androidlatte.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Item;
import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Usuario;
import com.programacion3.androidlatte.cafeteria_androidlatte.R;

import java.util.LinkedList;
import java.util.List;

public class DBController extends SQLiteOpenHelper {

    public DBController(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE 'USUARIOS' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Usuario' TEXT, 'CodigoUPB' INTEGER UNIQUE, 'Contraseña' TEXT, 'esAdministrador' INTEGER)");
        //Codigo UPB? Para relacionar tabla
        sqLiteDatabase.execSQL("CREATE TABLE 'INVENTARIO' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Codigo' INTEGER UNIQUE, 'Nombre' TEXT, 'Cantidad' INTEGER, 'Precio' INTEGER, 'Imagen' INTEGER)");
        //TODO Horario con datetime()
        sqLiteDatabase.execSQL("CREATE TABLE 'RESERVAS' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'CodigoUPB' INTEGER, 'Codigo' INTEGER, 'Horario' TEXT)");
        insertAdmin(sqLiteDatabase, "Adela1", 1, "1234");
        insertAdmin(sqLiteDatabase, "Adela2", 2, "1234");
        insertAdmin(sqLiteDatabase, "Adela3", 3, "1234");
        insertAdmin(sqLiteDatabase, "Adela4", 4, "1234");
        insertAdmin(sqLiteDatabase, "Adela5", 5, "1234");
        insertAdmin(sqLiteDatabase, "Adela6", 6, "1234");
        insertAdmin(sqLiteDatabase, "Adela7", 7, "1234");
        insertAdmin(sqLiteDatabase, "Adela8", 8, "1234");
        insertAdmin(sqLiteDatabase, "Adela9", 9, "1234");
        insertAdmin(sqLiteDatabase, "Adela10", 10, "12345");

        //TODO insertar comidas
        //ejemplo
        insertFood(sqLiteDatabase, 101, "Leche", 20, 5, R.drawable.soda);
        insertFood(sqLiteDatabase, 102, "Leche2", 20, 5, R.drawable.soda);
        insertFood(sqLiteDatabase, 201, "Papas", 20, 5, R.drawable.hamburguesa);
        insertFood(sqLiteDatabase, 202, "Papas2", 20, 5, R.drawable.hamburguesa);
        insertFood(sqLiteDatabase, 301, "Leche", 20, 5, R.drawable.soda);
        insertFood(sqLiteDatabase, 302, "Leche2", 20, 5, R.drawable.soda);
        insertFood(sqLiteDatabase, 401, "Papas", 20, 5, R.drawable.hamburguesa);
        insertFood(sqLiteDatabase, 402, "Papas2", 20, 5, R.drawable.hamburguesa);
        insertFood(sqLiteDatabase, 501, "Leche", 20, 5, R.drawable.soda);
        insertFood(sqLiteDatabase, 502, "Leche2", 20, 5, R.drawable.soda);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'USUARIOS'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'INVENTARIO'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'RESERVAS'");
        onCreate(sqLiteDatabase);
    }

    private void insertAdmin(String user, int code, String password) {
        insertAdmin(getWritableDatabase(), user, code, password);
    }

    private void insertAdmin(SQLiteDatabase database, String user, int code, String password) {
        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put("Usuario", user);
            contentValues.put("CodigoUPB", code);
            contentValues.put("Contraseña", password);
            contentValues.put("esAdministrador", 1);

            database.insertOrThrow("USUARIOS", null, contentValues);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void insertUsuario(String user, int code, String password) {
        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put("Usuario", user);
            contentValues.put("CodigoUPB", code);
            contentValues.put("Contraseña", password);
            contentValues.put("esAdministrador", 0);

            getWritableDatabase().insertOrThrow("USUARIOS", null, contentValues);
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Usuario> selectAllUsers() {
        List<Usuario> usersList = new LinkedList<>();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM USUARIOS", null);
        while (cursor.moveToNext()) {
            usersList.add(new Usuario(cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getInt(4)));
        }
        return usersList;
    }

    public Usuario selectUser(int codeUPB) {
        try {
            Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM USUARIOS WHERE CodigoUPB = " + codeUPB, null);
            cursor.moveToFirst();
            Usuario user = new Usuario(cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getInt(4));
            return user;
        } catch (IndexOutOfBoundsException e) {
            return new Usuario("Error", -1, "0", 0);
        }
    }

    public void updateUsuario(String nombre, int codigoUpb, String password) {
        try {
            getWritableDatabase().execSQL("UPDATE USUARIOS SET Usuario = '" + nombre + "', CodigoUPB = '" + codigoUpb + "' Password = " + password);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void deleteUsuario(int codigoUpb) {
        try {
            getWritableDatabase().delete("USUARIOS", "CodigoUpb = " + codigoUpb, null);
        } catch (SQLException e) {
            throw e;
        }
    }

    //CREATE TABLE 'INVENTARIO' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Codigo' INTEGER UNIQUE, 'Nombre' TEXT, 'Cantidad' INTEGER, 'Precio' INTEGER)

    private void insertFood(SQLiteDatabase database, int codeFood, String name, int quantity, int price, int image) {
        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put("Codigo", codeFood);
            contentValues.put("Nombre", name);
            contentValues.put("Cantidad", quantity);
            contentValues.put("Precio", price);
            contentValues.put("Imagen", image);

            database.insertOrThrow("INVENTARIO", null, contentValues);
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Item> selectAllItems() {
        List<Item> itemsList = new LinkedList<>();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM INVENTARIO", null);
        while (cursor.moveToNext()) {
            itemsList.add(new Item(cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)));
        }
        return itemsList;
    }

    public Item selectItem(int codeFood) {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM INVENTARIO WHERE Codigo = " + codeFood, null);
        cursor.moveToFirst();
        Item item = new Item(cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5));
        return item;
    }

}


