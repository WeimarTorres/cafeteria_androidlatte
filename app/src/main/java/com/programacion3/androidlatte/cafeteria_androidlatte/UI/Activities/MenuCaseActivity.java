package com.programacion3.androidlatte.cafeteria_androidlatte.UI.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.programacion3.androidlatte.cafeteria_androidlatte.R;

public class MenuCaseActivity extends AppCompatActivity {

    private TextView texto1;
    private TextView texto2;
    private TextView texto3;
    private Typeface Real;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_case);

        String fuente = "font/KG.ttf";
        this.Real = Typeface.createFromAsset(getAssets(), fuente);

        texto1 = (TextView) findViewById(R.id.appName);
        texto2 = (TextView) findViewById(R.id.editar);
        texto3 = (TextView) findViewById(R.id.reservas);

        texto1.setTypeface(Real);
        texto2.setTypeface(Real);
        texto3.setTypeface(Real);
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
        if (view.getId() == R.id.editar) {
            intent = new Intent(this, EditarMenuDelDiaActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.reservas) {
            intent = new Intent(this, ReservasCaseActivity.class);
            startActivity(intent);
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
                    Intent intent = new Intent(MenuCaseActivity.this, LoginActivity.class);
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
            //TODO implementar DB
        }
    }

}
