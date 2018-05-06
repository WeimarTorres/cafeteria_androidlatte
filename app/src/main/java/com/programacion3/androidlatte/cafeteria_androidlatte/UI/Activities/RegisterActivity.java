package com.programacion3.androidlatte.cafeteria_androidlatte.UI.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.programacion3.androidlatte.cafeteria_androidlatte.Controller.DBController;
import com.programacion3.androidlatte.cafeteria_androidlatte.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText user;
    private EditText code;
    private EditText password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView text1;
        TextView text2;
        Typeface real;

        String font = "font/KG.ttf";
        real = Typeface.createFromAsset(getAssets(), font);

        text1 = findViewById(R.id.buttonRegister);
        text2 = findViewById(R.id.appName);
        text1.setTypeface(real);
        text2.setTypeface(real);

        user = findViewById(R.id.userRegister);
        code = findViewById(R.id.codeRegister);
        password = findViewById(R.id.passwordRegister);
        button = findViewById(R.id.buttonRegister);
    }

    public void click(View view) {
        Intent intent;
        if (view.getId() == button.getId()) {
            if (user.getText() != null && password.getText() != null) {
                intent = new Intent(this, LoginActivity.class);
                intent.putExtra("Usuario", String.valueOf(user.getText()));
                intent.putExtra("password", String.valueOf(password.getText()));
                startActivity(intent);
            }
        }
    }

}
