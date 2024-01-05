
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;

//@Entity
public class Vendedor implements Serializable {

/*@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idVendedor;
    @OneToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "vend")
    private List <DetallesVenta> detallesVeta;
    private int Estado;

    public Vendedor() {
    }

    public Vendedor(int idVendedor, Usuario usuario, List<DetallesVenta> detallesVeta, int Estado) {
        this.idVendedor = idVendedor;
        this.usuario = usuario;
        this.detallesVeta = detallesVeta;
        this.Estado = Estado;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetallesVenta> getDetallesVeta() {
        return detallesVeta;
    }

    public void setDetallesVeta(List<DetallesVenta> detallesVeta) {
        this.detallesVeta = detallesVeta;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

   */
    
}
