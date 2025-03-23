package org.uniquindio.edu.co.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Producto> productos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void realizarVenta(String idCliente, String codigoProducto, int cantidad) {
        Cliente cliente = clientes.stream().filter(c -> c.getIdentificacion().equals(idCliente)).findFirst().orElse(null);
        Producto producto = productos.stream().filter(p -> p.getCodigo().equals(codigoProducto)).findFirst().orElse(null);

        if (cliente == null) {
            System.out.println("Error: Cliente no encontrado.");
            return;
        }
        if (producto == null) {
            System.out.println("Error: Producto no encontrado.");
            return;
        }
        if (producto.getStock() < cantidad) {
            System.out.println("Error: Stock insuficiente para la venta.");
            return;
        }

        producto.reducirStock(cantidad);
        Venta venta = new Venta(LocalDate.now(), cliente, producto, cantidad);
        ventas.add(venta);

        System.out.println("Venta realizada con éxito.");
    }

    public String obtenerListaProductos() {
        if (productos.isEmpty()) return "No hay productos registrados.";
        StringBuilder sb = new StringBuilder("Productos en Inventario:\n");
        for (Producto p : productos) sb.append(p).append("\n");
        return sb.toString();
    }

    public String obtenerListaClientes() {
        if (clientes.isEmpty()) return "No hay clientes registrados.";
        StringBuilder sb = new StringBuilder("Clientes Registrados:\n");
        for (Cliente c : clientes) sb.append(c).append("\n");
        return sb.toString();
    }

    public String obtenerListaVentas() {
        if (ventas.isEmpty()) return "No hay ventas registradas.";
        StringBuilder sb = new StringBuilder("Ventas Realizadas:\n");
        for (Venta v : ventas) sb.append(v).append("\n");
        return sb.toString();
    }
}
