package Modelo;

import java.util.Arrays;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class Modelo {

    private Lista<Inversionista> inversionistas;
    private Lista<Secretaría> secretaría;
    private Lista<Cliente> clientes;
    private Lista<Propiedad> propiedades;
    private Lista<Pago> pagos;
    private Lista<Mantenimiento> mantenimientos;
    private Lista<Contrato> contratos;

    public Modelo() {
        this.inversionistas = new Lista();
        this.secretaría = new Lista();
        this.clientes = new Lista();
        this.propiedades = new Lista();
        this.pagos = new Lista();
        this.mantenimientos = new Lista();
        this.contratos = new Lista();
    }

    /**
     * @return the inversionistas
     */
    public Lista<Inversionista> getInversionistas() {
        return inversionistas;
    }

    /**
     * @param inversionistas the inversionistas to set
     */
    public void setInversionistas(Lista<Inversionista> inversionistas) {
        this.inversionistas = inversionistas;
    }

    /**
     * @return the secretaría
     */
    public Lista<Secretaría> getSecretaría() {
        return secretaría;
    }

    /**
     * @param secretaría the secretaría to set
     */
    public void setSecretaría(Lista<Secretaría> secretaría) {
        this.secretaría = secretaría;
    }

    /**
     * @return the clientes
     */
    public Lista<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(Lista<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the propiedades
     */
    public Lista<Propiedad> getPropiedades() {
        return propiedades;
    }

    /**
     * @param propiedades the propiedades to set
     */
    public void setPropiedades(Lista<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    /**
     * @return the pagos
     */
    public Lista<Pago> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(Lista<Pago> pagos) {
        this.pagos = pagos;
    }

    /**
     * @return the mantenimientos
     */
    public Lista<Mantenimiento> getMantenimientos() {
        return mantenimientos;
    }

    /**
     * @param mantenimientos the mantenimientos to set
     */
    public void setMantenimientos(Lista<Mantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    /**
     * @return the contratos
     */
    public Lista<Contrato> getContratos() {
        return contratos;
    }

    /**
     * @param contratos the contratos to set
     */
    public void setContratos(Lista<Contrato> contratos) {
        this.contratos = contratos;
    }

    public String confirmarLogin(String nombreUsuario, char[] contrasena) {
        for (Object objeto : this.inversionistas.getLista()) {
            Inversionista inversionista = (Inversionista) objeto;

            if (inversionista.getIdUsuario().equals(nombreUsuario)) {
                if (Arrays.equals(inversionista.getContrasena().toCharArray(),contrasena)) {
                    return "Correcto";
                } else {
                    return "Contraseña incorrecta";
                }
            }
        }
        return "Usuario no existe";
    }
}
