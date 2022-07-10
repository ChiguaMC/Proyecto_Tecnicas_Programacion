package Control;

import Modelo.Casa;
import Modelo.Cliente;
import Modelo.Contrato;
import Modelo.ContratoAlquiler;
import Modelo.ContratoVenta;
import Modelo.Inversionista;
import Modelo.Modelo;
import Modelo.Propiedad;
import Modelo.RenderTable;
import Modelo.Secretaría;
import Vista.Vista;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class Control implements MouseListener {

    private Vista vista;
    private Modelo modelo;

    public Control(Vista vista) {
        this.vista = vista;
        this.modelo = new Modelo();
    }

    public void controlar() {
        //Esto es solo de prueba
        this.datosQuemados();

        //Agrego listeners a los botones de Login
        this.vista.login.botonLogin.addMouseListener(this);

        //Agrego listeners a los botones de Menú
        this.vista.menu.botonClientes.addMouseListener(this);
        this.vista.menu.botonMantenimientos.addMouseListener(this);
        this.vista.menu.botonPagos.addMouseListener(this);
        this.vista.menu.botonPropiedades.addMouseListener(this);
        this.vista.menu.botonUsuarios.addMouseListener(this);
        this.vista.menu.botonContratos.addMouseListener(this);

        //Agregar Render para JTable
        this.vista.contratos.tablaContratos.setDefaultRenderer(Object.class, new RenderTable());
                
        this.vista.login.setLocationRelativeTo(null);
        this.vista.login.setVisible(true);
    }

    public void confirmarLogin(String nombreUsuario, char[] contrasena) {
        String confirmacion = this.modelo.confirmarLogin(nombreUsuario, contrasena);

        switch (confirmacion) {
            case "Usuario no existe":
                this.vista.mensajeUsuarioNoExiste();
                break;
            case "Contraseña incorrecta":
                this.vista.mensajeContrasenaIncorrecta();
                break;
            case "Correcto":
                this.mostrarMenu(nombreUsuario);
                break;
            default:
        }
    }

    public void mostrarMenu(String nombreUsuario) {
        this.vista.menu.setLocationRelativeTo(this.vista.login);
        this.vista.login.setVisible(false);
        this.vista.menu.setVisible(true);
        this.vista.menu.labelUsuario.setText(nombreUsuario);
    }

    public void mostrarPropiedades() {
        this.vista.propiedades.setLocationRelativeTo(this.vista.menu);
        this.vista.menu.setVisible(false);
        this.vista.propiedades.setVisible(true);
    }

    public void mostrarUsuarios() {
        this.vista.usuarios.setLocationRelativeTo(this.vista.menu);
        this.vista.menu.setVisible(false);
        this.vista.usuarios.setVisible(true);
    }

    public void mostrarContratos() {
        this.vista.contratos.setLocationRelativeTo(this.vista.menu);
        this.vista.menu.setVisible(false);
        this.vista.contratos.setVisible(true);
    }

    public void cargarTablaPropiedades() {
        DefaultTableModel tableModel = (DefaultTableModel) this.vista.propiedades.tablaPropiedades.getModel();

        for (Object objeto : this.modelo.getPropiedades().getLista()) {
            Casa casa = (Casa) objeto;
            tableModel.addRow(new Object[]{casa.getNumeroFinca(), casa.getAreaDelTerreno(), casa.getValorFiscal(), casa.getProvincia(), casa.getCanton(), casa.getDistrito(), casa.getDireccion(), casa.getEstadoPropiedad(), casa.getNiveles(), casa.getColor(), casa.getEspacioParqueo(), casa.getAnoCostruccion(), casa.getRutaFotografia()});
        }
    }

    public void cargarTablaUsuarios() {
        DefaultTableModel tableModel = (DefaultTableModel) this.vista.usuarios.tablaUsuarios.getModel();

        for (Object objeto : this.modelo.getInversionistas().getLista()) {
            Inversionista inversionista = (Inversionista) objeto;
            tableModel.addRow(new Object[]{inversionista.getIdUsuario(), inversionista.getClass().getSimpleName()});
        }

        for (Object objeto : this.modelo.getSecretaría().getLista()) {
            Secretaría secretaría = (Secretaría) objeto;
            tableModel.addRow(new Object[]{secretaría.getIdUsuario(), secretaría.getClass().getSimpleName()});
        }
    }

    public void cargarTablaContratos() {
        DefaultTableModel tableModel = (DefaultTableModel) this.vista.contratos.tablaContratos.getModel();

        for (Object objeto : this.modelo.getContratos().getLista()) {

            Contrato contrato = (Contrato) objeto;

            String comision = "";
            String costoMantenimiento = "";

            if (objeto.getClass().getSimpleName().equals("ContratoVenta")) {
                comision = Double.toString(((ContratoVenta) contrato).getComision());
            } else if (objeto.getClass().getSimpleName().equals("ContratoAlquiler")) {
                costoMantenimiento = Double.toString(((ContratoAlquiler) contrato).getCostoMantenimiento());
            }
            tableModel.addRow(new Object[]{contrato.getIdContrato(), contrato.getMonto(), contrato.getFechaContrato().toString(), new JButton("Ver propiedad"), new JButton("Ver Dueño"), new JButton("Ver Cliente"), "Venta", comision, costoMantenimiento});
        }
    }

    //Métodos de MouseListener
    @Override
    public void mouseClicked(MouseEvent fuenteClick) {
        if (fuenteClick.getSource().getClass().getSimpleName().equals("JButton")) {
            JButton boton = (JButton) fuenteClick.getSource();
            switch (boton.getActionCommand()) {
                case "Login":
                    String nombreUsuario = this.vista.login.inputUsuario.getText();
                    char contrasena[] = this.vista.login.inputContrasena.getPassword();
                    this.confirmarLogin(nombreUsuario, contrasena);
                    break;
                case "Ver Propiedades":
                    this.cargarTablaPropiedades();
                    this.mostrarPropiedades();
                    break;
                case "Ver Usuarios":
                    this.cargarTablaUsuarios();
                    this.mostrarUsuarios();
                    break;
                case "Ver Contratos":
                    this.cargarTablaContratos();
                    this.mostrarContratos();
                    break;
                default:
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    //Estos son datos de prueba de momento hasta que se cree la base de datos
    public void datosQuemados() {

        //Un admin
        this.modelo.getInversionistas().agregar(new Inversionista("Josue", "1"));

        //Alguien de secretaria
        this.modelo.getSecretaría().agregar(new Secretaría("JosueSecretaría", "1"));

        //Propiedades
        this.modelo.getPropiedades().agregar(new Casa(1, 100, 1000000, "Heredia", "Heredia", "Mercedes", "100 metros norte de la Escuela", "En Posesión", 1, "Negro", 1, 2000, "Ruta"));
        this.modelo.getPropiedades().agregar(new Casa(2, 100, 1000000, "Heredia", "Heredia", "Mercedes", "100 metros norte de la Escuela", "En Posesión", 1, "Negro", 1, 2000, "Ruta"));
        this.modelo.getPropiedades().agregar(new Casa(3, 100, 1000000, "Heredia", "Heredia", "Mercedes", "100 metros norte de la Escuela", "En Posesión", 1, "Negro", 1, 2000, "Ruta"));
        this.modelo.getPropiedades().agregar(new Casa(4, 100, 1000000, "Heredia", "Heredia", "Mercedes", "100 metros norte de la Escuela", "En Posesión", 1, "Negro", 1, 2000, "Ruta"));
        this.modelo.getPropiedades().agregar(new Casa(5, 100, 1000000, "Heredia", "Heredia", "Mercedes", "100 metros norte de la Escuela", "En Posesión", 1, "Negro", 1, 2000, "Ruta"));

        //Pagos (Necesita Contrato)
        //Contratos
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 5);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.YEAR, 2022);
        Date date = calendar.getTime();

        Propiedad propiedad = new Casa(1, 100, 1000000, "Heredia", "Heredia", "Mercedes", "100 metros norte de la Escuela", "En Posesión", 1, "Negro", 1, 2000, "Ruta");

        Inversionista inversionista = new Inversionista("Josue", "1");
        Cliente cliente = new Cliente("402330273", "71840033", "JosueCliente", "Moraga", "josue.chigua17@gmail.com", "Soltero", "Interesado");

        this.modelo.getContratos().agregar(new ContratoAlquiler("1", 100000, date, propiedad, inversionista, cliente, 20000));
        this.modelo.getContratos().agregar(new ContratoAlquiler("2", 100000, date, propiedad, inversionista, cliente, 20000));
        this.modelo.getContratos().agregar(new ContratoAlquiler("3", 100000, date, propiedad, inversionista, cliente, 20000));
        this.modelo.getContratos().agregar(new ContratoAlquiler("4", 100000, date, propiedad, inversionista, cliente, 20000));
    }
}
