
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;
    private double porcentajeIva;
    @ManyToOne
    @JoinColumn(name="Producto_Id")
    private Categoria prod;
    @ManyToMany(mappedBy = "productos")
    private List<DetallesVenta> detallesVentas;
    private int estado;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, int cantidad, double precio, String descripcion, double porcentajeIva, Categoria prod, List<DetallesVenta> detallesVentas, int estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.porcentajeIva = porcentajeIva;
        this.prod = prod;
        this.detallesVentas = detallesVentas;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public Categoria getProd() {
        return prod;
    }

    public void setProd(Categoria prod) {
        this.prod = prod;
    }

    public List<DetallesVenta> getDetallesVentas() {
        return detallesVentas;
    }

    public void setDetallesVentas(List<DetallesVenta> detallesVentas) {
        this.detallesVentas = detallesVentas;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
   
}
