package org.uniquindio.edu.co.poo.model;

public class Cliente {
    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;

    public Cliente(String nombre, String identificacion, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public String getIdentificacion() { return identificacion; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre + " (ID: " + identificacion + ")";
    }
}
