package com.programacion3.androidlatte.cafeteria_androidlatte.UI.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Item;
import com.programacion3.androidlatte.cafeteria_androidlatte.Models.Memoria;
import com.programacion3.androidlatte.cafeteria_androidlatte.R;
import com.programacion3.androidlatte.cafeteria_androidlatte.UI.Adapters.ItemAdapter;

import java.util.List;

public class ReservasActivity extends AppCompatActivity {

    private ListView listView;
    private List<Item> list;
    private Memoria memoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);

        listView = findViewById(R.id.ListView);

        Intent intent = getIntent();
        memoria = (Memoria) intent.getSerializableExtra("memoria");
        this.list = memoria.getListaItemReservado();

        ItemAdapter itemAdapter = new ItemAdapter(this, list);
        listView.setAdapter(itemAdapter);

    }

    public void click(View view) {

    }

}
