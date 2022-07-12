package Modelo;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class Usuario {

    private String idUsuario;
    private String contrasena;
    private Permisos permisos;

    public Usuario(String idUsuario, String contrasena, Permisos permisos) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.permisos = permisos;
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
}
