/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.FileTransferQueue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author antman
 */
public class FileTransferQueueView extends JPanel {
    JTable table;
    JScrollPane scroll;
    
    
    
    public FileTransferQueueView()
    {
        super(new BorderLayout());
        buildTable();
        table.getColumnModel().getColumn(3).setCellRenderer(new ProgressCellRender());
        table.getColumnModel().getColumn(3).setCellEditor(null);
    }
    
    public JTable getTable()
    {
        return table;
    }
    
    public int getSelectedRow()
    {
        return table.getSelectedRow();
    }
       
    public void setFileTransferQueueModel(FileTransferQueueModel model)
    {
        table.setModel(model);
    }
    
    public void addListSelectionListener(ListSelectionListener listener)
    {
        table.getSelectionModel().addListSelectionListener(listener);
    }
    
    private void buildTable()
    {
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
                
        add(scroll);
        scroll.setViewportView(table);
        
        //table.setCellSelectionEnabled(false);
        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        FileTransferQueueModel model = new FileTransferQueueModel();
        setFileTransferQueueModel(model);
        
    }
 
}
