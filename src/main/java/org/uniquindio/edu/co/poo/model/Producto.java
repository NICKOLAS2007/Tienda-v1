package org.uniquindio.edu.co.poo.model;

public class Producto {
    private String nombre;
    private String codigo;
    private double precio;
    private String categoria;
    private int stock;

    public Producto(String nombre, String codigo, double precio, String categoria, int stock) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    public boolean reducirStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ") - $" + precio + " - Stock: " + stock;
    }
}
