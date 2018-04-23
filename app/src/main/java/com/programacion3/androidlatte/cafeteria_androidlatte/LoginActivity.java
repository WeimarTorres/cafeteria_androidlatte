package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private String usuario1 = "UPB";
    private String usuario2 = "Case";
    private String contraseña1 = "123";
    private EditText usuario;
    private EditText contraseña;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contraseña);

    }

    public void click(View view) {
        Intent intent;
        if (view.getId() == R.id.nuevo) {
            intent = new Intent(this, RegisterActivity.class);
        } else if (view.getId() == R.id.entrar) {
            if (!esAdministrativo() && verificarDatos(usuario, contraseña)) {
                intent = new Intent(this, MenuActivity.class);
            } else if (esAdministrativo() && verificarDatos(usuario, contraseña)) {
                intent = new Intent(this, MenuActivity.class);
            } else {
                Toast.makeText(this, "Datos Erroneos", Toast.LENGTH_SHORT);
                intent = new Intent(this, LoginActivity.class);
            }
        } else {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
    }

    public boolean verificarDatos(EditText usuario, EditText contraseña) {
        if ((usuario1.equals(String.valueOf(usuario.getText())) || usuario2.equals(String.valueOf(usuario.getText()))) &&
                contraseña1 == String.valueOf(contraseña.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esAdministrativo() {
        if (usuario2.equals(String.valueOf(usuario.getText()))) {
            return true;
        } else {
            return false;
        }
    }

}
