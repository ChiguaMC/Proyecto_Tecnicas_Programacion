package Modelo;

import java.util.Date;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class Pago {
    private ContratoAlquiler contratoAlquiler;
    private String tipoPago;
    private Date fechaPago;
    private double montoPago;
    private String nombreUsuarioPago;

    public Pago(ContratoAlquiler contratoAlquiler, String tipoPago, Date fechaPago, double montoPago, String nombreUsuarioPago) {
        this.contratoAlquiler = contratoAlquiler;
        this.tipoPago = tipoPago;
        this.fechaPago = fechaPago;
        this.montoPago = montoPago;
        this.nombreUsuarioPago = nombreUsuarioPago;
    }

    /**
     * @return the contratoAlquiler
     */
    public ContratoAlquiler getContratoAlquiler() {
        return contratoAlquiler;
    }

    /**
     * @param contratoAlquiler the contratoAlquiler to set
     */
    public void setContratoAlquiler(ContratoAlquiler contratoAlquiler) {
        this.contratoAlquiler = contratoAlquiler;
    }

    /**
     * @return the tipoPago
     */
    public String getTipoPago() {
        return tipoPago;
    }

    /**
     * @param tipoPago the tipoPago to set
     */
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    /**
     * @return the fechaPago
     */
    public Date getFechaPago() {
        return fechaPago;
    }

    /**
     * @param fechaPago the fechaPago to set
     */
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * @return the montoPago
     */
    public double getMontoPago() {
        return montoPago;
    }

    /**
     * @param montoPago the montoPago to set
     */
    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    /**
     * @return the nombreUsuarioPago
     */
    public String getNombreUsuarioPago() {
        return nombreUsuarioPago;
    }

    /**
     * @param nombreUsuarioPago the nombreUsuarioPago to set
     */
    public void setNombreUsuarioPago(String nombreUsuarioPago) {
        this.nombreUsuarioPago = nombreUsuarioPago;
    }
}
