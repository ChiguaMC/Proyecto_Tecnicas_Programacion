package Modelo;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class Mantenimiento {
    private String tipoMantenimieinto;
    private String magnitudMantenimiento;
    private ContratoAlquiler contratoAlquiler;

    public Mantenimiento(String tipoMantenimieinto, String magnitudMantenimiento, ContratoAlquiler contratoAlquiler) {
        this.tipoMantenimieinto = tipoMantenimieinto;
        this.magnitudMantenimiento = magnitudMantenimiento;
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
}
