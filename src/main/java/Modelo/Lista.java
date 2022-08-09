package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josué Moraga
 * @param <V>
 */

public class Lista<V> {
    private List lista;

    public Lista() {
        this.lista = new ArrayList<V>();
    }

    public Lista(List<V> lista) {
        this.lista = lista;
    }

    public void agregar(V nuevoObjeto) {
        this.getLista().add(nuevoObjeto);
    }

    @Override
    public String toString() {

        String r = "";
        for (Object objeto : this.lista) {
            String objetoTexto = objeto.toString();
            r += objetoTexto;
            r += "\n";
        }

        return this.lista.toString();
    }

    /**
     * @return the lista
     */
    public List getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List lista) {
        this.lista = lista;
    }
    
    public void borrarTodo()
    {
        lista.removeAll(lista);
    }

}
