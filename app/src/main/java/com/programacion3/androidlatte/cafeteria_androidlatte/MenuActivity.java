package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void onMenuItemClick(MenuItem item) {   }

    public void click(View view){
       Intent intent = new Intent(this, DisplayActivity.class);
       // alguito que agregar aqui...
       startActivity(intent);
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
            }
        }
    }

}
