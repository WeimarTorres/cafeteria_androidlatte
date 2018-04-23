package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void click(View view) {
        Intent intent;
        if (view.getId() == R.id.nuevo) {
            intent = new Intent(this, RegisterActivity.class);
        } else if (view.getId() == R.id.entrar) {
            if (verificarDatos()) {
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

    public boolean verificarDatos () {
        return true;
    }

}
