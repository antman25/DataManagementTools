/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.FileTransferQueue;

import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author antman
 */
public class FileTransferQueueController {
    private FileTransferQueueView view = new FileTransferQueueView();
    private FileTransferQueueModel model = new FileTransferQueueModel();
    //private FileTransferQueueSelectionHandler handlerSelection = new FileTransferQueueSelectionHandler();
    FileTransferQueueItem current;
    
    public FileTransferQueueController()
    {
        init();
    }

    public FileTransferQueueController(FileTransferQueueView view)
    {
        this.view = view;
        init();
    }
    
    public void init()
    {
        view.setFileTransferQueueModel(model);
        view.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                Object s = e.getSource();
                //DefaultListSelectionModel selectionModel = (DefaultListSelectionModel)s;
                if (e.getValueIsAdjusting()) 
                {
                    FileTransferQueueItem selected = (FileTransferQueueItem)getSelectedItem();
                    
                    if (selected != current)
                    {
                        System.out.println("Selection changed: " + selected.toString());
                    }
                    
                    current = selected;
                }
            }
        });
        view.getTable().getColumnModel().getColumn(3).setCellRenderer(new ProgressCellRender());
    }
    
    public Object getSelectedItem() 
    {
        //return view.gets
        int row = view.getSelectedRow();
        FileTransferQueueItem item = model.getRowData(row);
        return item;
    }
    
    public void setSelectedItem(Object value)
    {
        
    }
    
    public void addFileTransferQueueItem(FileTransferQueueItem item)
    {
        model.addQueueItem(item);
    }
    
}
