package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class ReservasActivity extends AppCompatActivity {

    ListView listView;
    List<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);

        listView = findViewById(R.id.ListView);

        Intent intent = getIntent();
        Memoria memoria = (Memoria) intent.getSerializableExtra("Memoria");
        this.list = memoria.getListaItemReservado();

        ItemAdapter itemAdapter = new ItemAdapter(this, list);
        listView.setAdapter(itemAdapter);

    }
}
