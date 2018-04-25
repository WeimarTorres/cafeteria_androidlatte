package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class SeleccionDeProductosActivity extends AppCompatActivity {

    private Memoria memoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_de_productos);

        Intent intent = getIntent();
        memoria = (Memoria) intent.getSerializableExtra("memoria");

    }

    public void click(View view) {
        if (view.getId() == R.id.enviar) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("IMPORTANTE!!");
            builder.setMessage("Estas seguro que quieres reservar el pedido?");
            builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //TODO hacer que se pase de displayActivity el item seleccionado
                    memoria.setItemReserva(new Item(11, "comida", 2, R.drawable.hamburguesa, 3.0));
                    dialogInterface.dismiss();
                    finish();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }

            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

}
