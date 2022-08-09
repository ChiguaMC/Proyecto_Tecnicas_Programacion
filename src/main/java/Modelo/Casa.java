package Modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grupo Técnicas de Programación
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Casa")
public class Casa extends Propiedad{
    private int niveles;
    private String color;
    private int espacioParqueo;
    private int anoCostruccion;
    private String rutaFotografia;

    public Casa() {

    }    
    public Casa(int numeroFinca, double areaDelTerreno, double valorFiscal, String provincia, String canton, String distrito, String direccion, String estadoPropiedad, int niveles, String color, int espacioParqueo, int anoCostruccion, String rutaFotografia) {
        
        super(numeroFinca, areaDelTerreno, valorFiscal, provincia, canton, distrito, direccion, estadoPropiedad);
        this.niveles = niveles;
        this.color = color;
        this.espacioParqueo = espacioParqueo;
        this.anoCostruccion = anoCostruccion;
        this.rutaFotografia = rutaFotografia;
    }

    /**
     * @return the niveles
     */
    public int getNiveles() {
        return niveles;
    }

    /**
     * @param niveles the niveles to set
     */
    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the espacioParqueo
     */
    public int getEspacioParqueo() {
        return espacioParqueo;
    }

    /**
     * @param espacioParqueo the espacioParqueo to set
     */
    public void setEspacioParqueo(int espacioParqueo) {
        this.espacioParqueo = espacioParqueo;
    }

    /**
     * @return the anoCostruccion
     */
    public int getAnoCostruccion() {
        return anoCostruccion;
    }

    /**
     * @param anoCostruccion the anoCostruccion to set
     */
    public void setAnoCostruccion(int anoCostruccion) {
        this.anoCostruccion = anoCostruccion;
    }

    /**
     * @return the rutaFotografia
     */
    public String getRutaFotografia() {
        return rutaFotografia;
    }

    /**
     * @param rutaFotografia the rutaFotografia to set
     */
    public void setRutaFotografia(String rutaFotografia) {
        this.rutaFotografia = rutaFotografia;
    }
}