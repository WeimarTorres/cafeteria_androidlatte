package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    ListView listView;

    List<Item> itemList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        listView = findViewById(R.id.lista1);

        //algo con que llenar la lista va aqui, por ahora solo es lo mismo
        for(int i = 0; i<10; i++) {
            itemList.add(new Item(i, "Comida", 20-i, R.drawable.hamburguesa, 0.99));
        }

        ItemAdapter itemAdapter = new ItemAdapter(this, itemList);
        listView.setAdapter(itemAdapter);
    }
}
