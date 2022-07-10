package Modelo;

import java.util.Date;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class ContratoVenta extends Contrato{
    private double comision;

    public ContratoVenta(String idContrato, double monto, Date fechaContrato, Propiedad propiedad, Inversionista dueno, Cliente cliente, double comision) {
        super(idContrato, monto, fechaContrato, propiedad, dueno, cliente);
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
