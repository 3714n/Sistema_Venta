/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import Persistencia.controladoraPersistencia;

/**
 *
 * @author 3714N
 */
public class controladoraLogica {
    controladoraPersistencia controPerJPA = new controladoraPersistencia();

    
 public void crearProducto(String nombre, int cantidad, double precio, String descripcion) {
    try {
        Producto product = new Producto();
        product.setNombre(nombre);
        product.setPrecio(precio);
        product.setCantidad(cantidad);
        product.setDescripcion(descripcion);

        controPerJPA.crearProducto(product);
    } catch (Exception e) {
        // Manejo de la excepción, log, etc.
        e.printStackTrace();
        // Puedes lanzar una excepción personalizada si es necesario.
    }
}
}
