/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import logica.Producto;

/**
 *
 * @author 3714N
 */
public class controladoraPersistencia {
    //CabeceraVentaJpaController cabeceraJPA = new CabeceraVentaJpaController();
    //CategoriaJpaController categoriaJPA = new CategoriaJpaController();
    //ClienteJpaController clienteJPA = new ClienteJpaController();
    //DetallesVentaJpaController detalleVJPA = new DetallesVentaJpaController();
    ProductoJpaController productoJPA = new ProductoJpaController();
   // UsuarioJpaController usuarioJPA = new UsuarioJpaController();
   // VendedorJpaController vendedorJPA = new VendedorJpaController();

    public void crearProducto(Producto produt) {
        productoJPA.create(produt);
    }
            
}
