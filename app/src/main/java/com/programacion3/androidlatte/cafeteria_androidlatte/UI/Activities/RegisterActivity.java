package com.programacion3.androidlatte.cafeteria_androidlatte.UI.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.programacion3.androidlatte.cafeteria_androidlatte.Controller.DBController;
import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Usuario;
import com.programacion3.androidlatte.cafeteria_androidlatte.R;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText user;
    private EditText code;
    private EditText password;
    private Button button;
    private DBController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView text1;
        TextView text2;
        Typeface real;

        String font = "font/KG.ttf";
        real = Typeface.createFromAsset(getAssets(), font);

        text1 = (TextView) findViewById(R.id.buttonRegister);
        text2 = (TextView) findViewById(R.id.appName);
        text1.setTypeface(real);
        text2.setTypeface(real);

        user = findViewById(R.id.userRegister);
        code = findViewById(R.id.codeRegister);
        password = findViewById(R.id.passwordRegister);
        button = findViewById(R.id.buttonRegister);

        dbController = new DBController(this, "DBCafeteria.db", null, 1);
    }

    public void click(View view) {
        Intent intent;
        if (view.getId() == button.getId()) {
            if (!user.getText().toString().equals("") && !code.getText().toString().equals("") && !password.getText().toString().equals("")) {
                if (isVerified(Integer.parseInt(code.getText().toString()))) {
                    intent = new Intent(this, LoginActivity.class);
                    dbController.insertUsuario(user.getText().toString(),
                            Integer.parseInt(code.getText().toString()), password.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "El código UPB ya esta en uso", Toast.LENGTH_SHORT).show();
                    code.setText("");
                }
            } else {
                Toast.makeText(this, "Introdusca sus datos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isVerified(int codeUPB) {
        List<Usuario> codeList = dbController.selectAllUsers();
        boolean verified = true;
        for (Usuario user: codeList) {
            if (user.getCodigo() == codeUPB){
                verified = false;
            }
        }
        return verified;
    }

}
