package Control;

import Modelo.Casa;
import Modelo.Cliente;
import Modelo.Contrato;
import Modelo.ContratoAlquiler;
import Modelo.ContratoVenta;
import Modelo.Inversionista;
import Modelo.Mantenimiento;
import Modelo.Modelo;
import Modelo.Pago;
import Modelo.Permisos;
import Modelo.Propiedad;
import Modelo.RenderTable;
import Modelo.Secretaría;
import Vista.Vista;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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
        this.vista.menu.botonLogout.addMouseListener(this);
        this.vista.contratos.botonRegresar.addMouseListener(this);
        this.vista.propiedades.botonRegresar.addMouseListener(this);
        this.vista.usuarios.botonRegresar.addMouseListener(this);
        this.vista.pagos.botonRegresar.addMouseListener(this);
        this.vista.mantenimientos.botonRegresar.addMouseListener(this);
        this.vista.clientes.botonRegresar.addMouseListener(this);

        //Agregar Render para JTable
        this.vista.contratos.tablaContratos.setDefaultRenderer(Object.class, new RenderTable());
        this.vista.pagos.tablaPagos.setDefaultRenderer(Object.class, new RenderTable());
        this.vista.mantenimientos.tablaMantenimiento.setDefaultRenderer(Object.class, new RenderTable());

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

    public void mostrarVentanaTabla(JFrame vista) {
        vista.setLocationRelativeTo(this.vista.menu);
        this.vista.menu.setVisible(false);
        vista.setVisible(true);
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

    public void cargarTablaPagos() {
        DefaultTableModel tableModel = (DefaultTableModel) this.vista.pagos.tablaPagos.getModel();

        for (Object objeto : this.modelo.getPagos().getLista()) {

            Pago pago = (Pago) objeto;

            tableModel.addRow(new Object[]{new JButton("Ver contrato"), pago.getTipoPago(), pago.getFechaPago(), pago.getMontoPago(), pago.getNombreUsuarioPago()});
        }
    }

    public void cargarTablaMantenimientos() {
        DefaultTableModel tableModel = (DefaultTableModel) this.vista.mantenimientos.tablaMantenimiento.getModel();

        for (Object objeto : this.modelo.getMantenimientos().getLista()) {

            Mantenimiento mantenimiento = (Mantenimiento) objeto;

            tableModel.addRow(new Object[]{mantenimiento.getTipoMantenimieinto(), mantenimiento.getMagnitudMantenimiento(), mantenimiento.getInversionRealizada(), new JButton("Ver contrato")});
        }
    }

    public void cargarTablaClientes() {
        DefaultTableModel tableModel = (DefaultTableModel) this.vista.clientes.tablaCliente.getModel();

        for (Object objeto : this.modelo.getClientes().getLista()) {

            Cliente cliente = (Cliente) objeto;

            tableModel.addRow(new Object[]{cliente.getIdCliente(), cliente.getNumeroTelefono(), cliente.getNombre(), cliente.getPrimerApellido(), cliente.getCorreoElectronico(), cliente.getEstadoCivil(), cliente.getEstadoCliente()});
        }
    }

    public void logout() {
        this.vista.login.setLocationRelativeTo(this.vista.menu);
        this.vista.login.setVisible(true);
        this.vista.menu.setVisible(false);
        this.vista.menu.labelUsuario.setText("x");
    }

    public void regresarAlMenu(JFrame vista) {
        this.vista.menu.setLocationRelativeTo(vista);
        this.vista.menu.setVisible(true);
        vista.setVisible(false);
    }

    //Métodos de MouseListener
    @Override
    public void mouseClicked(MouseEvent fuenteClick) {
        if (fuenteClick.getSource().getClass().getSimpleName().equals("JButton")) {
            JButton boton = (JButton) fuenteClick.getSource();
            JFrame jframeFuente = (JFrame) SwingUtilities.getWindowAncestor(boton);
            switch (boton.getActionCommand()) {

                case "Login":
                    String nombreUsuario = this.vista.login.inputUsuario.getText();
                    char contrasena[] = this.vista.login.inputContrasena.getPassword();
                    this.confirmarLogin(nombreUsuario, contrasena);
                    this.vista.login.inputContrasena.setText("");
                    this.vista.login.inputUsuario.setText("");
                    break;
                case "Ver Propiedades":
                    this.cargarTablaPropiedades();
                    this.mostrarVentanaTabla(this.vista.propiedades);
                    break;
                case "Ver Usuarios":
                    this.cargarTablaUsuarios();
                    this.mostrarVentanaTabla(this.vista.usuarios);
                    break;
                case "Ver Contratos":
                    this.cargarTablaContratos();
                    this.mostrarVentanaTabla(this.vista.contratos);
                    break;
                case "Ver Pagos":
                    this.cargarTablaPagos();
                    this.mostrarVentanaTabla(this.vista.pagos);
                    break;
                case "Ver Mantenimientos":
                    this.cargarTablaMantenimientos();
                    this.mostrarVentanaTabla(this.vista.mantenimientos);
                    break;
                case "Ver Clientes":
                    this.cargarTablaClientes();
                    this.mostrarVentanaTabla(this.vista.clientes);
                    break;
                case "Logout":
                    this.logout();
                    break;
                case "Regresar":
                    jframeFuente = (JFrame) SwingUtilities.getWindowAncestor(boton);
                    this.regresarAlMenu(jframeFuente);
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
        Permisos permisosInversionista = new Permisos(true, true, true, true);
        Inversionista inversionistaPrueba = new Inversionista("Josue", "1", permisosInversionista);

        this.modelo.getInversionistas().agregar(inversionistaPrueba);

        //Alguien de secretaria
        Permisos permisosSecretaria = new Permisos(true, false, false, false);
        Secretaría secretariaPrueba = new Secretaría("JosueSecretaría", "1", permisosSecretaria);
        this.modelo.getSecretaría().agregar(secretariaPrueba);

        //Propiedades
        Casa casaPrueba1 = new Casa(1, 100, 1000000, "Heredia", "Heredia", "Mercedes", "100 metros norte de la Escuela", "En Posesión", 1, "Negro", 1, 2000, "Ruta");
        Casa casaPrueba2 = new Casa(2, 100, 1000000, "Heredia", "Heredia", "Mercedes", "100 metros norte de la Escuela", "En Posesión", 1, "Negro", 1, 2000, "Ruta");
        Casa casaPrueba3 = new Casa(3, 100, 1000000, "Heredia", "Heredia", "Mercedes", "100 metros norte de la Escuela", "En Posesión", 1, "Negro", 1, 2000, "Ruta");
        Casa casaPrueba4 = new Casa(4, 100, 1000000, "Heredia", "Heredia", "Mercedes", "100 metros norte de la Escuela", "En Posesión", 1, "Negro", 1, 2000, "Ruta");
        Casa casaPrueba5 = new Casa(5, 100, 1000000, "Heredia", "Heredia", "Mercedes", "100 metros norte de la Escuela", "En Posesión", 1, "Negro", 1, 2000, "Ruta");

        this.modelo.getPropiedades().agregar(casaPrueba1);
        this.modelo.getPropiedades().agregar(casaPrueba2);
        this.modelo.getPropiedades().agregar(casaPrueba3);
        this.modelo.getPropiedades().agregar(casaPrueba4);
        this.modelo.getPropiedades().agregar(casaPrueba5);

        //Contratos
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 5);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.YEAR, 2022);
        Date date = calendar.getTime();

        Propiedad propiedadPrueba = new Casa(1, 100, 1000000, "Heredia", "Heredia", "Mercedes", "100 metros norte de la Escuela", "En Posesión", 1, "Negro", 1, 2000, "Ruta");

        //Clientes
        Cliente clientePrueba1 = new Cliente("402330273", "71840033", "JosueCliente", "Moraga", "josue.chigua17@gmail.com", "Soltero", "Interesado");
        Cliente clientePrueba2 = new Cliente("402330273", "71840033", "JosueCliente", "Moraga", "josue.chigua17@gmail.com", "Soltero", "Interesado");
        Cliente clientePrueba3 = new Cliente("402330273", "71840033", "JosueCliente", "Moraga", "josue.chigua17@gmail.com", "Soltero", "Interesado");
        Cliente clientePrueba4 = new Cliente("402330273", "71840033", "JosueCliente", "Moraga", "josue.chigua17@gmail.com", "Soltero", "Interesado");
        
        this.modelo.getClientes().agregar(clientePrueba1);
        this.modelo.getClientes().agregar(clientePrueba2);
        this.modelo.getClientes().agregar(clientePrueba3);
        this.modelo.getClientes().agregar(clientePrueba4);

        Contrato contratoPrueba1 = new ContratoAlquiler("1", 100000, date, propiedadPrueba, inversionistaPrueba, clientePrueba1, 20000);
        Contrato contratoPrueba2 = new ContratoAlquiler("2", 100000, date, propiedadPrueba, inversionistaPrueba, clientePrueba2, 20000);
        Contrato contratoPrueba3 = new ContratoAlquiler("3", 100000, date, propiedadPrueba, inversionistaPrueba, clientePrueba3, 20000);
        Contrato contratoPrueba4 = new ContratoAlquiler("4", 100000, date, propiedadPrueba, inversionistaPrueba, clientePrueba4, 20000);

        this.modelo.getContratos().agregar(contratoPrueba1);
        this.modelo.getContratos().agregar(contratoPrueba2);
        this.modelo.getContratos().agregar(contratoPrueba3);
        this.modelo.getContratos().agregar(contratoPrueba4);

        //Pagos (Necesita Contrato)
        Pago pagoPrueba1 = new Pago((ContratoAlquiler) contratoPrueba1, "Alquiler", date, 100000, "JosuePagos");
        Pago pagoPrueba2 = new Pago((ContratoAlquiler) contratoPrueba2, "Mantenimiento", date, 100000, "JosuePagos");
        Pago pagoPrueba3 = new Pago((ContratoAlquiler) contratoPrueba3, "Alquiler", date, 100000, "JosuePagos");
        Pago pagoPrueba4 = new Pago((ContratoAlquiler) contratoPrueba4, "Mantenimiento", date, 100000, "JosuePagos");

        this.modelo.getPagos().agregar(pagoPrueba1);
        this.modelo.getPagos().agregar(pagoPrueba2);
        this.modelo.getPagos().agregar(pagoPrueba3);
        this.modelo.getPagos().agregar(pagoPrueba4);

        //Mantenimientos
        Mantenimiento mantenimientoPrueba1 = new Mantenimiento("Preventivo", "Leve", 100000, (ContratoAlquiler) contratoPrueba1);
        Mantenimiento mantenimientoPrueba2 = new Mantenimiento("Correctivo", "Moderado", 100000, (ContratoAlquiler) contratoPrueba2);
        Mantenimiento mantenimientoPrueba3 = new Mantenimiento("Preventivo", "Grande", 100000, (ContratoAlquiler) contratoPrueba3);
        Mantenimiento mantenimientoPrueba4 = new Mantenimiento("Preventivo", "Leve", 100000, (ContratoAlquiler) contratoPrueba4);

        this.modelo.getMantenimientos().agregar(mantenimientoPrueba1);
        this.modelo.getMantenimientos().agregar(mantenimientoPrueba2);
        this.modelo.getMantenimientos().agregar(mantenimientoPrueba3);
        this.modelo.getMantenimientos().agregar(mantenimientoPrueba4);
        
    }
}
