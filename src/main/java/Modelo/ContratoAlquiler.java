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
@XmlRootElement(name = "ContratoAlquiler")
public class ContratoAlquiler extends Contrato{
    private double costoMantenimiento;

    public ContratoAlquiler() {
    }

    public ContratoAlquiler(String idContrato, double monto, Date fechaContrato, Propiedad propiedad, Cliente cliente, double costoMantenimiento) {
        super(idContrato, monto, fechaContrato, propiedad, cliente);
        this.costoMantenimiento = costoMantenimiento;
    }

    /**
     * @return the costoMantenimiento
     */
    public double getCostoMantenimiento() {
        return costoMantenimiento;
    }

    /**
     * @param costoMantenimiento the costoMantenimiento to set
     */
    public void setCostoMantenimiento(double costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }
}
