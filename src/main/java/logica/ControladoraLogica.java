
package logica;

import Persistencia.ControladoraPersistencia;
import java.util.List;





public class ControladoraLogica {
 
    ControladoraPersistencia controPersis = new ControladoraPersistencia();
    
            public void crearProducto(String nombre, int cantidad, double precio, double costo, String descripcion, String imagen, Categoria listascategoria){
                Producto produ = new Producto();
                produ.setNombre(nombre);
                produ.setCantidad(cantidad);
                produ.setPrecio(precio);
                produ.setDescripcion(descripcion);
                produ.setCosto(costo);
                produ.setImagen(imagen);
                produ.setListascategoria((List<Categoria>) listascategoria);
                
                controPersis.crearProducto(produ);                
            }
        public void editarProducto(String nombre, int cantidad, double precio, double costo , String descripcion,  String imagen, List<Categoria> listascategoria){
                Producto produ = new Producto();
                produ.setNombre(nombre);
                produ.setCantidad(cantidad);
                produ.setPrecio(precio);
                produ.setDescripcion(descripcion);
                produ.setCosto(costo);
                produ.setImagen(imagen);
                produ.setListascategoria((List<Categoria>) listascategoria);
                
                controPersis.editarProducto(produ);                
            }

    public void crearCategoria(String nombreCategoria) {
        
        Categoria catego = new Categoria();
        catego.setDescripcion(nombreCategoria);
      
        
        controPersis.crearCategoria(catego);
        
    }
}
