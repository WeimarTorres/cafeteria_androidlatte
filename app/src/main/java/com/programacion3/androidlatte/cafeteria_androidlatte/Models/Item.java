package com.programacion3.androidlatte.cafeteria_androidlatte.Models;

import java.io.Serializable;

public class Item implements Serializable{
    private String name;
    private int quantity;
    private int image;
    private int codeFood;
    private int price;

    public Item(int codeFood, String name, int quantity, int price, int image){
        this.codeFood = codeFood;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setCodeFood(int codeFood) {
        this.codeFood = codeFood;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() { return name; }

    public int getQuantity() {
        return quantity;
    }

    public int getImage() {
        return image;
    }

    public int getCodeFood() {
        return codeFood;
    }

    public int getPrice() {
        return price;
    }
}
