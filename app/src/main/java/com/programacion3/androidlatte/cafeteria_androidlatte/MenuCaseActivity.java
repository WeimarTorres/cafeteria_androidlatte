package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MenuCaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_case);
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
        } else if(view.getId() == R.id.reservas) {
            intent = new Intent(this, ReservasCaseActivity.class);
            startActivity(intent);
        }
    }

    public void onMenuClick(MenuItem item){
        switch (item.getItemId()) {
            case R.id.itemDialog: {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("IMPORTANTE!!");
                builder.setMessage("Estas seguro que deseas salir?");
                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
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

                break;
            } case R.id.itemReservas: {
                //TODO memoria
                break;
            }
        }
    }

}
