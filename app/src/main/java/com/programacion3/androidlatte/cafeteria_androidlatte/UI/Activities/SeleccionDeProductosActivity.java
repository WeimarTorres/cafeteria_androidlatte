package com.programacion3.androidlatte.cafeteria_androidlatte.UI.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Item;
import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Memoria;
import com.programacion3.androidlatte.cafeteria_androidlatte.R;

public class SeleccionDeProductosActivity extends AppCompatActivity {

    private TextView texto1;
    private TextView texto2;
    private TextView texto3;
    private TextView texto4;
    private TextView texto5;
    private Typeface Real;

    private Memoria memoria;
    private Item itemSeleccionado;
    private TextView nombre;
    private TextView precio;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_de_productos);

        Intent intent = getIntent();
        memoria = (Memoria) intent.getSerializableExtra("memoria");
        itemSeleccionado = (Item) intent.getSerializableExtra("itemSeleccionado");

        nombre = findViewById(R.id.nombreSeleccion);
        precio =findViewById(R.id.precioSeleccion);

        nombre.setText(itemSeleccionado.getNombre());
        precio.setText("Precio: " + String.valueOf(itemSeleccionado.getPrecio()));

        imageView = findViewById(R.id.imagen);
        imageView.setImageResource(itemSeleccionado.getImg());

        String font = "font/KG.ttf";
        this.Real = Typeface.createFromAsset(getAssets(), font);

        texto1 = (TextView) findViewById(R.id.nombreSeleccion);
        texto2 = (TextView) findViewById(R.id.precioSeleccion);
        texto3 = (TextView) findViewById(R.id.enviar);
        texto4 = (TextView) findViewById(R.id.descripcion);
        texto5 = (TextView) findViewById(R.id.ingredientes);
        texto1.setTypeface(Real);
        texto2.setTypeface(Real);
        texto3.setTypeface(Real);
        texto4.setTypeface(Real);
        texto5.setTypeface(Real);

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
                    memoria.setItemReserva(itemSeleccionado);
                    dialogInterface.dismiss();
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("memoria", memoria);
                    setResult(RESULT_OK, resultIntent);
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

    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("memoria", memoria);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
