package com.claucas90.e6m5;

public class DatosLista {
    private String url;
    private String dato;

    public DatosLista(String url, String dato) {
        this.url = url;
        this.dato = dato;
    }

    public String getUrl() {
        return url;
    }

    public String getDato() {
        return dato;
    }
}