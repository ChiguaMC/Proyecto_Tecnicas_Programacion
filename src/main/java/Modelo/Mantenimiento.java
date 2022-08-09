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
@XmlRootElement(name = "Mantenimiento")
public class Mantenimiento {
    private String tipoMantenimieinto;
    private String magnitudMantenimiento;
    private double inversionRealizada;
    private ContratoAlquiler contratoAlquiler;
    private Date fechaMantenimiento;
    private String responsable;

    public Mantenimiento() {
    }

    
    public Mantenimiento(String tipoMantenimieinto, String magnitudMantenimiento, double inversionRealizada, ContratoAlquiler contratoAlquiler, Date fechaMantenimiento, String responsable) {
        this.tipoMantenimieinto = tipoMantenimieinto;
        this.magnitudMantenimiento = magnitudMantenimiento;
        this.inversionRealizada = inversionRealizada;
        this.contratoAlquiler = contratoAlquiler;
        this.fechaMantenimiento = fechaMantenimiento;
        this.responsable = responsable;
        
    }

    /**
     * @return the tipoMantenimieinto
     */
    public String getTipoMantenimieinto() {
        return tipoMantenimieinto;
    }

    /**
     * @param tipoMantenimieinto the tipoMantenimieinto to set
     */
    public void setTipoMantenimieinto(String tipoMantenimieinto) {
        this.tipoMantenimieinto = tipoMantenimieinto;
    }

    /**
     * @return the magnitudMantenimiento
     */
    public String getMagnitudMantenimiento() {
        return magnitudMantenimiento;
    }

    /**
     * @param magnitudMantenimiento the magnitudMantenimiento to set
     */
    public void setMagnitudMantenimiento(String magnitudMantenimiento) {
        this.magnitudMantenimiento = magnitudMantenimiento;
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
     * @return the inversionRealizada
     */
    public double getInversionRealizada() {
        return inversionRealizada;
    }

    /**
     * @param inversionRealizada the inversionRealizada to set
     */
    public void setInversionRealizada(double inversionRealizada) {
        this.inversionRealizada = inversionRealizada;
    }

    /**
     * @return the fechaMantenimiento
     */
    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    /**
     * @param fechaMantenimiento the fechaMantenimiento to set
     */
    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    /**
     * @return the responsable
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
