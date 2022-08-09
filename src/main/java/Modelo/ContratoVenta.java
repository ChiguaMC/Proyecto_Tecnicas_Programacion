package Modelo;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grupo Técnicas de Programación
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ContratoVenta")
public class ContratoVenta extends Contrato{
    private double comision;

    public ContratoVenta() {

    }

    
    public ContratoVenta(String idContrato, double monto, Date fechaContrato, Propiedad propiedad, Cliente cliente, double comision) {
        super(idContrato, monto, fechaContrato, propiedad, cliente);
        this.comision = comision;
    }

    /**
     * @return the comision
     */
    public double getComision() {
        return comision;
    }

    /**
     * @param comision the comision to set
     */
    public void setComision(double comision) {
        this.comision = comision;
    }
}
