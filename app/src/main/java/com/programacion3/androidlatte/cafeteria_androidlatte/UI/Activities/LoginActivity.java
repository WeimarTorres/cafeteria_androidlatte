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

    private String usuario1 = "UPB";
    private String usuario2 = "Case";
    private String contraseña1 = "123";
    private String usuario3;
    private String contraseña2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView text1;
        TextView text2;
        TextView text3;
        Typeface real;

        String font = "font/KG.ttf";
        real = Typeface.createFromAsset(getAssets(), font);

        text1 = findViewById(R.id.enter);
        text2 = findViewById(R.id.New);
        text3 = findViewById(R.id.appName);
        text1.setTypeface(real);
        text2.setTypeface(real);
        text3.setTypeface(real);

        usuario3 = getIntent().getStringExtra("Usuario");
        contraseña2 = getIntent().getStringExtra("Contraseña");

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
            if (!esAdministrativo(Integer.parseInt(code.getText().toString())) && verificarDatos(user, password)) {
                user.setText("");
                password.setText("");
                if (checkBox.isChecked()) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(KEY_REMEMBER, true);
                    editor.putBoolean(KEY_IS_ADMINISTRATIVE, false);
                    editor.apply();
                    Toast.makeText(this, "SharePreferences is ok", Toast.LENGTH_SHORT).show();
                }
                intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
            } else if (esAdministrativo(Integer.parseInt(code.getText().toString())) && verificarDatos(user, password)) {
                user.setText("");
                password.setText("");
                if (checkBox.isChecked()) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(KEY_REMEMBER, true);
                    editor.putBoolean(KEY_IS_ADMINISTRATIVE, true);
                    editor.apply();
                    Toast.makeText(this, "SharePreferences is ok", Toast.LENGTH_SHORT).show();
                }
                intent = new Intent(this, MenuCaseActivity.class);
                startActivity(intent);
            } else {
                user.setText("");
                password.setText("");
                Toast.makeText(this, "¡Datos Erroneos!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean verificarDatos(EditText usuario, EditText contraseña) {
        if (usuario3 != null && contraseña2 != null) {
            return (usuario1.equals(String.valueOf(usuario.getText())) && contraseña1.equals(String.valueOf(contraseña.getText()))) ||
                    (usuario2.equals(String.valueOf(usuario.getText())) && contraseña1.equals(String.valueOf(contraseña.getText()))) ||
                    (usuario3.equals(String.valueOf(usuario.getText())) && contraseña2.equals(String.valueOf(contraseña.getText())));
                //TODO verificar con codigo upb
        } else {
            return (usuario1.equals(String.valueOf(usuario.getText())) && contraseña1.equals(String.valueOf(contraseña.getText()))) ||
                    (usuario2.equals(String.valueOf(usuario.getText())) && contraseña1.equals(String.valueOf(contraseña.getText())));
        }
    }

    public boolean esAdministrativo(int codeUPB) {
        Usuario user = dbController.selectUser(codeUPB);
        return user.isAdministrator();
    }
}
