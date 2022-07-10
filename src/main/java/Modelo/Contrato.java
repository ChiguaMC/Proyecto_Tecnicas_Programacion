package Modelo;

import java.util.Date;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class Contrato {
    private String idContrato;
    private double monto;
    private Date fechaContrato;
    private Propiedad propiedad;
    private Inversionista dueno;
    private Cliente cliente;

    public Contrato(String idContrato, double monto, Date fechaContrato, Propiedad propiedad, Inversionista dueno, Cliente cliente) {
        this.idContrato = idContrato;
        this.monto = monto;
        this.fechaContrato = fechaContrato;
        this.propiedad = propiedad;
        this.dueno = dueno;
        this.cliente = cliente;
    }

    /**
     * @return the idContrato
     */
    public String getIdContrato() {
        return idContrato;
    }

    /**
     * @param idContrato the idContrato to set
     */
    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the fechaContrato
     */
    public Date getFechaContrato() {
        return fechaContrato;
    }

    /**
     * @param fechaContrato the fechaContrato to set
     */
    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    /**
     * @return the propiedad
     */
    public Propiedad getPropiedad() {
        return propiedad;
    }

    /**
     * @param propiedad the propiedad to set
     */
    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    /**
     * @return the dueno
     */
    public Inversionista getDueno() {
        return dueno;
    }

    /**
     * @param dueno the dueno to set
     */
    public void setDueno(Inversionista dueno) {
        this.dueno = dueno;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
