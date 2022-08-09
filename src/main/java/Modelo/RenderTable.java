package Modelo;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Grupo Técnicas de Programación
 */
public class RenderTable extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object objetoRenderizable, boolean isSelected, boolean hasFocus, int row, int column) {
        if (objetoRenderizable instanceof JButton) {
            return (JButton) objetoRenderizable;
        }
        return super.getTableCellRendererComponent(table, objetoRenderizable, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
