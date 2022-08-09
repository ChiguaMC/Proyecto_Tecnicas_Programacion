package Control;

import Modelo.Casa;
import Modelo.Cliente;
import Modelo.Contrato;
import Modelo.ContratoAlquiler;
import Modelo.ContratoVenta;
import Modelo.Mantenimiento;
import Modelo.Modelo;
import Modelo.Pago;
import Modelo.Permisos;
import Modelo.Propiedad;
import Modelo.RenderTable;
import Modelo.Usuario;
import Vista.Vista;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class Control implements MouseListener, ActionListener, DocumentListener, WindowListener {

    private Vista vista;
    private Modelo modelo;

    public Control(Vista vista) {
        this.vista = vista;
        this.modelo = new Modelo();
    }

    public void controlar() {
        //Cargar DB
        this.cargarXML("Casa");
        this.cargarXML("Usuario");
        this.cargarXML("Pago");
        this.cargarXML("Mantenimiento");
        this.cargarXML("Cliente");
        this.cargarXML("ContratoAlquiler");
        this.cargarXML("ContratoVenta");

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
        this.vista.contratos.botonAgregar.addMouseListener(this);
        this.vista.propiedades.botonRegresar.addMouseListener(this);
        this.vista.usuarios.botonAgregar.addMouseListener(this);
        this.vista.usuarios.botonRegresar.addMouseListener(this);
        this.vista.pagos.botonRegresar.addMouseListener(this);
        this.vista.pagos.botonAgregar.addMouseListener(this);
        this.vista.mantenimientos.botonRegresar.addMouseListener(this);
        this.vista.mantenimientos.botonAgregar.addMouseListener(this);
        this.vista.clientes.botonAgregar.addMouseListener(this);
        this.vista.clientes.botonRegresar.addMouseListener(this);
        this.vista.propiedades.botonAgregar.addMouseListener(this);
        this.vista.agregarPropiedad.botonFotografia.addMouseListener(this);
        this.vista.agregarPropiedad.botonAgregar.addMouseListener(this);
        this.vista.agregarPropiedad.botonCancelar.addMouseListener(this);
        this.vista.agregarCliente.botonAgregar.addMouseListener(this);
        this.vista.agregarCliente.botonCancelar.addMouseListener(this);
        this.vista.agregarContrato.botonAgregar.addMouseListener(this);
        this.vista.agregarContrato.botonCancelar.addMouseListener(this);
        this.vista.agregarMantenimiento.botonAgregar.addMouseListener(this);
        this.vista.agregarMantenimiento.botonCancelar.addMouseListener(this);
        this.vista.agregarPagos.botonAgregar.addMouseListener(this);
        this.vista.agregarPagos.botonCancelar.addMouseListener(this);
        this.vista.agregarUsuarios.botonAgregar.addMouseListener(this);
        this.vista.agregarUsuarios.botonCancelar.addMouseListener(this);
        this.vista.contratoIndividual.botonVolver.addMouseListener(this);
        this.vista.propiedadIndividual.botonVolver.addMouseListener(this);
        this.vista.clienteIndividual.botonVolver.addMouseListener(this);

        this.vista.pagos.tablaPagos.addMouseListener(this);
        this.vista.mantenimientos.tablaMantenimiento.addMouseListener(this);
        this.vista.contratos.tablaContratos.addMouseListener(this);

        //Agregar ActionListener a ComboBox
        this.vista.agregarPropiedad.comboTipoPropiedad.addActionListener(this);
        this.vista.agregarContrato.comboTipoContrato.addActionListener(this);
        this.vista.agregarPagos.comboClientes.addActionListener(this);
        this.vista.agregarPagos.comboPropiedad.addActionListener(this);

        //Agregar Render para JTable
        this.vista.contratos.tablaContratos.setDefaultRenderer(Object.class, new RenderTable());
        this.vista.pagos.tablaPagos.setDefaultRenderer(Object.class, new RenderTable());
        this.vista.mantenimientos.tablaMantenimiento.setDefaultRenderer(Object.class, new RenderTable());

        //Agregar Document Listener para detectar cambios en el monto del contrato
        this.vista.agregarContrato.inputMonto.getDocument().addDocumentListener(this);

        //Agregar TableModel con imagenes para vista Propiedades
        DefaultTableModel modeloPropiedades = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 12) {
                    return ImageIcon.class;
                }
                return Object.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modeloPropiedades.addColumn("Número Finca");
        modeloPropiedades.addColumn("Área Terreno");
        modeloPropiedades.addColumn("Valor Fiscal");
        modeloPropiedades.addColumn("Provincia");
        modeloPropiedades.addColumn("Cantón");
        modeloPropiedades.addColumn("Distrito");
        modeloPropiedades.addColumn("Dirección");
        modeloPropiedades.addColumn("Estado");
        modeloPropiedades.addColumn("Niveles");
        modeloPropiedades.addColumn("Color");
        modeloPropiedades.addColumn("Espacios De Parqueo");
        modeloPropiedades.addColumn("Año Construcción");
        modeloPropiedades.addColumn("Fotografía");

        //tableModel.addRow(new Object[]{casa.getNumeroFinca(), casa.getAreaDelTerreno(), casa.getValorFiscal(), casa.getProvincia(), casa.getCanton(), casa.getDistrito(), casa.getDireccion(), casa.getEstadoPropiedad(), casa.getNiveles(), casa.getColor(), casa.getEspacioParqueo(), casa.getAnoCostruccion(), new ImageIcon(casa.getRutaFotografia())});
        this.vista.propiedades.tablaPropiedades.setModel(modeloPropiedades);
        this.vista.propiedades.tablaPropiedades.setRowHeight(60);

        //Window Listeners
        this.vista.propiedades.addWindowListener(this);
        this.vista.usuarios.addWindowListener(this);
        this.vista.pagos.addWindowListener(this);
        this.vista.mantenimientos.addWindowListener(this);
        this.vista.clientes.addWindowListener(this);
        this.vista.contratos.addWindowListener(this);
        this.vista.agregarCliente.addWindowListener(this);
        this.vista.agregarContrato.addWindowListener(this);
        this.vista.agregarMantenimiento.addWindowListener(this);
        this.vista.agregarPagos.addWindowListener(this);
        this.vista.agregarPropiedad.addWindowListener(this);
        this.vista.agregarUsuarios.addWindowListener(this);
        this.vista.contratoIndividual.addWindowListener(this);
        this.vista.propiedadIndividual.addWindowListener(this);
        this.vista.clienteIndividual.addWindowListener(this);

        //Setear vista incial
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

    //Estos métodos llaman al conector, llenan las listas con la data de la base de datos, pasan la información a los JTable de cada vista
    public void cargarTablaPropiedades() {
        this.modelo.getPropiedades().borrarTodo();
        this.cargarXML("Casa");
        this.borrarJTable(this.vista.propiedades.tablaPropiedades.getModel());
        DefaultTableModel tableModel = (DefaultTableModel) this.vista.propiedades.tablaPropiedades.getModel();
        for (Object objeto : this.modelo.getPropiedades().getLista()) {
            Casa casa = (Casa) objeto;
            ImageIcon imagen = new ImageIcon(new ImageIcon(casa.getRutaFotografia()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
            tableModel.addRow(new Object[]{casa.getNumeroFinca(), casa.getAreaDelTerreno(), casa.getValorFiscal(), casa.getProvincia(), casa.getCanton(), casa.getDistrito(), casa.getDireccion(), casa.getEstadoPropiedad(), casa.getNiveles(), casa.getColor(), casa.getEspacioParqueo(), casa.getAnoCostruccion(), imagen});
        }
    }

    public void cargarTablaUsuarios() {
        this.modelo.getUsuarios().borrarTodo();
        this.cargarXML("Usuario");
        this.borrarJTable(this.vista.usuarios.tablaUsuarios.getModel());
        DefaultTableModel tableModel = (DefaultTableModel) this.vista.usuarios.tablaUsuarios.getModel();

        for (Object objeto : this.modelo.getUsuarios().getLista()) {
            Usuario usuario = (Usuario) objeto;
            tableModel.addRow(new Object[]{usuario.getIdUsuario(), usuario.getRole()});
        }
    }

    public void cargarTablaContratos() {
        this.modelo.getContratos().borrarTodo();
        this.cargarXML("ContratoAlquiler");
        this.cargarXML("ContratoVenta");
        this.borrarJTable(this.vista.contratos.tablaContratos.getModel());
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
            JButton botonPropiedad = new JButton("Ver propiedad");
            botonPropiedad.setActionCommand(Integer.toString(contrato.getPropiedad().getNumeroFinca()));
            JButton botonCliente = new JButton("Ver cliente");
            botonCliente.setActionCommand(contrato.getCliente().getIdCliente());
            tableModel.addRow(new Object[]{contrato.getIdContrato(), contrato.getMonto(), contrato.getFechaContrato().toString(), botonPropiedad, botonCliente, "Alquiler", comision, costoMantenimiento});
        }
    }

    public void cargarTablaPagos() {
        this.modelo.getPagos().borrarTodo();
        this.cargarXML("Pago");
        this.borrarJTable(this.vista.pagos.tablaPagos.getModel());
        DefaultTableModel tableModel = (DefaultTableModel) this.vista.pagos.tablaPagos.getModel();

        for (Object objeto : this.modelo.getPagos().getLista()) {

            Pago pago = (Pago) objeto;
            JButton botonContrato = new JButton("Ver contrato");
            botonContrato.setActionCommand(pago.getContratoAlquiler().getIdContrato());
            tableModel.addRow(new Object[]{botonContrato, pago.getFechaPago(), pago.getMontoPago(), pago.getNombreUsuarioPago()});
        }
    }

    public void cargarTablaMantenimientos() {
        this.modelo.getMantenimientos().borrarTodo();
        this.cargarXML("Mantenimiento");
        this.borrarJTable(this.vista.mantenimientos.tablaMantenimiento.getModel());
        DefaultTableModel tableModel = (DefaultTableModel) this.vista.mantenimientos.tablaMantenimiento.getModel();

        for (Object objeto : this.modelo.getMantenimientos().getLista()) {

            Mantenimiento mantenimiento = (Mantenimiento) objeto;
            JButton botonContrato = new JButton("Ver contrato");
            botonContrato.setActionCommand(mantenimiento.getContratoAlquiler().getIdContrato());

            tableModel.addRow(new Object[]{mantenimiento.getTipoMantenimieinto(), mantenimiento.getMagnitudMantenimiento(), mantenimiento.getInversionRealizada(), mantenimiento.getFechaMantenimiento(), mantenimiento.getResponsable(), botonContrato});
        }
    }

    public void cargarTablaClientes() {
        this.modelo.getClientes().borrarTodo();
        this.cargarXML("Cliente");
        this.borrarJTable(this.vista.clientes.tablaCliente.getModel());
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

    //Toma una lista y elimina sus filas
    public void borrarJTable(TableModel modeloEditar) {
        DefaultTableModel modeloDefaultEditar = (DefaultTableModel) modeloEditar;
        modeloDefaultEditar.setRowCount(0);
    }

    //Limpian los valores input de las vistas, ocultan/muestran los valores necesarios
    public void limpiarAgregarPropiedades() {
        this.vista.agregarPropiedad.inputNumeroFinca.setText("");
        this.vista.agregarPropiedad.inputArea.setText("");
        this.vista.agregarPropiedad.inputValor.setText("");
        this.vista.agregarPropiedad.inputProvincia.setText("");
        this.vista.agregarPropiedad.inputCanton.setText("");
        this.vista.agregarPropiedad.inputDistrito.setText("");
        this.vista.agregarPropiedad.inputDireccion.setText("");
        this.vista.agregarPropiedad.inputNiveles.setText("");
        this.vista.agregarPropiedad.inputColor.setText("");
        this.vista.agregarPropiedad.inputParqueo.setText("");
        this.vista.agregarPropiedad.inputAnoConstruccion.setText("");
        this.vista.agregarPropiedad.inputFotogragía.setText("");

        if (this.vista.agregarPropiedad.comboTipoPropiedad.getSelectedIndex() > 0) {
            this.vista.agregarPropiedad.comboTipoPropiedad.setSelectedIndex(0);
        }
    }

    public void limpiarAgregarClientes() {
        this.vista.agregarCliente.inputIdentifiacion.setText("");
        this.vista.agregarCliente.inputTelefono.setText("");
        this.vista.agregarCliente.inputNombre.setText("");
        this.vista.agregarCliente.inputPrimerApellido.setText("");
        this.vista.agregarCliente.inputEmail.setText("");

        if (this.vista.agregarCliente.comboEstadoCivil.getSelectedIndex() > 0) {
            this.vista.agregarCliente.comboEstadoCivil.setSelectedIndex(0);
        }
    }

    public void limpiarAgregarContratos() {
        this.vista.agregarContrato.inputMantenimiento.setText("");
        this.vista.agregarContrato.inputComision.setText("");
        this.vista.agregarContrato.inputMonto.setText("");

        this.vista.agregarContrato.comboCliente.removeAllItems();
        this.vista.agregarContrato.comboPropiedad.removeAllItems();

        if (this.vista.agregarContrato.comboTipoContrato.getSelectedIndex() > 0) {
            this.vista.agregarContrato.comboTipoContrato.setSelectedIndex(0);
        }

        this.vista.agregarContrato.inputMantenimiento.setVisible(false);
        this.vista.agregarContrato.labelAlquiler.setVisible(false);

        this.vista.agregarContrato.inputComision.setVisible(true);
        this.vista.agregarContrato.labelComision.setVisible(true);
    }

    public void limpiarAgregarMantenimientos() {

        this.vista.agregarMantenimiento.inputInversion.setText("");
        this.vista.agregarMantenimiento.inputResponsable.setText("");
        this.vista.agregarMantenimiento.inputFecha.setDate(null);

        this.vista.agregarMantenimiento.comboPropiedad.removeAllItems();

        if (this.vista.agregarMantenimiento.comboTipoMantenimiento.getSelectedIndex() > 0) {
            this.vista.agregarMantenimiento.comboTipoMantenimiento.setSelectedIndex(0);
        }
    }

    public void limpiarAgregarPagos() {

        this.vista.agregarPagos.inputAlquiler.setText("");
        this.vista.agregarPagos.inputMantenimiento.setText("");
        this.vista.agregarPagos.inputNombre.setText("");
        this.vista.agregarPagos.comboClientes.removeAllItems();
        this.vista.agregarPagos.comboPropiedad.removeAllItems();
        this.vista.agregarPagos.inputFecha.setDate(null);
    }

    public void limpiarAgregarUsuarios() {
        this.vista.agregarUsuarios.inputUsuario.setText("");
        this.vista.agregarUsuarios.inputContrasena.setText("");
        this.vista.agregarUsuarios.checkAgregar.setSelected(false);
        this.vista.agregarUsuarios.checkBorrar.setSelected(false);
    }

    //Controlan las acciones del botón cancelar en cada vista
    public void accionCancelarPropiedades() {
        this.vista.agregarPropiedad.setVisible(false);
        this.vista.propiedades.botonAgregar.setEnabled(true);
        this.vista.propiedades.botonRegresar.setEnabled(true);
    }

    public void accionCancelarClientes() {
        this.vista.agregarCliente.setVisible(false);
        this.vista.clientes.botonAgregar.setEnabled(true);
        this.vista.clientes.botonRegresar.setEnabled(true);
    }

    public void accionCancelarContratos() {
        this.vista.agregarContrato.setVisible(false);
        this.vista.contratos.botonAgregar.setEnabled(true);
        this.vista.contratos.botonRegresar.setEnabled(true);
    }

    public void accionCancelarMantenimientos() {
        this.vista.agregarMantenimiento.setVisible(false);
        this.vista.mantenimientos.botonAgregar.setEnabled(true);
        this.vista.mantenimientos.botonRegresar.setEnabled(true);
    }

    public void accionCancelarPagos() {
        this.vista.agregarPagos.setVisible(false);
        this.vista.pagos.botonAgregar.setEnabled(true);
        this.vista.pagos.botonRegresar.setEnabled(true);
    }

    public void accionCancelarUsuarios() {
        this.vista.agregarUsuarios.setVisible(false);
        this.vista.usuarios.botonAgregar.setEnabled(true);
        this.vista.usuarios.botonRegresar.setEnabled(true);
    }

    //Llenan la información de las listas en los comboBox por cada vista
    public void cargarComboClientes(JComboBox comboBox) {
        this.modelo.getClientes().borrarTodo();
        this.cargarXML("Cliente");

        for (Object objeto : this.modelo.getClientes().getLista()) {
            Cliente cliente = (Cliente) objeto;
            comboBox.addItem(cliente.getIdCliente());
        }
    }

    public void cargarComboClientesEstado(JComboBox comboBox, String estado) {
        this.modelo.getClientes().borrarTodo();
        this.cargarXML("Cliente");

        for (Object objeto : this.modelo.getClientes().getLista()) {
            Cliente cliente = (Cliente) objeto;
            if (cliente.getEstadoCliente().equals(estado)) {
                comboBox.addItem(cliente.getIdCliente());
            }
        }
    }

    public void cargarComboPropiedadTodas(JComboBox comboBox, String estado) {
        this.modelo.getPropiedades().borrarTodo();
        this.cargarXML("Casa");
        for (Object objeto : this.modelo.getPropiedades().getLista()) {
            Propiedad propiedad = (Propiedad) objeto;
            if (propiedad.getEstadoPropiedad().equals(estado)) {
                comboBox.addItem(Integer.toString(propiedad.getNumeroFinca()));
            }
        }
    }

    public void cargarComboPropiedadCliente(JComboBox comboBox, String idCliente) {
        this.modelo.getPropiedades().borrarTodo();
        this.cargarXML("Casa");
        for (Object objeto : this.modelo.getContratos().getLista()) {
            Contrato contrato = (Contrato) objeto;
            if (contrato.getCliente().getIdCliente().equals(idCliente)) {
                comboBox.addItem(Integer.toString(contrato.getPropiedad().getNumeroFinca()));
            }
        }
    }

    public void login() {
        String nombreUsuario = this.vista.login.inputUsuario.getText();
        char contrasena[] = this.vista.login.inputContrasena.getPassword();
        this.confirmarLogin(nombreUsuario, contrasena);
        this.vista.login.inputContrasena.setText("");
        this.vista.login.inputUsuario.setText("");
        if (!this.modelo.usuarioPuedeEscribir(nombreUsuario)) {
            denegarPermisosAgregar();
        } else {
            aceptarPermisosAgregar();
        }
    }

    //Prepara el entorno de visualización de cada una de las vistas
    public void verPropiedades() {
        this.cargarTablaPropiedades();
        this.mostrarVentanaTabla(this.vista.propiedades);
    }

    public void verUsuarios() {
        this.cargarTablaUsuarios();
        this.mostrarVentanaTabla(this.vista.usuarios);
    }

    public void verContratos() {
        this.cargarTablaContratos();
        this.mostrarVentanaTabla(this.vista.contratos);
    }

    public void verPagos() {
        this.cargarTablaPagos();
        this.mostrarVentanaTabla(this.vista.pagos);
    }

    public void verMantenimientos() {
        this.cargarTablaMantenimientos();
        this.mostrarVentanaTabla(this.vista.mantenimientos);
    }

    public void verClientes() {
        this.cargarTablaClientes();
        this.mostrarVentanaTabla(this.vista.clientes);
    }

    public void verAgregarPropiedades() {
        this.vista.agregarPropiedad.setLocationRelativeTo(this.vista.propiedades);

        this.vista.agregarPropiedad.inputNiveles.setVisible(false);
        this.vista.agregarPropiedad.inputColor.setVisible(false);
        this.vista.agregarPropiedad.inputParqueo.setVisible(false);
        this.vista.agregarPropiedad.inputAnoConstruccion.setVisible(false);
        this.vista.agregarPropiedad.inputFotogragía.setVisible(false);
        this.vista.agregarPropiedad.botonFotografia.setVisible(false);

        this.vista.agregarPropiedad.labelAnoConstruccion.setVisible(false);
        this.vista.agregarPropiedad.labelColor.setVisible(false);
        this.vista.agregarPropiedad.labelFotografia.setVisible(false);
        this.vista.agregarPropiedad.labelNivel.setVisible(false);
        this.vista.agregarPropiedad.labelParqueo.setVisible(false);

        this.vista.propiedades.botonAgregar.setEnabled(false);
        this.vista.propiedades.botonRegresar.setEnabled(false);
        this.vista.agregarPropiedad.setVisible(true);
    }

    public void verAgregarClientes() {
        this.vista.agregarCliente.setLocationRelativeTo(this.vista.clientes);

        this.vista.clientes.botonAgregar.setEnabled(false);
        this.vista.clientes.botonRegresar.setEnabled(false);
        this.vista.agregarCliente.setVisible(true);
    }

    public void verAgregarContratos() {
        this.vista.agregarContrato.setLocationRelativeTo(this.vista.contratos);

        this.vista.contratos.botonAgregar.setEnabled(false);
        this.vista.contratos.botonRegresar.setEnabled(false);
        this.vista.agregarContrato.setVisible(true);

        this.cargarComboClientes(this.vista.agregarContrato.comboCliente);
        this.cargarComboPropiedadTodas(this.vista.agregarContrato.comboPropiedad, "En posesión");

        this.vista.agregarContrato.inputMantenimiento.setVisible(false);
        this.vista.agregarContrato.labelAlquiler.setVisible(false);
    }

    public void verAgregarMantenimientos() {
        this.vista.agregarMantenimiento.setLocationRelativeTo(this.vista.mantenimientos);

        this.cargarComboPropiedadTodas(this.vista.agregarMantenimiento.comboPropiedad, "Alquilada");

        this.vista.mantenimientos.botonAgregar.setEnabled(false);
        this.vista.mantenimientos.botonRegresar.setEnabled(false);
        this.vista.agregarMantenimiento.setVisible(true);
    }

    public void verAgregarPagos() {
        this.modelo.getContratos().borrarTodo();
        this.cargarXML("ContratoAlquiler");
        this.cargarXML("ContratoVenta");

        this.vista.agregarPagos.setLocationRelativeTo(this.vista.pagos);

        this.cargarComboClientesEstado(this.vista.agregarPagos.comboClientes, "Activo");

        this.vista.pagos.botonAgregar.setEnabled(false);
        this.vista.pagos.botonRegresar.setEnabled(false);
        this.vista.agregarPagos.setVisible(true);
    }

    public void verAgregarUsuarios() {
        this.vista.agregarUsuarios.setLocationRelativeTo(this.vista.usuarios);

        this.vista.usuarios.botonAgregar.setEnabled(false);
        this.vista.usuarios.botonRegresar.setEnabled(false);
        this.vista.agregarUsuarios.setVisible(true);
    }

    public void buscarFotografia() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPEG", "JPG", "PNG");
        this.vista.fileChooser.fileChooser.setFileFilter(filtro);
        this.vista.fileChooser.fileChooser.showOpenDialog(this.vista.agregarPropiedad);

        File archivoOrigen = this.vista.fileChooser.fileChooser.getSelectedFile();

        if (archivoOrigen != null) {
            this.vista.agregarPropiedad.inputFotogragía.setText(archivoOrigen.getPath());
        }
    }
    
    public void verContratoIndividual(JButton boton) {
        Contrato contratoBuscado = this.modelo.retornarContratoPorCodigo(boton.getActionCommand());

        this.vista.contratoIndividual.labelContratoId.setText("Contrato: " + contratoBuscado.getIdContrato());
        this.vista.contratoIndividual.setLocationRelativeTo(this.vista.pagos);
        this.vista.contratoIndividual.inputTipo.setText(contratoBuscado.getClass().getSimpleName());
        this.vista.contratoIndividual.inputMonto.setText(Double.toString(contratoBuscado.getMonto()));
        this.vista.contratoIndividual.inputFecha.setText(contratoBuscado.getFechaContrato().toString());
        this.vista.contratoIndividual.inputNumeroFinca.setText(Integer.toString(contratoBuscado.getPropiedad().getNumeroFinca()));
        this.vista.contratoIndividual.inputIDCliente.setText(contratoBuscado.getCliente().getIdCliente());

        this.vista.contratoIndividual.inputMantenimiento.setText(Double.toString(((ContratoAlquiler) contratoBuscado).getCostoMantenimiento()));
        this.vista.contratoIndividual.setVisible(true);
    }

    public void verPropiedadIndividual(JButton boton) {
        Propiedad propiedadBuscada = this.modelo.retornarPropiedad(Integer.parseInt(boton.getActionCommand()));

        this.vista.propiedadIndividual.labelNumeroFinca.setText("Número Finca: " + propiedadBuscada.getNumeroFinca());
        this.vista.propiedadIndividual.inputArea.setText(Double.toString(propiedadBuscada.getAreaDelTerreno()));
        this.vista.propiedadIndividual.inputValor.setText(Double.toString(propiedadBuscada.getValorFiscal()));
        this.vista.propiedadIndividual.inputProvincia.setText(propiedadBuscada.getProvincia());
        this.vista.propiedadIndividual.inputCanton.setText(propiedadBuscada.getCanton());
        this.vista.propiedadIndividual.inputDistrito.setText(propiedadBuscada.getDistrito());
        this.vista.propiedadIndividual.inputDireccion.setText(propiedadBuscada.getDireccion());
        this.vista.propiedadIndividual.inputEstado.setText(propiedadBuscada.getEstadoPropiedad());

        if (propiedadBuscada.getClass().getSimpleName().equals("Casa")) {
            this.vista.propiedadIndividual.inputNiveles.setText(Integer.toString(((Casa) propiedadBuscada).getNiveles()));
            this.vista.propiedadIndividual.inputColor.setText(((Casa) propiedadBuscada).getColor());
            this.vista.propiedadIndividual.inputParqueos.setText(Integer.toString(((Casa) propiedadBuscada).getEspacioParqueo()));
            this.vista.propiedadIndividual.inputAno.setText(Integer.toString(((Casa) propiedadBuscada).getAnoCostruccion()));
            ImageIcon imagen = new ImageIcon(new ImageIcon(((Casa) propiedadBuscada).getRutaFotografia()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
            this.vista.propiedadIndividual.labelFoto.setIcon(imagen);
        }
        this.vista.propiedadIndividual.setLocationRelativeTo(this.vista.contratos);
        this.vista.propiedadIndividual.setVisible(true);
    }

    public void verClienteIndividual(JButton boton) {
        Cliente clienteBuscado = this.modelo.retornarCliente(boton.getActionCommand());

        this.vista.clienteIndividual.labelIDCliente.setText("ID Cliente: " + clienteBuscado.getIdCliente());
        this.vista.clienteIndividual.inputTelefono.setText(clienteBuscado.getNumeroTelefono());
        this.vista.clienteIndividual.inputCorreo.setText(clienteBuscado.getCorreoElectronico());
        this.vista.clienteIndividual.inputNombre.setText(clienteBuscado.getNombre() + " " + clienteBuscado.getPrimerApellido());
        this.vista.clienteIndividual.inputEstadoCivil.setText(clienteBuscado.getEstadoCivil());
        this.vista.clienteIndividual.inputEstadoCliente.setText(clienteBuscado.getEstadoCliente());

        this.vista.clienteIndividual.setLocationRelativeTo(this.vista.contratos);
        this.vista.clienteIndividual.setVisible(true);
    }
    
    //Controlan los métodos de agregar objetos a las listas y a la base de datos

    public void agregarPropiedad() {
        try {
            boolean isCasaBlank = false;
            int numeroFinca = Integer.parseInt(this.vista.agregarPropiedad.inputNumeroFinca.getText());
            Double areaDelTerreno = Double.parseDouble(this.vista.agregarPropiedad.inputArea.getText());
            Double valorFiscal = Double.parseDouble(this.vista.agregarPropiedad.inputValor.getText());
            String provincia = this.vista.agregarPropiedad.inputProvincia.getText();
            String canton = this.vista.agregarPropiedad.inputCanton.getText();
            String distrito = this.vista.agregarPropiedad.inputDistrito.getText();
            String direccion = this.vista.agregarPropiedad.inputDireccion.getText();
            String tipoPropiedad = this.vista.agregarPropiedad.comboTipoPropiedad.getSelectedItem().toString();
            int niveles = 0;
            String color = "";
            int espacioParqueo = 0;
            int anoCostruccion = 0;
            String rutaFotografia = "";

            if (tipoPropiedad.equals("Casa")) {
                niveles = Integer.parseInt(this.vista.agregarPropiedad.inputNiveles.getText());
                color = this.vista.agregarPropiedad.inputColor.getText();
                espacioParqueo = Integer.parseInt(this.vista.agregarPropiedad.inputParqueo.getText());
                anoCostruccion = Integer.parseInt(this.vista.agregarPropiedad.inputAnoConstruccion.getText());
                rutaFotografia = this.vista.agregarPropiedad.inputFotogragía.getText();
                if (niveles <= 0 && color.isBlank() && espacioParqueo <= 0 && anoCostruccion <= 0 && rutaFotografia.isBlank()) {
                    isCasaBlank = true;
                }
            }
            if (numeroFinca >= 0 && areaDelTerreno > 0 && valorFiscal > 0 && !provincia.isBlank() && !canton.isBlank() && !distrito.isBlank() && !direccion.isBlank() && !tipoPropiedad.isBlank() && !isCasaBlank) {
                Propiedad propiedadNueva = null;
                switch (tipoPropiedad) {
                    case "Casa":

                        //Copiar foto
                        File archivoCopiar = this.vista.fileChooser.fileChooser.getSelectedFile();
                        File archivoPegar = new File("src/main/resources/ImagenesCasas/" + numeroFinca + ".png");
                        Path pathDestino = Paths.get(archivoPegar.getAbsolutePath());

                        try {
                            Files.copy(archivoCopiar.toPath(), pathDestino);
                        } catch (IOException ex) {
                            System.out.println("No se pudo copiar la imagen");
                        }

                        propiedadNueva = new Casa(numeroFinca, areaDelTerreno, valorFiscal, provincia, canton, distrito, direccion, "En posesión", niveles, color, espacioParqueo, anoCostruccion, archivoPegar.getPath());
                        break;
                    default:
                        propiedadNueva = new Propiedad(numeroFinca, areaDelTerreno, valorFiscal, provincia, canton, distrito, direccion, "En posesión");
                }

                if (!this.modelo.existeNumeroFinca(numeroFinca)) {
                    this.modelo.getPropiedades().agregar(propiedadNueva);
                    this.guardarXML("Casa");
                    this.vista.mensajePropiedadAgregada();
                    this.borrarJTable(this.vista.propiedades.tablaPropiedades.getModel());
                    this.cargarTablaPropiedades();
                } else {
                    this.vista.mensajeNumeroFincaExistte();
                }
            } else {
                this.vista.mensajeDatosInvalidos();
            }
        } catch (Exception exception) {
            this.vista.mensajeDatosInvalidos();
        }
    }

    public void agregarCliente() {
        try {
            int idCliente = Integer.parseInt(this.vista.agregarCliente.inputIdentifiacion.getText());
            int numeroTelefono = Integer.parseInt(this.vista.agregarCliente.inputTelefono.getText());
            String nombre = this.vista.agregarCliente.inputNombre.getText();
            String primerApellido = this.vista.agregarCliente.inputPrimerApellido.getText();
            String correoElectronico = this.vista.agregarCliente.inputEmail.getText();
            String estadoCivil = this.vista.agregarCliente.comboEstadoCivil.getSelectedItem().toString();

            if (!nombre.isBlank() && !primerApellido.isBlank() && !correoElectronico.isBlank() && !estadoCivil.isBlank()) {
                if (!this.modelo.existeIDCliente(Integer.toString(idCliente))) {
                    Cliente clienteNuevo = new Cliente(Integer.toString(idCliente), Integer.toString(numeroTelefono), nombre, primerApellido, correoElectronico, estadoCivil, "Interesado");
                    this.modelo.getClientes().agregar(clienteNuevo);
                    this.guardarXML("Cliente");
                    this.vista.mensajeClienteAgregado();
                    this.limpiarAgregarClientes();
                    this.borrarJTable(this.vista.clientes.tablaCliente.getModel());
                    this.cargarTablaClientes();
                    this.accionCancelarClientes();
                } else {
                    this.vista.mensajeClienteExiste();
                }
            } else {
                this.vista.mensajeDatosInvalidos();
            }
        } catch (Exception exception) {
            this.vista.mensajeDatosInvalidos();
        }
    }

    public void agregarContrato() {
        try {
            String ultimoContratoString = Integer.toString(this.modelo.getContratos().getLista().size());
            int ultimoContratoInt = this.modelo.getContratos().getLista().size();
            int cantidadCeros = 6 - ultimoContratoString.length();
            String idContrato = "";

            Double monto = Double.parseDouble(this.vista.agregarContrato.inputMonto.getText());
            Date fechaContrato = new Date();
            int numeroFinca = Integer.parseInt(this.vista.agregarContrato.comboPropiedad.getSelectedItem().toString());
            String identificadorCliente = this.vista.agregarContrato.comboCliente.getSelectedItem().toString();
            String tipoContrato = this.vista.agregarContrato.comboTipoContrato.getSelectedItem().toString();

            Propiedad propiedadRelacionado = this.modelo.retornarPropiedad(numeroFinca);
            Cliente clienteRelacionado = this.modelo.retornarCliente(identificadorCliente);

            Contrato contratoNuevo = null;

            if (tipoContrato.equals("Venta")) {
                Double comision = Double.parseDouble(this.vista.agregarContrato.inputComision.getText());
                idContrato = "VEN" + String.format("%0" + cantidadCeros + "d", ultimoContratoInt);
                this.modelo.cambiarEstadoPropiedad(numeroFinca, "Vendida");
                contratoNuevo = new ContratoVenta(idContrato, monto, fechaContrato, propiedadRelacionado, clienteRelacionado, comision);
            } else if (tipoContrato.equals("Alquiler")) {
                Double alquiler = Double.parseDouble(this.vista.agregarContrato.inputMantenimiento.getText());
                idContrato = "ALQ" + String.format("%0" + cantidadCeros + "d", ultimoContratoInt);
                this.modelo.cambiarEstadoPropiedad(numeroFinca, "Alquilada");
                contratoNuevo = new ContratoAlquiler(idContrato, monto, fechaContrato, propiedadRelacionado, clienteRelacionado, alquiler);
            }
            this.guardarXML("Casa");
            this.modelo.getContratos().agregar(contratoNuevo);
            this.guardarXML("ContratoAlquiler");
            this.guardarXML("ContratoVenta");
            this.modelo.cambiarEstadoCliente(identificadorCliente, "Activo");
            this.guardarXML("Cliente");
            this.vista.mensajeContratoAgregado();
            this.limpiarAgregarContratos();
            this.borrarJTable(this.vista.contratos.tablaContratos.getModel());
            this.cargarTablaContratos();
            this.accionCancelarContratos();
        } catch (Exception exception) {
            this.vista.mensajeDatosInvalidos();
            System.out.println(exception.getMessage());
        }
    }

    public void agregarMantenimiento() {
        try {
            String tipoMantenimieinto = this.vista.agregarMantenimiento.comboTipoMantenimiento.getSelectedItem().toString();
            String magnitudMantenimiento = this.vista.agregarMantenimiento.comboMagnitud.getSelectedItem().toString();
            Double inversionRealizada = Double.parseDouble(this.vista.agregarMantenimiento.inputInversion.getText());
            int numeroFinca = Integer.parseInt(this.vista.agregarMantenimiento.comboPropiedad.getSelectedItem().toString());
            String responsable = this.vista.agregarMantenimiento.inputResponsable.getText();

            ContratoAlquiler contratoAlquiler = (ContratoAlquiler) this.modelo.retornarContrato(numeroFinca);

            Date fecha = this.vista.agregarMantenimiento.inputFecha.getDate();

            if (!responsable.isBlank() && fecha != null) {
                Mantenimiento mantenimientoNuevo = new Mantenimiento(tipoMantenimieinto, magnitudMantenimiento, inversionRealizada, contratoAlquiler, fecha, responsable);
                this.modelo.getMantenimientos().agregar(mantenimientoNuevo);
                this.guardarXML("Mantenimiento");
                this.vista.mensajeMantenimientoAgregado();

                this.borrarJTable(this.vista.mantenimientos.tablaMantenimiento.getModel());
                this.cargarTablaMantenimientos();
                this.limpiarAgregarMantenimientos();
                this.accionCancelarMantenimientos();
            } else {
                this.vista.mensajeDatosInvalidos();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            this.vista.mensajeDatosInvalidos();
        }
    }

    public void agregarPago() {
        try {

            ContratoAlquiler contratoAlquiler = this.modelo.retornarPropiedadContrato(Integer.parseInt(this.vista.agregarPagos.comboPropiedad.getSelectedItem().toString()));
            Date fechaPago = this.vista.agregarPagos.inputFecha.getDate();
            Double montoPago = Double.parseDouble(this.vista.agregarPagos.inputTotal.getText());
            String nombreUsuarioPago = this.vista.agregarPagos.inputNombre.getText();

            if (!nombreUsuarioPago.isBlank() && fechaPago != null) {
                Pago pagoNuevo = new Pago(contratoAlquiler, fechaPago, montoPago, nombreUsuarioPago);
                this.modelo.getPagos().agregar(pagoNuevo);
                this.guardarXML("Pago");
                this.vista.mensajePagoAgregado();

                this.borrarJTable(this.vista.pagos.tablaPagos.getModel());
                this.cargarTablaPagos();
                this.limpiarAgregarPagos();
                this.accionCancelarPagos();

            } else {
                this.vista.mensajeDatosInvalidos();
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            this.vista.mensajeDatosInvalidos();
        }
    }

    public void agregarUsuario() {
        try {
            String nombreUsuario = this.vista.agregarUsuarios.inputUsuario.getText();
            String contrasena = String.valueOf(this.vista.agregarUsuarios.inputContrasena.getPassword());
            String role = this.vista.agregarUsuarios.inputRole.getText();

            boolean agregar = this.vista.agregarUsuarios.checkAgregar.isSelected();
            boolean borrar = this.vista.agregarUsuarios.checkAgregar.isSelected();

            Permisos permisosNuevos = new Permisos(true, agregar, borrar);

            if (this.modelo.existeUsuario(nombreUsuario)) {
                this.vista.mensajeUsuarioYaExiste();
            } else if (!nombreUsuario.isBlank() && !contrasena.isBlank() && !role.isBlank()) {
                Usuario usuarioNuevo = new Usuario(nombreUsuario, contrasena, permisosNuevos, role);
                this.modelo.getUsuarios().agregar(usuarioNuevo);
                this.guardarXML("Usuario");
                this.vista.mensajeUsuarioAgregado();
                this.borrarJTable(this.vista.usuarios.tablaUsuarios.getModel());
                this.cargarTablaUsuarios();
                this.limpiarAgregarUsuarios();
                this.accionCancelarUsuarios();
            } else {
                this.vista.mensajeDatosInvalidos();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            this.vista.mensajeDatosInvalidos();
        }
    }

    public void calculoComision() {
        Double monto = 0.0;
        Double porcentageComision = 0.025;
        try {
            monto = Double.parseDouble(this.vista.agregarContrato.inputMonto.getText());
            this.vista.agregarContrato.inputComision.setText(Double.toString(monto * porcentageComision));
        } catch (Exception exception) {
            //System.out.println(exception.getMessage());
        }
    }

    //Niega los permisos de edición para todas las vistas
    public void denegarPermisosAgregar() {
        this.vista.clientes.botonAgregar.setVisible(false);
        this.vista.contratos.botonAgregar.setVisible(false);
        this.vista.mantenimientos.botonAgregar.setVisible(false);
        this.vista.pagos.botonAgregar.setVisible(false);
        this.vista.propiedades.botonAgregar.setVisible(false);
        this.vista.usuarios.botonAgregar.setVisible(false);
    }

    //Muestra los permisos de edición para todas las vistas
    public void aceptarPermisosAgregar() {
        this.vista.clientes.botonAgregar.setVisible(true);
        this.vista.contratos.botonAgregar.setVisible(true);
        this.vista.mantenimientos.botonAgregar.setVisible(true);
        this.vista.pagos.botonAgregar.setVisible(true);
        this.vista.propiedades.botonAgregar.setVisible(true);
        this.vista.usuarios.botonAgregar.setVisible(true);
    }

    //Controlan la carga y escritura de la base de datos
    public void guardarXML(String clase) {
        try {
            switch (clase) {
                case "Casa":
                    this.modelo.getConector().escribirXMLCasas((List<Casa>) this.modelo.getPropiedades().getLista(), "src/main/resources/DB/propiedades.xml");
                    break;
                case "Usuario":
                    this.modelo.getConector().escribirXMLUsuarios((List<Usuario>) this.modelo.getUsuarios().getLista(), "src/main/resources/DB/usuarios.xml");
                    break;
                case "Pago":
                    this.modelo.getConector().escribirXMLPagos((List<Pago>) this.modelo.getPagos().getLista(), "src/main/resources/DB/pagos.xml");
                    break;
                case "Mantenimiento":
                    this.modelo.getConector().escribirXMLMantenimientos((List<Mantenimiento>) this.modelo.getMantenimientos().getLista(), "src/main/resources/DB/mantenimientos.xml");
                    break;
                case "Cliente":
                    this.modelo.getConector().escribirXMLClientes((List<Cliente>) this.modelo.getClientes().getLista(), "src/main/resources/DB/clientes.xml");
                    break;
                case "ContratoAlquiler":
                    this.modelo.getConector().escribirXMLContratosAlquiler((List<ContratoAlquiler>) this.modelo.retornarContratosAlquiler(), "src/main/resources/DB/contratosAlquiler.xml");
                    break;

                case "ContratoVenta":
                    this.modelo.getConector().escribirXMLContratosVenta((List<ContratoVenta>) this.modelo.retornarContratosVenta(), "src/main/resources/DB/contratosVenta.xml");
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarXML(String clase) {
        try {
            switch (clase) {
                case "Casa":
                    this.modelo.getConector().leerPropiedades(this.modelo.getPropiedades().getLista(), "src/main/resources/DB/propiedades.xml");
                    break;
                case "Usuario":
                    this.modelo.getConector().leerUsuarios(this.modelo.getUsuarios().getLista(), "src/main/resources/DB/usuarios.xml");
                    break;
                case "Pago":
                    this.modelo.getConector().leerPagos(this.modelo.getPagos().getLista(), "src/main/resources/DB/pagos.xml");
                    break;
                case "Mantenimiento":
                    this.modelo.getConector().leerMantenimientos(this.modelo.getMantenimientos().getLista(), "src/main/resources/DB/mantenimientos.xml");
                    break;
                case "Cliente":
                    this.modelo.getConector().leerClientes(this.modelo.getClientes().getLista(), "src/main/resources/DB/clientes.xml");
                    break;
                case "ContratoAlquiler":
                    this.modelo.getConector().leerContratoAlquiler(this.modelo.getContratos().getLista(), "src/main/resources/DB/contratosAlquiler.xml");
                    break;
                case "ContratoVenta":
                    this.modelo.getConector().leerContratoVenta(this.modelo.getContratos().getLista(), "src/main/resources/DB/contratosVenta.xml");
                    break;
            }
        } catch (JAXBException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Métodos de MouseListener
    @Override
    public void mouseClicked(MouseEvent fuenteClick) {
        if (fuenteClick.getSource().getClass().getSimpleName().equals("JButton")) {
            JButton boton = (JButton) fuenteClick.getSource();
            JFrame jframeFuente = (JFrame) SwingUtilities.getWindowAncestor(boton);
            switch (boton.getActionCommand()) {

                case "Login":
                    login();
                    break;
                case "Ver Propiedades":
                    verPropiedades();
                    break;
                case "Ver Usuarios":
                    verUsuarios();
                    break;
                case "Ver Contratos":
                    verContratos();
                    break;
                case "Ver Pagos":
                    verPagos();
                    break;
                case "Ver Mantenimientos":
                    verMantenimientos();
                    break;
                case "Ver Clientes":
                    verClientes();
                    break;
                case "Logout":
                    this.logout();
                    break;
                case "Regresar":
                    jframeFuente = (JFrame) SwingUtilities.getWindowAncestor(boton);
                    this.regresarAlMenu(jframeFuente);
                    break;
                case "VistaPropiedad":
                    verAgregarPropiedades();
                    break;

                case "VistaCliente":
                    verAgregarClientes();
                    break;

                case "VistaContrato":
                    verAgregarContratos();
                    break;

                case "VistaMantenimiento":
                    verAgregarMantenimientos();
                    break;

                case "VistaPagos":
                    verAgregarPagos();
                    break;

                case "VistaUsuarios":
                    verAgregarUsuarios();
                    break;

                case "Buscar Fotografía":
                    buscarFotografia();
                    break;
                case "AgregarPropiedad":
                    agregarPropiedad();
                    break;
                case "AgregarCliente":
                    agregarCliente();
                    break;
                case "AgregarContrato":
                    agregarContrato();
                    break;
                case "AgregarMantenimiento":
                    agregarMantenimiento();
                    break;
                case "AgregarPago":
                    agregarPago();
                    break;
                case "AgregarUsuario":
                    agregarUsuario();
                    break;
                case "CancelarAgregarPropiedad":
                    this.limpiarAgregarPropiedades();
                    this.accionCancelarPropiedades();
                    break;
                case "CancelarAgregarCliente":
                    this.limpiarAgregarClientes();
                    this.accionCancelarClientes();
                    break;
                case "CancelarAgregarContrato":
                    this.limpiarAgregarContratos();
                    this.accionCancelarContratos();
                    break;
                case "CancelarAgregarMantenimiento":
                    this.limpiarAgregarMantenimientos();
                    this.accionCancelarMantenimientos();
                    break;
                case "CancelarAgregarPagos":
                    this.limpiarAgregarPagos();
                    this.accionCancelarPagos();
                    break;
                case "CancelarAgregarUsuarios":
                    this.limpiarAgregarUsuarios();
                    this.accionCancelarUsuarios();
                    break;
                case "VolverIndividual":
                    jframeFuente.setVisible(false);
                    break;
                default:
            }
        } else if (fuenteClick.getSource().getClass().getSimpleName().equals("JTable")) {
            JTable tabla = (JTable) fuenteClick.getSource();
            if (tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()).getClass().getSimpleName().equals("JButton")) {
                JButton boton = (JButton) tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
                switch (boton.getText()) {
                    case "Ver contrato":
                        verContratoIndividual(boton);
                        break;
                    case "Ver propiedad":
                        verPropiedadIndividual(boton);
                        break;
                    case "Ver cliente":
                        verClienteIndividual(boton);
                        break;
                    default:
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
    }
    
    //Métodos de action listeners

    @Override
    public void actionPerformed(ActionEvent eventSource
    ) {
        JComboBox comboBox = (JComboBox) eventSource.getSource();
        switch (comboBox.getActionCommand()) {
            case "tipoPropiedad":
                if (comboBox.getSelectedItem().equals("Casa")) {
                    this.vista.agregarPropiedad.inputNiveles.setVisible(true);
                    this.vista.agregarPropiedad.inputColor.setVisible(true);
                    this.vista.agregarPropiedad.inputParqueo.setVisible(true);
                    this.vista.agregarPropiedad.inputAnoConstruccion.setVisible(true);
                    this.vista.agregarPropiedad.inputFotogragía.setVisible(true);
                    this.vista.agregarPropiedad.botonFotografia.setVisible(true);

                    this.vista.agregarPropiedad.labelAnoConstruccion.setVisible(true);
                    this.vista.agregarPropiedad.labelColor.setVisible(true);
                    this.vista.agregarPropiedad.labelFotografia.setVisible(true);
                    this.vista.agregarPropiedad.labelNivel.setVisible(true);
                    this.vista.agregarPropiedad.labelParqueo.setVisible(true);
                } else {
                    this.vista.agregarPropiedad.inputNiveles.setVisible(false);
                    this.vista.agregarPropiedad.inputColor.setVisible(false);
                    this.vista.agregarPropiedad.inputParqueo.setVisible(false);
                    this.vista.agregarPropiedad.inputAnoConstruccion.setVisible(false);
                    this.vista.agregarPropiedad.inputFotogragía.setVisible(false);
                    this.vista.agregarPropiedad.botonFotografia.setVisible(false);

                    this.vista.agregarPropiedad.labelAnoConstruccion.setVisible(false);
                    this.vista.agregarPropiedad.labelColor.setVisible(false);
                    this.vista.agregarPropiedad.labelFotografia.setVisible(false);
                    this.vista.agregarPropiedad.labelNivel.setVisible(false);
                    this.vista.agregarPropiedad.labelParqueo.setVisible(false);
                }
                break;
            case "tipoContrato":
                if (comboBox.getSelectedItem().equals("Venta")) {
                    this.vista.agregarContrato.inputMantenimiento.setVisible(false);
                    this.vista.agregarContrato.labelAlquiler.setVisible(false);

                    this.vista.agregarContrato.inputComision.setVisible(true);
                    this.vista.agregarContrato.labelComision.setVisible(true);

                } else if (comboBox.getSelectedItem().equals("Alquiler")) {
                    this.vista.agregarContrato.inputMantenimiento.setVisible(true);
                    this.vista.agregarContrato.labelAlquiler.setVisible(true);

                    this.vista.agregarContrato.inputComision.setVisible(false);
                    this.vista.agregarContrato.labelComision.setVisible(false);
                }
                break;
            case "cliente":
                try {
                this.vista.agregarPagos.comboPropiedad.removeAllItems();
                this.cargarComboPropiedadCliente(this.vista.agregarPagos.comboPropiedad, comboBox.getSelectedItem().toString());
            } catch (Exception exception) {

            }
            break;
            case "propiedades":
                try {

                ContratoAlquiler contratoEncontrado = this.modelo.retornarPropiedadContrato(Integer.parseInt(this.vista.agregarPagos.comboPropiedad.getSelectedItem().toString()));

                this.vista.agregarPagos.inputAlquiler.setText(Double.toString(contratoEncontrado.getMonto()));
                this.vista.agregarPagos.inputMantenimiento.setText(Double.toString(contratoEncontrado.getCostoMantenimiento()));
                this.vista.agregarPagos.inputTotal.setText(Double.toString(contratoEncontrado.getMonto() + contratoEncontrado.getCostoMantenimiento()));

            } catch (Exception exception) {

            }
            break;
            default:
        }
    }

    //Métodos de document listener *Acciones de cambio de documento*
    @Override
    public void insertUpdate(DocumentEvent e
    ) {
        calculoComision();
    }

    @Override
    public void removeUpdate(DocumentEvent e
    ) {
        calculoComision();
    }

    @Override
    public void changedUpdate(DocumentEvent documentSource
    ) {
        calculoComision();
    }

    //Métodos de Window Listener
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent frameSource) {
        JFrame jframeFuente = (JFrame) frameSource.getSource();
        switch (jframeFuente.getClass().getSimpleName()) {
            case "VistaPropiedades":
            case "VistaUsuarios":
            case "VistaPagos":
            case "VistaMantenimientos":
            case "VistaClientes":
            case "VistaContratos":
                this.regresarAlMenu(jframeFuente);
                break;
            case "VistaAgregarPropiedad":
                this.limpiarAgregarPropiedades();
                this.accionCancelarPropiedades();
                break;
            case "VistaAgregarCliente":
                this.limpiarAgregarPropiedades();
                this.accionCancelarPropiedades();
                break;
            case "VistaAgregarContrato":
                this.limpiarAgregarContratos();
                this.accionCancelarContratos();
                break;
            case "VistaAgregarMantenimiento":
                this.limpiarAgregarMantenimientos();
                this.accionCancelarMantenimientos();
                break;
            case "VistaAgregarPago":
                this.limpiarAgregarPagos();
                this.accionCancelarPagos();
                break;
            case "VistaAgregarUsuario":
                this.limpiarAgregarUsuarios();
                this.accionCancelarUsuarios();
                break;
            case "VistaContratoIndividual":
            case "VistaPropiedadIndividual":
            case "VistaClienteIndividual":
                jframeFuente.setVisible(false);
                break;
            default:
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
