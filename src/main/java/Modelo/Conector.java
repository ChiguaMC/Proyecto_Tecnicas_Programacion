package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Josué Moraga Campos
 */
public class Conector {

    public void escribirXMLCasas(List<Casa> lista, String ruta)
            throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        File archivo = new File(ruta);
        writer = new BufferedWriter(new FileWriter(archivo));
        context = JAXBContext.newInstance(ListaCasas.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new ListaCasas(lista), writer);
        writer.close();
    }

    public void escribirXMLUsuarios(List<Usuario> lista, String ruta)
            throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        File archivo = new File(ruta);
        writer = new BufferedWriter(new FileWriter(archivo));
        context = JAXBContext.newInstance(ListaUsuarios.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new ListaUsuarios(lista), writer);
        writer.close();
    }

    public void escribirXMLPagos(List<Pago> lista, String ruta)
            throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        File archivo = new File(ruta);
        writer = new BufferedWriter(new FileWriter(archivo));
        context = JAXBContext.newInstance(ListaPagos.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new ListaPagos(lista), writer);
        writer.close();
    }

    public void escribirXMLMantenimientos(List<Mantenimiento> lista, String ruta)
            throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        File archivo = new File(ruta);
        writer = new BufferedWriter(new FileWriter(archivo));
        context = JAXBContext.newInstance(ListaMantenimientos.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new ListaMantenimientos(lista), writer);
        writer.close();
    }

    public void escribirXMLClientes(List<Cliente> lista, String ruta)
            throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        File archivo = new File(ruta);
        writer = new BufferedWriter(new FileWriter(archivo));
        context = JAXBContext.newInstance(ListaClientes.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new ListaClientes(lista), writer);
        writer.close();
    }

    public void escribirXMLContratosAlquiler(List<ContratoAlquiler> lista, String ruta)
            throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        File archivo = new File(ruta);
        writer = new BufferedWriter(new FileWriter(archivo));
        context = JAXBContext.newInstance(ListaContratosAlquiler.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new ListaContratosAlquiler(lista), writer);
        writer.close();
    }

    public void escribirXMLContratosVenta(List<ContratoVenta> lista, String ruta)
            throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        File archivo = new File(ruta);
        writer = new BufferedWriter(new FileWriter(archivo));
        context = JAXBContext.newInstance(ListaContratosVenta.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new ListaContratosVenta(lista), writer);
        writer.close();
    }

    public void leerPropiedades(List<Propiedad> lista, String ruta) throws JAXBException {
        ListaCasas listaCasas = new ListaCasas();

        JAXBContext context = JAXBContext.newInstance(ListaCasas.class);
        Unmarshaller um = context.createUnmarshaller();
        listaCasas = (ListaCasas) um.unmarshal(new File(ruta));

        for (Casa casa : listaCasas.getCasas()) {
            lista.add(casa);
        }
    }

    public void leerUsuarios(List<Usuario> lista, String ruta) throws JAXBException {
        ListaUsuarios listaUsuarios = new ListaUsuarios();

        JAXBContext context = JAXBContext.newInstance(ListaUsuarios.class);
        Unmarshaller um = context.createUnmarshaller();
        listaUsuarios = (ListaUsuarios) um.unmarshal(new File(ruta));

        for (Usuario usuario : listaUsuarios.getUsuarios()) {
            lista.add(usuario);
        }
    }

    public void leerPagos(List<Pago> lista, String ruta) throws JAXBException {
        ListaPagos listaPagos = new ListaPagos();

        JAXBContext context = JAXBContext.newInstance(ListaPagos.class);
        Unmarshaller um = context.createUnmarshaller();
        listaPagos = (ListaPagos) um.unmarshal(new File(ruta));

        for (Pago pago : listaPagos.getPagos()) {
            lista.add(pago);
        }
    }

    public void leerMantenimientos(List<Mantenimiento> lista, String ruta) throws JAXBException {
        ListaMantenimientos listaMantenimientos = new ListaMantenimientos();

        JAXBContext context = JAXBContext.newInstance(ListaMantenimientos.class);
        Unmarshaller um = context.createUnmarshaller();
        listaMantenimientos = (ListaMantenimientos) um.unmarshal(new File(ruta));

        for (Mantenimiento mantenimiento : listaMantenimientos.getMantenimientos()) {
            lista.add(mantenimiento);
        }
    }

    public void leerClientes(List<Cliente> lista, String ruta) throws JAXBException {
        ListaClientes listaClientes = new ListaClientes();

        JAXBContext context = JAXBContext.newInstance(ListaClientes.class);
        Unmarshaller um = context.createUnmarshaller();
        listaClientes = (ListaClientes) um.unmarshal(new File(ruta));

        for (Cliente cliente : listaClientes.getClientes()) {
            lista.add(cliente);
        }
    }
    public void leerContratoAlquiler(List<Contrato> lista, String ruta) throws JAXBException {
        ListaContratosAlquiler listaContratosAlquiler = new ListaContratosAlquiler();

        JAXBContext context = JAXBContext.newInstance(ListaContratosAlquiler.class);
        Unmarshaller um = context.createUnmarshaller();
        listaContratosAlquiler = (ListaContratosAlquiler) um.unmarshal(new File(ruta));

        for (ContratoAlquiler contratoAlquiler : listaContratosAlquiler.getContratoAlquilers()) {
            lista.add(contratoAlquiler);
        }
    }
    
        public void leerContratoVenta(List<Contrato> lista, String ruta) throws JAXBException {
        ListaContratosVenta listaContratosVenta = new ListaContratosVenta();

        JAXBContext context = JAXBContext.newInstance(ListaContratosVenta.class);
        Unmarshaller um = context.createUnmarshaller();
        listaContratosVenta = (ListaContratosVenta) um.unmarshal(new File(ruta));

        for (ContratoVenta contratoVenta : listaContratosVenta.getContratoVentas()) {
            lista.add(contratoVenta);
        }
    }
}
