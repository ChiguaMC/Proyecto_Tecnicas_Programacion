package Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josué Moraga Campos
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Mantenimientos")
public class ListaMantenimientos {
    @XmlElement(name = "Mantenimientos", type = Mantenimiento.class)
    private List<Mantenimiento> mantenimientos;

    public ListaMantenimientos() {
        this.mantenimientos = new ArrayList();
    }

    public ListaMantenimientos(List<Mantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }
    
    /**
     * @return the mantenimientos
     */
    public List<Mantenimiento> getMantenimientos() {
        return mantenimientos;
    }

    /**
     * @param mantenimientos the mantenimientos to set
     */
    public void setMantenimientos(List<Mantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }
    
}
