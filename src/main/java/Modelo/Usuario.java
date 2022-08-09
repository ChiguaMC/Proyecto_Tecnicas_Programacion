package Modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grupo Técnicas de Programación
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Usuario")
public class Usuario {

    private String idUsuario;
    private String contrasena;
    private Permisos permisos;
    private String role;

    public Usuario() {
    }

    
    public Usuario(String idUsuario, String contrasena, Permisos permisos, String role) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.permisos = permisos;
        this.role = role;
    }

    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the permisos
     */
    public Permisos getPermisos() {
        return permisos;
    }

    /**
     * @param permisos the permisos to set
     */
    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
}
