
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

//@Entity
public class Cliente implements Serializable {
   /* @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idCliente;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String telefono;
    private String correo;
    @OneToMany(mappedBy = "cabecera")
    private List<CabeceraVenta> cabeceraVenta;
    private int Estado;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String apellidos, String cedula, String telefono, String correo, List<CabeceraVenta> cabeceraVenta, int Estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.cabeceraVenta = cabeceraVenta;
        this.Estado = Estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<CabeceraVenta> getCabeceraVenta() {
        return cabeceraVenta;
    }

    public void setCabeceraVenta(List<CabeceraVenta> cabeceraVenta) {
        this.cabeceraVenta = cabeceraVenta;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }*/
    
}
