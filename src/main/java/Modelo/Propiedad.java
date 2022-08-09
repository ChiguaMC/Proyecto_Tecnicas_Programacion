package Modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grupo Técnicas de Programación
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Propiedad")
public class Propiedad {
    private int numeroFinca;
    private double areaDelTerreno;
    private double valorFiscal;
    private String provincia;
    private String canton;
    private String distrito;
    private String direccion;
    private String estadoPropiedad;

    public Propiedad() {
    }

    
    public Propiedad(int numeroFinca, double areaDelTerreno, double valorFiscal, String provincia, String canton, String distrito, String direccion, String estadoPropiedad) {
        this.numeroFinca = numeroFinca;
        this.areaDelTerreno = areaDelTerreno;
        this.valorFiscal = valorFiscal;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccion = direccion;
        this.estadoPropiedad = estadoPropiedad;
    }

    /**
     * @return the numeroFinca
     */
    public int getNumeroFinca() {
        return numeroFinca;
    }

    /**
     * @param numeroFinca the numeroFinca to set
     */
    public void setNumeroFinca(int numeroFinca) {
        this.numeroFinca = numeroFinca;
    }

    /**
     * @return the areaDelTerreno
     */
    public double getAreaDelTerreno() {
        return areaDelTerreno;
    }

    /**
     * @param areaDelTerreno the areaDelTerreno to set
     */
    public void setAreaDelTerreno(double areaDelTerreno) {
        this.areaDelTerreno = areaDelTerreno;
    }

    /**
     * @return the valorFiscal
     */
    public double getValorFiscal() {
        return valorFiscal;
    }

    /**
     * @param valorFiscal the valorFiscal to set
     */
    public void setValorFiscal(double valorFiscal) {
        this.valorFiscal = valorFiscal;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the canton
     */
    public String getCanton() {
        return canton;
    }

    /**
     * @param canton the canton to set
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }

    /**
     * @return the distrito
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * @param distrito the distrito to set
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the estadoPropiedad
     */
    public String getEstadoPropiedad() {
        return estadoPropiedad;
    }

    /**
     * @param estadoPropiedad the estadoPropiedad to set
     */
    public void setEstadoPropiedad(String estadoPropiedad) {
        this.estadoPropiedad = estadoPropiedad;
    }

    @Override
    public String toString() {
        return "Propiedad{" + "numeroFinca=" + numeroFinca + ", areaDelTerreno=" + areaDelTerreno + ", valorFiscal=" + valorFiscal + ", provincia=" + provincia + ", canton=" + canton + ", distrito=" + distrito + ", direccion=" + direccion + ", estadoPropiedad=" + estadoPropiedad + '}';
    }
}
