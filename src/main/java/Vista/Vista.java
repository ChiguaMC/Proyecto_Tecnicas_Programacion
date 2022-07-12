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
    
    public Vista() {
        this.login = new Login();
        this.menu = new MenuPrincipal();
        this.propiedades = new VistaPropiedades();
        this.usuarios = new VistaUsuarios();
        this.contratos= new VistaContratos();
        this.pagos= new VistaPagos();
        this.mantenimientos= new VistaMantenimientos();
        this.clientes = new VistaClientes();
    }
    
    public void mensajeUsuarioNoExiste()
    {
        JOptionPane.showMessageDialog(login, "El nombre de usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mensajeContrasenaIncorrecta()
    {
        JOptionPane.showMessageDialog(login, "La contraseña es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
