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
@XmlRootElement(name = "Casas")
public class ListaCasas {
    @XmlElement(name = "Casa", type = Casa.class)
    private List<Casa> casas;

    public ListaCasas() {
        this.casas = new ArrayList();
    }

    public ListaCasas(List<Casa> casas) {
        this.casas = casas;
    }
    
    /**
     * @return the clientes
     */
    public List<Casa> getCasas() {
        return casas;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setCasas(List<Casa> casas) {
        this.casas = casas;
    }
    
}
