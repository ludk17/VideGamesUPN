package com.example.vj20231.Clases;

public class Anime {
    String nombre;
    String descripcion;
    String imagen;
    Boolean fav;

    public Anime(String nombre, String descripcion, String imagen, Boolean fav) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fav = fav;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getFav() {
        return fav;
    }

    public void setFav(Boolean fav) {
        this.fav = fav;
    }
}
