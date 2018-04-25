package com.programacion3.androidlatte.cafeteria_androidlatte;

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

    public List<Item> getListaItemReservado() {
        return listaItemReservado;
    }

    public List<Item> getListaItemDisponible() {
        return listaItemDisponible;
    }

    public void setItemReserva(Item item) {
        listaItemReservado.add(numero(), item);
    }

    private int numero() {
        int i = numeroItemReservado;
        numeroItemReservado++;
        return i;
    }

}
