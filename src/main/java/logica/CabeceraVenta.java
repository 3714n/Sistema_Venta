
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
@Entity
public class CabeceraVenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idCabeceraVenta;
    private double valorPagar;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToOne
    @JoinColumn(name="idCabeceraVenta")
    private Cliente cabecera;
    private int estado;

    public CabeceraVenta() {
    }

    public CabeceraVenta(int idCabeceraVenta, double valorPagar, Date fecha, Cliente cabecera, int estado) {
        this.idCabeceraVenta = idCabeceraVenta;
        this.valorPagar = valorPagar;
        this.fecha = fecha;
        this.cabecera = cabecera;
        this.estado = estado;
    }

    public int getIdCabeceraVenta() {
        return idCabeceraVenta;
    }

    public void setIdCabeceraVenta(int idCabeceraVenta) {
        this.idCabeceraVenta = idCabeceraVenta;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCabecera() {
        return cabecera;
    }

    public void setCabecera(Cliente cabecera) {
        this.cabecera = cabecera;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
