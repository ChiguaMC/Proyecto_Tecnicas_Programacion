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
@XmlRootElement(name = "ContratoVentas")
public class ListaContratosVenta {
    @XmlElement(name = "ContratoVenta", type = ContratoVenta.class)
    private List<ContratoVenta> contratosVenta;

    public ListaContratosVenta() {
        this.contratosVenta = new ArrayList();
    }

    public ListaContratosVenta(List<ContratoVenta> contratosVenta) {
        this.contratosVenta = contratosVenta;
    }
    
    /**
     * @return the contratosVenta
     */
    public List<ContratoVenta> getContratoVentas() {
        return contratosVenta;
    }

    /**
     * @param contratosVenta the contratosVenta to set
     */
    public void setContratoVentas(List<ContratoVenta> contratosVenta) {
        this.contratosVenta = contratosVenta;
    }
    
}
