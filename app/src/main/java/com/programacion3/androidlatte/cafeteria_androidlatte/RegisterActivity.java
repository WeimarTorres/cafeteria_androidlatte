package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.programacion3.androidlatte.cafeteria_androidlatte.Controller.Almacenamiento;

public class RegisterActivity extends AppCompatActivity {

    private TextView texto1;
    private TextView texto2;
    private Typeface Real;

    EditText usuario;
    EditText codigo;
    EditText password;
    Button button;
    Almacenamiento almacenamiento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usuario = findViewById(R.id.usuarioRegistro);
        codigo = findViewById(R.id.codigoRegistro);

        String fuente = "fuentes/KG.ttf";
        this.Real = Typeface.createFromAsset(getAssets(), fuente);

        texto1 = (TextView) findViewById(R.id.botónRegistro);
        texto2 = (TextView) findViewById(R.id.appName);
        texto1.setTypeface(Real);
        texto2.setTypeface(Real);
        password = findViewById(R.id.passwordRegistro);
        button = findViewById(R.id.buttonRegistro);

        almacenamiento = new Almacenamiento(this, "Cuentas.db", null, 1 );
    }

    public void click(View view) {

        almacenamiento.insertUsuario(usuario.getText().toString(), Integer.parseInt(codigo.getText().toString()), password.getText().toString());

        Intent intent;
        if (view.getId() == button.getId()) {
            if (usuario.getText() != null && password.getText() != null) {
                intent = new Intent(this, LoginActivity.class);
                intent.putExtra("Usuario", String.valueOf(usuario.getText()));
                intent.putExtra("password", String.valueOf(password.getText()));
                startActivity(intent);
            }
        }
    }

}
