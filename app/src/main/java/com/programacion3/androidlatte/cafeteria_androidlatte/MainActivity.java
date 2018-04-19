package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textNuevo = findViewById(R.id.nuevo);
        textNuevo.setPaintFlags(textNuevo.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }
}
