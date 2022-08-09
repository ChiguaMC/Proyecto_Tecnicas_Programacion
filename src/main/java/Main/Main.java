package Main;

import Control.Control;
import Vista.Vista;


/**
 *
 * @author Chigua
 */
public class Main {

    public static void main(String[] args) {
        Vista vista = new Vista();
        Control control = new Control(vista);
        control.controlar();
    }
}
