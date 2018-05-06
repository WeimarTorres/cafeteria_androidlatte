package com.programacion3.androidlatte.cafeteria_androidlatte.Models;

import java.io.Serializable;

public class Usuario implements Serializable {

    //@Expose
    private String username;
    //@Expose
    private int codigo;
    //@Expose
    private String password;
    //@Expose
    private boolean isAdministrator;

    public Usuario(String username, int codigo, String password, int isAdministrator) {
        this.username = username;
        this.codigo = codigo;
        this.password = password;
        if (isAdministrator == 1) {
            this.isAdministrator = true;
        } else {

            this.isAdministrator = false;
        }
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public String getUsername() {
        return username;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getPassword() {
        return password;
    }

}
