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
@XmlRootElement(name = "Contratos")
public class ListaContratos {
    @XmlElement(name = "Contrato", type = Contrato.class)
    private List<Contrato> contratos;

    public ListaContratos() {
        this.contratos = new ArrayList();
    }

    public ListaContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }
    
    /**
     * @return the contratos
     */
    public List<Contrato> getContratos() {
        return contratos;
    }

    /**
     * @param contratos the contratos to set
     */
    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }
    
}
