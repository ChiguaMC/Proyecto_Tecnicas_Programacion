package Modelo;

/**
 *
 * @author Josué Moraga Campos
 */
public class Permisos {
    private boolean leer;
    private boolean agregar;
    private boolean borrar;

    public Permisos() {
    }

    
    public Permisos(boolean leer, boolean agregar, boolean borrar) {
        this.leer = leer;
        this.agregar = agregar;
        this.borrar = borrar;
    }

    /**
     * @return the leer
     */
    public boolean isLeer() {
        return leer;
    }

    /**
     * @param leer the leer to set
     */
    public void setLeer(boolean leer) {
        this.leer = leer;
    }

    /**
     * @return the agregar
     */
    public boolean isAgregar() {
        return agregar;
    }

    /**
     * @param agregar the agregar to set
     */
    public void setAgregar(boolean agregar) {
        this.agregar = agregar;
    }

    /**
     * @return the borrar
     */
    public boolean isBorrar() {
        return borrar;
    }

    /**
     * @param borrar the borrar to set
     */
    public void setBorrar(boolean borrar) {
        this.borrar = borrar;
    }
}
