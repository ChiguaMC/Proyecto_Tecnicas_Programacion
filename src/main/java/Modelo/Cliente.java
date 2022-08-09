package Modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grupo Técnicas de Programación
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Cliente")
public class Cliente {
    private String idCliente;
    private String numeroTelefono;
    private String nombre;
    private String primerApellido;
    private String correoElectronico;
    private String estadoCivil;
    private String estadoCliente;

    public Cliente() {
    }

    public Cliente(String idCliente, String numeroTelefono, String nombre, String primerApellido, String correoElectronico, String estadoCivil, String estadoCliente) {
        this.idCliente = idCliente;
        this.numeroTelefono = numeroTelefono;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.correoElectronico = correoElectronico;
        this.estadoCivil = estadoCivil;
        this.estadoCliente = estadoCliente;
    }

    /**
     * @return the idCliente
     */
  
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the numeroTelefono
     */

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * @param numeroTelefono the numeroTelefono to set
     */
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * @return the nombre
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the primerApellido
     */

    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * @param primerApellido the primerApellido to set
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * @return the correoElectronico
     */

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the estadoCivil
     */

    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the estadoCliente
     */

    public String getEstadoCliente() {
        return estadoCliente;
    }

    /**
     * @param estadoCliente the estadoCliente to set
     */
    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", numeroTelefono=" + numeroTelefono + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", correoElectronico=" + correoElectronico + ", estadoCivil=" + estadoCivil + ", estadoCliente=" + estadoCliente + '}';
    }

}
