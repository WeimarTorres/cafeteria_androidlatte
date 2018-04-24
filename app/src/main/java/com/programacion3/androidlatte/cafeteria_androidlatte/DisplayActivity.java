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
    }
}
