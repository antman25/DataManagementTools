/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.FileTransferQueue;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ANTMAN
 */
public class ProgressCellRender extends JProgressBar implements TableCellRenderer {

    /*@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public ProgressCellRender()
    {
        super();
        setStringPainted(true);
        //setForeground(Color.blue);
        
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int progress = 0;
            if (value instanceof Float) {
                progress = Math.round(((Float) value) * 100f);
            } else if (value instanceof Integer) {
                progress = (int) value;
            }
            setValue(progress);
            return this;
    }
    
    
}
