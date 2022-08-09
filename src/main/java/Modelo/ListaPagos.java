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
@XmlRootElement(name = "Pagos")
public class ListaPagos {
    @XmlElement(name = "Pago", type = Pago.class)
    private List<Pago> pagos;

    public ListaPagos() {
        this.pagos = new ArrayList();
    }

    public ListaPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
    
    /**
     * @return the pagos
     */
    public List<Pago> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
    
}
