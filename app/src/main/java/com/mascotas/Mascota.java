package com.mascotas;

public class Mascota {
    private String nombre;
    private int foto;
    public int calificacion = 0;

    public static int count1 = 0;
    public static int count2 = 0;
    public static int count3 = 0;
    public static int count4 = 0;
    public static int count5 = 0;


    public Mascota(int foto,String nombre, int calificacion) {
        this.foto = foto;
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public int getFoto() {
        return foto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}