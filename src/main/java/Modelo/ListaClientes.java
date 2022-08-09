package Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josué Moraga Campos
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Clientes")
public class ListaClientes {
    @XmlElement(name = "Cliente", type = Cliente.class)
    private List<Cliente> clientes;

    public ListaClientes() {
        this.clientes = new ArrayList();
    }

    public ListaClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    /**
     * @return the clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}
