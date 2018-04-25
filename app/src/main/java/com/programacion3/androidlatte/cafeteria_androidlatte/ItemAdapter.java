package com.programacion3.androidlatte.cafeteria_androidlatte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.programacion3.androidlatte.cafeteria_androidlatte.Item;

import java.util.LinkedList;
import java.util.List;

public class ItemAdapter extends BaseAdapter{

    Context context;
    List<Item> itemList = new LinkedList<>();
    LayoutInflater inflater;

    ItemAdapter(Context context, List<Item> itemList){
        this.context = context;
        this.itemList = itemList;
        inflater = LayoutInflater.from(context);
    }

    public int getCount(){
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.layout_list_item, null);

        TextView textView = convertView.findViewById(R.id.nombreItem);
        textView.setText(itemList.get(i).getId());

        TextView textView1 = convertView.findViewById(R.id.precio);
        String precio = Double.toString(itemList.get(i).getPrecio());
        textView.setText(precio);

        ImageView imageView = convertView.findViewById(R.id.img);
        imageView.setImageResource(itemList.get(i).getImg());

        ProgressBar progressBar = convertView.findViewById(R.id.cantidad);
        progressBar.setProgress(itemList.get(i).getCant());

        return convertView;
    }


}