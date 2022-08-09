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
@XmlRootElement(name = "ContratoAlquilers")
public class ListaContratosAlquiler {
    @XmlElement(name = "ContratoAlquiler", type = ContratoAlquiler.class)
    private List<ContratoAlquiler> contratosAlquiler;

    public ListaContratosAlquiler() {
        this.contratosAlquiler = new ArrayList();
    }

    public ListaContratosAlquiler(List<ContratoAlquiler> contratosAlquiler) {
        this.contratosAlquiler = contratosAlquiler;
    }
    
    /**
     * @return the contratosAlquiler
     */
    public List<ContratoAlquiler> getContratoAlquilers() {
        return contratosAlquiler;
    }

    /**
     * @param contratosAlquiler the contratosAlquiler to set
     */
    public void setContratoAlquilers(List<ContratoAlquiler> contratosAlquiler) {
        this.contratosAlquiler = contratosAlquiler;
    }
    
}
