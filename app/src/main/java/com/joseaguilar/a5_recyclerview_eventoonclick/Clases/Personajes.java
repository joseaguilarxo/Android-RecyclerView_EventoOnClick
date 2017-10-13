package com.joseaguilar.a5_recyclerview_eventoonclick.Clases;

/**
 * Created by josea on 08/10/2017.
 */

public class Personajes {
    private String nombre;
    private String info;
    private int foto;


    public Personajes() {
    }

    public Personajes(String nombre, String info, int foto) {
        this.nombre = nombre;
        this.info = info;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
