package com.programacion3.androidlatte.cafeteria_androidlatte;

import java.io.Serializable;

public class Usuario implements Serializable {

    //@Expose
    private String username;
    //@Expose
    private int codigo;
    //@Expose
    private String password;

    public Usuario (String username, int codigo, String password) {
        this.username = username;
        this.codigo = codigo;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
