package com.programacion3.androidlatte.cafeteria_androidlatte.UI.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.programacion3.androidlatte.cafeteria_androidlatte.Controller.DBController;
import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Usuario;
import com.programacion3.androidlatte.cafeteria_androidlatte.R;

import java.util.LinkedList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private EditText code;
    private CheckBox checkBox;
    private SharedPreferences sharedPreferences;
    private DBController dbController;

    static final String SHARED_PREFERENCES = "sharedPreferences";
    static final String KEY_REMEMBER = "rememberOneTimeLogin";
    static final String KEY_IS_ADMINISTRATIVE = "rememberIsAdministrative";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView text1;
        TextView text2;
        TextView text3;
        TextView text4;
        Typeface real;

        String font = "font/KG.ttf";
        real = Typeface.createFromAsset(getAssets(), font);

        text1 = (TextView) findViewById(R.id.enter);
        text2 = (TextView) findViewById(R.id.New);
        text3 = (TextView) findViewById(R.id.appName);
        text4 = (TextView) findViewById(R.id.checkboxLogin);
        text1.setTypeface(real);
        text2.setTypeface(real);
        text3.setTypeface(real);
        text4.setTypeface(real);

        user = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        code = findViewById(R.id.codeLogin);
        checkBox = findViewById(R.id.checkboxLogin);
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        dbController = new DBController(this, "DBCafeteria.db", null, 1);

    }

    public void click(View view) {
        Intent intent;
        if (view.getId() == R.id.New) {
            intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.enter) {
            if (code.getText().equals("")) {
                if (!esAdministrativo(Integer.parseInt(code.getText().toString())) && verificarDatos(user.getText().toString(), password.getText().toString())) {
                    user.setText("");
                    password.setText("");
                    if (checkBox.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(KEY_REMEMBER, true);
                        editor.putBoolean(KEY_IS_ADMINISTRATIVE, false);
                        editor.apply();
                    }
                    intent = new Intent(this, MenuActivity.class);
                    startActivity(intent);
                } else if (esAdministrativo(Integer.parseInt(code.getText().toString())) && verificarDatos(user.getText().toString(), password.getText().toString())) {
                    user.setText("");
                    password.setText("");
                    if (checkBox.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(KEY_REMEMBER, true);
                        editor.putBoolean(KEY_IS_ADMINISTRATIVE, true);
                        editor.apply();
                    }
                    intent = new Intent(this, MenuCaseActivity.class);
                    startActivity(intent);
                } else {
                    user.setText("");
                    password.setText("");
                    Toast.makeText(this, "¡Datos Erroneos!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "No hay datos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean verificarDatos(String user, String password) {
        List<Usuario> userList;
        userList = dbController.selectAllUsers();
        boolean verified = false;
        for (Usuario user1: userList) {
            if (user1.getUsername().equals(user) && user1.getPassword().equals(password)) {
                verified = true;
            }
        }
        return verified;
    }

    public boolean esAdministrativo(int codeUPB) {
        Usuario user = dbController.selectUser(codeUPB);
        return user.isAdministrator();
    }
}
