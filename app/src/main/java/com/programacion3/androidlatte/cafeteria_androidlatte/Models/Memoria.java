package com.programacion3.androidlatte.cafeteria_androidlatte.Models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WEIMAR on 24/04/2018.
 */

public class Memoria implements Serializable {

    private List<Item> listaItemReservado = new LinkedList<Item>();
    private List<Item> listaItemDisponible = new LinkedList<Item>();
    private int numeroItemReservado = 0;
    private int numeroItemDisponible = 0;

    public List<Item> getListaItemReservado() {
        return listaItemReservado;
    }

    public List<Item> getListaItemDisponible() {
        return listaItemDisponible;
    }

    public void setItemReserva(Item item) {
        listaItemReservado.add(numeroReservado(), item);
    }

    public void setItemDisponible(Item item) {
        listaItemDisponible.add(numeroDisponible(), item);
    }

    private int numeroReservado() {
        int i = numeroItemReservado;
        numeroItemReservado++;
        return i;
    }

    private int numeroDisponible() {
        int i = numeroItemDisponible;
        numeroItemDisponible++;
        return i;
    }

}
