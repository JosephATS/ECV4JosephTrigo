package com.joseph.ecv4josephtrigo.model;

public class Platos {

    private String titulo;
    private String nombre;
    private String url;

    public Platos(String titulo, String nombre, String url) {
        this.titulo = titulo;
        this.nombre = nombre;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
