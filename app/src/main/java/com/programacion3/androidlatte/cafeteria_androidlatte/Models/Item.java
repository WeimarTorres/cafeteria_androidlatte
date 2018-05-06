package com.programacion3.androidlatte.cafeteria_androidlatte.Models;

import java.io.Serializable;

public class Item implements Serializable{
    private String nombre;
    private int cant, img, id;
    private double precio;

    public Item( int id, String nombre, int cant, int img, double precio ){
        this.id = id;
        this.nombre = nombre;
        this.cant = cant;
        this.img = img;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() { return nombre; }

    public int getCant() {
        return cant;
    }

    public int getImg() {
        return img;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }
}
