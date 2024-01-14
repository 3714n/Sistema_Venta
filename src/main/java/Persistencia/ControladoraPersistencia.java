/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Categoria;
import logica.Producto;

/**
 *
 * @author 3714N
 */
public class ControladoraPersistencia {
    CabeceraVentaJpaController cabeJPA = new CabeceraVentaJpaController();
    CategoriaJpaController cateJPA = new CategoriaJpaController();
    ClienteJpaController clienJPA = new ClienteJpaController();
    DetallesVentaJpaController detaJPA = new DetallesVentaJpaController();
    ProductoJpaController prodJPA = new ProductoJpaController();
    UsuarioJpaController usuaJPA = new UsuarioJpaController();
    VendedorJpaController vendJPA = new VendedorJpaController();

    public void crearProducto(Producto produ) {
        prodJPA.create(produ);
    }

    public void editarProducto(Producto produ) {
        try {
            prodJPA.edit(produ);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearCategoria( Categoria categ) {
     cateJPA.create(categ);
    }
    
    
}

