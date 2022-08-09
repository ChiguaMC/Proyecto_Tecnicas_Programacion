package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class Modelo {

    //private Lista<Inversionista> inversionistas;
    //private Lista<Secretaría> secretaría;
    private Lista<Cliente> clientes;
    private Lista<Propiedad> propiedades;
    private Lista<Pago> pagos;
    private Lista<Mantenimiento> mantenimientos;
    private Lista<Contrato> contratos;
    private Lista<Usuario> usuarios;
    private Conector conector;

    public Modelo() {
        this.usuarios = new Lista();
        this.clientes = new Lista();
        this.propiedades = new Lista();
        this.pagos = new Lista();
        this.mantenimientos = new Lista();
        this.contratos = new Lista();
        this.conector = new Conector();
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

    /**
     * @return the usuarios
     */
    public Lista<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Lista<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String confirmarLogin(String nombreUsuario, char[] contrasena) {
        for (Object objeto : this.getUsuarios().getLista()) {
            Usuario usuario = (Usuario) objeto;

            if (usuario.getIdUsuario().equals(nombreUsuario)) {
                if (Arrays.equals(usuario.getContrasena().toCharArray(), contrasena)) {
                    return "Correcto";
                } else {
                    return "Contraseña incorrecta";
                }
            }
        }
        return "Usuario no existe";
    }

    public boolean existeNumeroFinca(int numeroFinca) {
        for (Object objeto : this.propiedades.getLista()) {
            Propiedad propiedad = (Propiedad) objeto;
            if (propiedad.getNumeroFinca() == numeroFinca) {
                return true;
            }
        }
        return false;
    }

    public boolean existeIDCliente(String idCliente) {
        for (Object objeto : this.clientes.getLista()) {
            Cliente cliente = (Cliente) objeto;
            if (cliente.getIdCliente().equals(idCliente)) {
                return true;
            }
        }
        return false;
    }

    public Propiedad retornarPropiedad(int numeroFinca) {
        for (Object objeto : propiedades.getLista()) {
            Propiedad propiedad = (Propiedad) objeto;
            if (propiedad.getNumeroFinca() == numeroFinca) {
                return propiedad;
            }
        }
        return null;
    }

    public Cliente retornarCliente(String identificadorCliente) {
        for (Object objeto : clientes.getLista()) {
            Cliente cliente = (Cliente) objeto;
            if (cliente.getIdCliente().equals(identificadorCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean cambiarEstadoPropiedad(int numeroFinca, String estado) {
        for (Object objeto : propiedades.getLista()) {
            Propiedad propiedad = (Propiedad) objeto;
            if (propiedad.getNumeroFinca() == numeroFinca) {
                propiedad.setEstadoPropiedad(estado);
                return true;
            }
        }
        return false;
    }

    public boolean cambiarEstadoCliente(String identificacionCliente, String estado) {
        for (Object objeto : clientes.getLista()) {
            Cliente cliente = (Cliente) objeto;
            if (cliente.getIdCliente().equals(identificacionCliente)) {
                cliente.setEstadoCliente(estado);
                return true;
            }
        }
        return false;
    }

    public Contrato retornarContrato(int numeroFinca) {
        for (Object objeto : contratos.getLista()) {
            Contrato contrato = (Contrato) objeto;
            if (contrato.getPropiedad().getNumeroFinca() == numeroFinca) {
                return contrato;
            }
        }
        return null;
    }
    
        public Contrato retornarContratoPorCodigo(String idContrato) {
        for (Object objeto : contratos.getLista()) {
            Contrato contrato = (Contrato) objeto;
            if (contrato.getIdContrato().equals(idContrato)) {
                return contrato;
            }
        }
        return null;
    }

    public ContratoAlquiler retornarPropiedadContrato(int numeroFinca) {
        for (Object objeto : this.contratos.getLista()) {
            if (objeto.getClass().getSimpleName().equals("ContratoAlquiler")) {
                ContratoAlquiler contratoAlquiler = (ContratoAlquiler) objeto;
                if (contratoAlquiler.getPropiedad().getNumeroFinca() == numeroFinca) {
                    return contratoAlquiler;
                }
            }
        }
        return null;
    }

    public boolean usuarioPuedeEscribir(String nombreUsuario) {
        for (Object objeto : getUsuarios().getLista()) {
            Usuario usuario = (Usuario) objeto;
            if (usuario.getIdUsuario().equals(nombreUsuario)) {
                return usuario.getPermisos().isAgregar();
            }
        }
        return false;
    }

    public boolean existeUsuario(String nombreUsuario) {
        for (Object objeto : getUsuarios().getLista()) {
            Usuario usuario = (Usuario) objeto;
            if (usuario.getIdUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the conector
     */
    public Conector getConector() {
        return conector;
    }

    /**
     * @param conector the conector to set
     */
    public void setConector(Conector conector) {
        this.conector = conector;
    }
    
    public List<ContratoAlquiler> retornarContratosAlquiler()
    {
        List<ContratoAlquiler> alquileres = new ArrayList();
        
        for(Object objeto: contratos.getLista())
        {
            if(objeto.getClass().getSimpleName().equals("ContratoAlquiler"))
            {
                ContratoAlquiler contratoAlquiler = (ContratoAlquiler)objeto;
                alquileres.add(contratoAlquiler);
            }
        }
        return alquileres;
    }
    public List<ContratoVenta> retornarContratosVenta()
    {
        List<ContratoVenta> ventas = new ArrayList();
        
        for(Object objeto: contratos.getLista())
        {
            if(objeto.getClass().getSimpleName().equals("ContratoVenta"))
            {
                ContratoVenta contratoVenta = (ContratoVenta)objeto;
                ventas.add(contratoVenta);
            }
        }
        return ventas;
    }
    
}
