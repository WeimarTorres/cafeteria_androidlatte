package com.programacion3.androidlatte.cafeteria_androidlatte.Models;

import java.nio.charset.CharsetEncoder;

/**
 * Created by WEIMAR on 08/05/2018.
 */

public class ItemReservas {

    private String username;
    private int codeUPB;
    private int codeFood;
    private String name;
    private int price;
    private int image;
    private String time;

    public ItemReservas(String username, int codeUPB, int codeFood, String name, int price, int image, String time) {
        this.username = username;
        this.codeUPB = codeUPB;
        this.codeFood = codeFood;
        this.name = name;
        this.price = price;
        this.image = image;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCodeUPB() {
        return codeUPB;
    }

    public void setCodeUPB(int codeUPB) {
        this.codeUPB = codeUPB;
    }

    public int getCodeFood() {
        return codeFood;
    }

    public void setCodeFood(int codeFood) {
        this.codeFood = codeFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
