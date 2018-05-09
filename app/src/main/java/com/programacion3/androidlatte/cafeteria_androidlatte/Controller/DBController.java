package com.programacion3.androidlatte.cafeteria_androidlatte.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Item;
import com.programacion3.androidlatte.cafeteria_androidlatte.Models.ItemReservas;
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
        sqLiteDatabase.execSQL("CREATE TABLE 'INVENTARIO' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Codigo' INTEGER UNIQUE, 'Nombre' TEXT, 'Cantidad' INTEGER, 'Precio' INTEGER, 'Imagen' INTEGER)");
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

        insertFood(sqLiteDatabase, 101, "Leche", 20, 5, R.drawable.leche_taza);
        insertFood(sqLiteDatabase,102,"Cafe",15,5,R.drawable.cafe_taza);
        insertFood(sqLiteDatabase, 103,"Té",10,5,R.drawable.te_taza);
        insertFood(sqLiteDatabase,104,"Jugo de naranja",15,4,R.drawable.jugo_naranja);
        insertFood(sqLiteDatabase, 105, "Panqueque", 20, 5, R.drawable.panqueques);

        insertFood(sqLiteDatabase, 201, "Milanesa", 20, 5, R.drawable.comidastipicasargentinamilanesa);
        insertFood(sqLiteDatabase, 202, "Lassagna", 20, 5, R.drawable.lasana);
        insertFood(sqLiteDatabase,203,"Albondigas",10,17,R.drawable.albondigas);
        insertFood(sqLiteDatabase,204,"Spaguetti Alfredo",11,18,R.drawable.spaguetti_alfredo);
        insertFood(sqLiteDatabase,205,"Alitas",14,20, R.drawable.alitas);

        insertFood(sqLiteDatabase, 301, "Verduras", 20, 5, R.drawable.verdura);
        insertFood(sqLiteDatabase, 302, "Frutas", 20, 5, R.drawable.im);
        insertFood(sqLiteDatabase, 303,"Croisssant",15,5,R.drawable.croisant);
        insertFood(sqLiteDatabase,304,"Ensalada de frutas",10,7, R.drawable.ensalada_de_frutas);


        insertFood(sqLiteDatabase, 401, "Combo Hamburguesa con refresco", 20, 5, R.drawable.comidarapida);
        insertFood(sqLiteDatabase, 402, "Silpancho", 20, 5, R.drawable.silpancho);
        insertFood(sqLiteDatabase,403,"Hamburguesa con papas",10,15, R.drawable.hamburguesa_papas);
        insertFood(sqLiteDatabase,404,"Pizza con Sprite",5,9, R.drawable.pizza_pepsi);

        insertFood(sqLiteDatabase, 501, "Sandwitch de palta", 20, 5, R.drawable.foodie);
        insertFood(sqLiteDatabase, 502, "Lays", 20, 5, R.drawable.rrr);
        insertFood(sqLiteDatabase,503,"Salteña",17,6, R.drawable.saltenia);
        insertFood(sqLiteDatabase,504,"Coca Cola 300 ml",30, 3, R.drawable.coca_300);
        insertFood(sqLiteDatabase,505,"Tucumana",14,5, R.drawable.tucumana);

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
        try {
            Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM INVENTARIO WHERE Codigo = " + codeFood, null);
            cursor.moveToFirst();
            Item item = new Item(cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5));
            return item;
        } catch (IndexOutOfBoundsException e) {
            return new Item(-1, "Error", 0, 0, 0);
        }
    }

    //CREATE TABLE 'RESERVAS' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'CodigoUPB' INTEGER, 'Codigo' INTEGER, 'Horario' TEXT)

    private void insertReserve(int codeUPB, int codeFood, String time) {
        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put("CodigoUPB", codeUPB);
            contentValues.put("Codigo", codeFood);
            contentValues.put("Horario", time);

            getReadableDatabase().insertOrThrow("RESERVAS", null, contentValues);
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<ItemReservas> selectAllItemReservas() {
        try {
            List<ItemReservas> itemReservasList = new LinkedList<>();
            Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM RESERVAS", null);
            while (cursor.moveToNext()) {
                Usuario user = selectUser(cursor.getInt(1));
                Item item = selectItem(cursor.getInt(2));
                itemReservasList.add(new ItemReservas(user.getUsername(), user.getCodigo(), item.getCodeFood(),
                        item.getName(), item.getPrice(), item.getImage(), cursor.getString(3)));
            }
            return itemReservasList;
        } catch (IndexOutOfBoundsException e) {
            return new LinkedList<>();
        }
    }

}