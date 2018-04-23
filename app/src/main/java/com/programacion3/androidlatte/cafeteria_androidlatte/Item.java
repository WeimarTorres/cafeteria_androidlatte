package com.programacion3.androidlatte.cafeteria_androidlatte;

public class Item {
    private String descripcion;
    private int cant, img, id;
    private double precio;

    public Item( int id, String descripcion, int cant, int img, double precio ){
        this.id = id;
        this.descripcion = descripcion;
        this.cant = cant;
        this.img = img;
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getDescripcion() {

        return descripcion;
    }

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
