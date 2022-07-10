package Modelo;

import java.util.Date;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class ContratoAlquiler extends Contrato{
    private double costoMantenimiento;

    public ContratoAlquiler(String idContrato, double monto, Date fechaContrato, Propiedad propiedad, Inversionista dueno, Cliente cliente, double costoMantenimiento) {
        super(idContrato, monto, fechaContrato, propiedad, dueno, cliente);
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
