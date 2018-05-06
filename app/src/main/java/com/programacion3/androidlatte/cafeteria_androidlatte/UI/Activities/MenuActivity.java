package com.programacion3.androidlatte.cafeteria_androidlatte.UI.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Item;
import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Memoria;
import com.programacion3.androidlatte.cafeteria_androidlatte.R;

public class MenuActivity extends AppCompatActivity {

    private TextView texto1;
    private TextView texto2;
    private TextView texto3;
    private TextView texto4;
    private TextView texto5;
    private TextView texto6;
    private Typeface Real;

    private Memoria memoria;

    private static int ALMUERZO = 1;
    private static int DESAYUNO = 1;
    private static int MERIENDA = 1;
    private static int COMBOS = 1;
    private static int SNACKS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        memoria = new Memoria();
        memoria.setItemDisponible(new Item(1,"Hamburguesa", 50, R.drawable.hamburguesa, 15));
        memoria.setItemDisponible(new Item(2, "Soda", 100, R.drawable.soda, 5));

        String fuente = "fuentes/KG.ttf";
        this.Real = Typeface.createFromAsset(getAssets(), fuente);

        texto1 = (TextView) findViewById(R.id.menu);
        texto2 = (TextView) findViewById(R.id.desayuno);
        texto3 = (TextView) findViewById(R.id.merienda);
        texto4 = (TextView) findViewById(R.id.combos);
        texto5 = (TextView) findViewById(R.id.almuerzo);
        texto6 = (TextView) findViewById(R.id.snacks);
        texto1.setTypeface(Real);
        texto2.setTypeface(Real);
        texto3.setTypeface(Real);
        texto4.setTypeface(Real);
        texto5.setTypeface(Real);
        texto6.setTypeface(Real);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
    }

    public void click(View view) {
        Intent intent;
        if (view.getId() == R.id.almuerzo) {
            intent = new Intent(this, DisplayAlmuerzoActivity.class);
            intent.putExtra("memoria", memoria);
            // TODO alguito que agregar aqui...
            startActivityForResult(intent, ALMUERZO);
        } else if(view.getId() == R.id.desayuno){
            intent = new Intent(this, DisplayDesayunoActivity.class);
            intent.putExtra("memoria", memoria);
            // TODO alguito que agregar aqui...
            startActivityForResult(intent, DESAYUNO);
        } else if(view.getId() == R.id.merienda){
            intent = new Intent(this, DisplayMeriendaActivity.class);
            intent.putExtra("memoria", memoria);
            // TODO alguito que agregar aqui...
            startActivityForResult(intent, MERIENDA);
        } else if(view.getId() == R.id.combos){
            intent = new Intent(this, DisplayCombosActivity.class);
            intent.putExtra("memoria", memoria);
            // TODO alguito que agregar aqui...
            startActivityForResult(intent, COMBOS);
        } else if(view.getId() == R.id.snacks){
            intent = new Intent(this, DisplaySnacksActivity.class);
            intent.putExtra("memoria", memoria);
            // TODO alguito que agregar aqui...
            startActivityForResult(intent, SNACKS);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ALMUERZO) {
            memoria = (Memoria) data.getSerializableExtra("memoria");
        } else if (requestCode == DESAYUNO) {
            memoria = (Memoria) data.getSerializableExtra("memoria");
        } else if (requestCode == MERIENDA) {
            memoria = (Memoria) data.getSerializableExtra("memoria");
        } else if (requestCode == COMBOS) {
            memoria = (Memoria) data.getSerializableExtra("memoria");
        } else if (requestCode == SNACKS) {
            memoria = (Memoria) data.getSerializableExtra("memoria");
        }
    }


    public void onMenuClick(MenuItem item) {
        if (item.getItemId() == R.id.itemDialog) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("IMPORTANTE!!");
            builder.setMessage("Estas seguro que deseas salir?");
            builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                    startActivity(intent);
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
        } else if (item.getItemId() == R.id.itemReservas) {
            Intent intent = new Intent(this, ReservasActivity.class);
            intent.putExtra("memoria", memoria);
            startActivity(intent);
        }
    }
}
