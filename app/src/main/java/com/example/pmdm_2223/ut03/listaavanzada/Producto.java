package com.example.pmdm_2223.ut03.listaavanzada;

import java.util.ArrayList;

public class Producto {
    private int precio;
    private String nombre;

    public Producto(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
    * */
    public static ArrayList<Producto> generador(){
        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(new Producto("Lechuga",20));
        productos.add(new Producto("Tomate",25));
        productos.add(new Producto("Cebolla",23));
        productos.add(new Producto("Pepinillo",18));
        productos.add(new Producto("Filete Pollo",150));
        productos.add(new Producto("Filete Ternera",210));
        productos.add(new Producto("Filete Lomo",190));
        return productos;
    }
}
