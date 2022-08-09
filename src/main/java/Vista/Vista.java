package Vista;

import javax.swing.JOptionPane;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class Vista {
    public Login login;
    public MenuPrincipal menu;
    public VistaPropiedades propiedades;
    public VistaUsuarios usuarios;
    public VistaContratos contratos;
    public VistaPagos pagos;
    public VistaMantenimientos mantenimientos;
    public VistaClientes clientes;
    public VistaAgregarPropiedad agregarPropiedad;
    public VistaFileChooser fileChooser;
    public VistaAgregarCliente agregarCliente;
    public VistaAgregarContrato agregarContrato;
    public VistaAgregarMantenimiento agregarMantenimiento;
    public VistaAgregarPago agregarPagos;
    public VistaAgregarUsuario agregarUsuarios;
    public VistaContratoIndividual contratoIndividual;
    public VistaPropiedadIndividual propiedadIndividual;
    public VistaClienteIndividual clienteIndividual;
    
    public Vista() {
        this.login = new Login();
        this.menu = new MenuPrincipal();
        this.propiedades = new VistaPropiedades();
        this.usuarios = new VistaUsuarios();
        this.contratos= new VistaContratos();
        this.pagos= new VistaPagos();
        this.mantenimientos= new VistaMantenimientos();
        this.clientes = new VistaClientes();
        this.agregarPropiedad = new VistaAgregarPropiedad();
        this.fileChooser = new VistaFileChooser();
        this.agregarCliente = new VistaAgregarCliente();
        this.agregarContrato = new VistaAgregarContrato();
        this.agregarMantenimiento = new VistaAgregarMantenimiento();
        this.agregarPagos = new VistaAgregarPago();
        this.agregarUsuarios = new VistaAgregarUsuario();
        this.contratoIndividual = new VistaContratoIndividual();
        this.propiedadIndividual = new VistaPropiedadIndividual();
        this.clienteIndividual = new VistaClienteIndividual();
    }
    
    public void mensajeUsuarioNoExiste()
    {
        JOptionPane.showMessageDialog(login, "El nombre de usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mensajeContrasenaIncorrecta()
    {
        JOptionPane.showMessageDialog(login, "La contraseña es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mensajeDatosInvalidos()
    {
        JOptionPane.showMessageDialog(agregarPropiedad, "Uno o más datos introducidos son inválidos", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mensajeNumeroFincaExistte()
    {
        JOptionPane.showMessageDialog(agregarPropiedad, "El número de finca ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mensajePropiedadAgregada()
    {
        JOptionPane.showMessageDialog(agregarPropiedad, "La propiedad fue agregada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mensajeClienteExiste()
    {
        JOptionPane.showMessageDialog(agregarCliente, "El cliente ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mensajeClienteAgregado()
    {
        JOptionPane.showMessageDialog(agregarCliente, "El cliente fue agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mensajeContratoAgregado()
    {
        JOptionPane.showMessageDialog(agregarContrato, "El contrato fue agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mensajeMantenimientoAgregado()
    {
        JOptionPane.showMessageDialog(agregarMantenimiento, "El mantenimiento fue agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mensajePagoAgregado()
    {
        JOptionPane.showMessageDialog(agregarPagos, "El pago fue agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
        public void mensajeUsuarioAgregado()
    {
        JOptionPane.showMessageDialog(agregarUsuarios, "El usuario fue agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
        public void mensajeUsuarioYaExiste()
    {
        JOptionPane.showMessageDialog(agregarUsuarios, "Ese nombre de usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
