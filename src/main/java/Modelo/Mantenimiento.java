package Modelo;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class Mantenimiento {
    private String tipoMantenimieinto;
    private String magnitudMantenimiento;
    private double inversionRealizada;
    private ContratoAlquiler contratoAlquiler;

    public Mantenimiento(String tipoMantenimieinto, String magnitudMantenimiento, double inversionRealizada, ContratoAlquiler contratoAlquiler) {
        this.tipoMantenimieinto = tipoMantenimieinto;
        this.magnitudMantenimiento = magnitudMantenimiento;
        this.inversionRealizada = inversionRealizada;
        this.contratoAlquiler = contratoAlquiler;
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
}
