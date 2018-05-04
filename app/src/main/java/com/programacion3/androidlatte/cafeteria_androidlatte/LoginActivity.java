package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView texto1;
    private TextView texto2;
    private TextView texto3;
    private Typeface Real;

    private String usuario1 = "UPB";
    private String usuario2 = "Case";
    private String contraseña1 = "123";
    private String usuario3;
    private String contraseña2;
    private EditText usuario;
    private EditText contraseña;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario3 = getIntent().getStringExtra("Usuario");
        contraseña2 = getIntent().getStringExtra("Contraseña");

        usuario = (EditText) findViewById(R.id.usuario);
        contraseña = (EditText) findViewById(R.id.contraseña);

        String fuente = "fuentes/KG.ttf";
        this.Real = Typeface.createFromAsset(getAssets(), fuente);

        texto1 = (TextView) findViewById(R.id.entrar);
        texto2 = (TextView) findViewById(R.id.nuevo);
        texto3 = (TextView) findViewById(R.id.appName);
        texto1.setTypeface(Real);
        texto2.setTypeface(Real);
        texto3.setTypeface(Real);

    }

    public void click(View view) {
        Intent intent;
        if (view.getId() == R.id.nuevo) {
            intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.entrar) {
            if (!esAdministrativo() && verificarDatos(usuario, contraseña)) {
                usuario.setText("");
                contraseña.setText("");
                intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
            } else if (esAdministrativo() && verificarDatos(usuario, contraseña)) {
                usuario.setText("");
                contraseña.setText("");
                intent = new Intent(this, MenuCaseActivity.class);
                startActivity(intent);
            } else {
                usuario.setText("");
                contraseña.setText("");
                Toast.makeText(this, "¡Datos Erroneos!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean verificarDatos(EditText usuario, EditText contraseña) {
        if (usuario3 != null && contraseña2 != null) {
            if ((usuario1.equals(String.valueOf(usuario.getText())) && contraseña1.equals(String.valueOf(contraseña.getText()))) ||
                    (usuario2.equals(String.valueOf(usuario.getText())) && contraseña1.equals(String.valueOf(contraseña.getText()))) ||
                    (usuario3.equals(String.valueOf(usuario.getText())) && contraseña2.equals(String.valueOf(contraseña.getText())))) {
                return true;
                //TODO verificar con codigo upb
            } else {
                return false;
            }
        } else {
            if ((usuario1.equals(String.valueOf(usuario.getText())) && contraseña1.equals(String.valueOf(contraseña.getText()))) ||
                    (usuario2.equals(String.valueOf(usuario.getText())) && contraseña1.equals(String.valueOf(contraseña.getText())))) {
                return true;
                //TODO verificar con codigo upb
            } else {
                return false;
            }
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
