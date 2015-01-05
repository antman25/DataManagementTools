/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.FileTransferQueue;

import tools.FileInfo;
import java.net.URI;

/**
 *
 * @author antman
 */
public class FileTransferQueueItem extends Object{
    FileInfo infoSource;
    FileInfo infoDestination;
    String status;
    
    public FileTransferQueueItem(URI source, URI destination)
    {
        try
        {
            infoSource = new FileInfo(source);
            infoDestination = new FileInfo(destination);
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }    
    }
    
    @Override
    public String toString()
    {
        return getSourceFileInfo().getFullURI() + " --> " + getDestinationFileInfo().getFullURI();
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    
    public Float getProgress()
    {
        Long sourceSize = infoSource.getFileSize();
        if (sourceSize != 0)
            return (float)infoDestination.getFileSize() / infoSource.getFileSize();
        return 0F;
    }
    
    public FileInfo getSourceFileInfo()
    {
        return infoSource;
    }
    
    public FileInfo getDestinationFileInfo()
    {
        return infoDestination;
    }
    
    public Long getSourceFileSize()
    {
        return infoSource.getFileSize();
    }
    
    public Long getRemoteFileSize()
    {
        return infoDestination.getFileSize();
    }
    
    public void setSourceURI(URI source)
    {
        try
        {
            infoSource = new FileInfo(source);
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
    
    public void setDestinationURI(URI destination)
    {
        try
        {
            infoDestination = new FileInfo(destination);
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
