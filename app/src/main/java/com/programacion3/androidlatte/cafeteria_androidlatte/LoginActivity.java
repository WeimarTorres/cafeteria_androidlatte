package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

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

        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contraseña);

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
