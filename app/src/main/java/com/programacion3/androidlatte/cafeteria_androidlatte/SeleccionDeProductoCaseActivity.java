package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SeleccionDeProductoCaseActivity extends AppCompatActivity {

    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_de_producto_case);

        imagen = findViewById(R.id.comida);
    }
}
