/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.FileTransferQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author antman
 */
public class FileTransferQueueModel extends AbstractTableModel {
    List items;
    
    private final int COL_SOURCE_URI = 0;
    private final int COL_DEST_URI = 1;
    private final int COL_SIZE = 2;
    private final int COL_PROGRESS = 3;
    private final int COL_STATUS = 4;
    private final int COL_TOTAL = 5;
    
    
    public FileTransferQueueModel()
    {
        super();
        items = new LinkedList<>();
    }
    
    @Override
    public String getColumnName(int columnIndex)
    {
        switch (columnIndex)
        {
            case COL_SOURCE_URI:
                return "Source";
                
            case COL_DEST_URI:
                return "Destination";
            case COL_SIZE:    
                return "Size [MB]";
            case COL_PROGRESS:
                return "Progress";
            
            case COL_STATUS:
                return "Status";
        }
        return null;     
    }
    

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return COL_TOTAL;
    }
    
    public FileTransferQueueItem getRowData(int rowIndex)
    {
        return (FileTransferQueueItem) items.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FileTransferQueueItem item = (FileTransferQueueItem) items.get(rowIndex);
        if (item == null)
            return "#ERROR#";
        switch (columnIndex)
        {
            case COL_SOURCE_URI:
                return item.getSourceFileInfo().getFullURI();
                
            case COL_DEST_URI:
                return item.getDestinationFileInfo().getFullURI();
            case COL_SIZE:
                return String.format("%.3f", (double)item.getSourceFileSize() / 1048576.0);
            case COL_PROGRESS:
                return item.getProgress();
            case COL_STATUS:
                return item.getStatus();
                
        }
        return null;
    }
    
    
    
    public void addQueueItem(FileTransferQueueItem item)
    {
        int rowCount = getRowCount();
        items.add(item);
        //fireTableRowsUpdated(items.size()-1, items.size()-1);
        fireTableRowsInserted(rowCount, rowCount);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex)
        {
            case COL_PROGRESS:
                return true;
        }
        return false;
    }
    
    
}
