package com.programacion3.androidlatte.cafeteria_androidlatte.UI.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Item;
import com.programacion3.androidlatte.cafeteria_androidlatte.UI.Adapters.ItemAdapter;
import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Memoria;
import com.programacion3.androidlatte.cafeteria_androidlatte.R;

import java.util.List;

public class DisplayCombosActivity extends AppCompatActivity {

    private ListView listView;
    private Memoria memoria;
    private List<Item> itemList;
    private static int SELECCION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_combos);

        listView = findViewById(R.id.lista2);

        Intent intent = getIntent();
        memoria = (Memoria)intent.getSerializableExtra("memoria");
        itemList = memoria.getListaItemDisponible();

        ItemAdapter itemAdapter = new ItemAdapter(this, itemList);
        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DisplayCombosActivity.this, SeleccionDeProductosActivity.class);
                intent.putExtra("memoria", memoria);
                Item item = (Item) adapterView.getItemAtPosition(i);
                intent.putExtra("itemSeleccionado", item);
                startActivityForResult(intent, SELECCION);
            }
        });

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