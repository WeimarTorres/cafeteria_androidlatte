package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    private ListView listView;
    private Memoria memoria;
    private List<Item> itemList = new LinkedList<>();
    private static int SELECCION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        listView = findViewById(R.id.lista1);

        Intent intent = getIntent();
        memoria = (Memoria)intent.getSerializableExtra("memoria");

        //algo con que llenar la lista va aqui, por ahora solo es lo mismo
        for(int i = 0; i<10; i++) {
            itemList.add(new Item(1, "Comida", 20-i, R.drawable.hamburguesa, 0.99));
        }

        ItemAdapter itemAdapter = new ItemAdapter(this, itemList);
        listView.setAdapter(itemAdapter);
    }

    public void click1(View view){
        Intent intent = new Intent(this, SeleccionDeProductosActivity.class);
        intent.putExtra("memoria", memoria);
        startActivityForResult(intent, SELECCION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECCION) {
            memoria = (Memoria) data.getSerializableExtra("memoria");
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
