package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private TextView texto1;
    private TextView texto2;
    private Typeface Real;

    EditText usuario;
    EditText codigo;
    EditText contraseña;
    Button botón;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usuario = findViewById(R.id.usuarioRegistro);
        codigo = findViewById(R.id.codigoRegistro);
        contraseña = findViewById(R.id.contraseñaRegistro);
        botón = findViewById(R.id.botónRegistro);

        String fuente = "fuentes/KG.ttf";
        this.Real = Typeface.createFromAsset(getAssets(), fuente);

        texto1 = (TextView) findViewById(R.id.botónRegistro);
        texto2 = (TextView) findViewById(R.id.appName);
        texto1.setTypeface(Real);
        texto2.setTypeface(Real);
    }

    public void click(View view) {
        Intent intent;
        if (view.getId() == botón.getId()) {
            if (usuario.getText() != null && contraseña.getText() != null) {
                //TODO ver el caso en el que se pasa el codigo UPB
                intent = new Intent(this, LoginActivity.class);
                intent.putExtra("Usuario", String.valueOf(usuario.getText()));
                intent.putExtra("Contraseña", String.valueOf(contraseña.getText()));
                startActivity(intent);
            }
        }
    }

}
