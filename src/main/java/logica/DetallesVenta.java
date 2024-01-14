
package logica;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@Entity
public class DetallesVenta implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idDetallesVenta;
    private double precioUnitario;
    private int cantidad;
    private double subTotal;
    private double descuento;
    private double iva;
    private double totalPagar;
    private int estado;
    @ManyToOne
    @JoinColumn(name="idVendedor")
    private Vendedor vend;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
        name = "detalle_venta_producto",
        joinColumns = @JoinColumn(name = "idDetallesVenta"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> producto;

    public DetallesVenta() {
    }

    public DetallesVenta(int idDetallesVenta, double precioUnitario, int cantidad, double subTotal, double descuento, double iva, double totalPagar, int estado, Vendedor vend, List<Producto> producto) {
        this.idDetallesVenta = idDetallesVenta;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.iva = iva;
        this.totalPagar = totalPagar;
        this.estado = estado;
        this.vend = vend;
        this.producto = producto;
    }

    public int getIdDetallesVenta() {
        return idDetallesVenta;
    }

    public void setIdDetallesVenta(int idDetallesVenta) {
        this.idDetallesVenta = idDetallesVenta;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Vendedor getVend() {
        return vend;
    }

    public void setVend(Vendedor vend) {
        this.vend = vend;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }
    
    
            
}
