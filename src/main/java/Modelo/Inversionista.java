package Modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grupo Técnicas de Programación
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Inversionista")
public class Inversionista extends Usuario{

    public Inversionista(String idUsuario, String contrasena, Permisos permisos, String role) {
        super(idUsuario,contrasena, permisos, role);
    }
}
