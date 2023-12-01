package com.example.listasfragments;

public class Item {
    private String name;
    private String details;

    public Item(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return name; // Devuelve el nombre del elemento para mostrar en la lista
    }
}