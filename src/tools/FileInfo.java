/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author antman
 */
public class FileInfo {
    
    private URI uri;
    private FileSize size;
    private Boolean local;
    
    public FileInfo(URI uri) throws Exception
    {
        this.uri = uri;
        
        local = true;
        if (uri.getScheme().compareToIgnoreCase("local") == 0)
        {
            local = true;
            size = new LocalFileSize(uri);
        }
        else if (uri.getScheme().compareToIgnoreCase("remote") == 0)
        {
            local = false;
            size = new RemoteFileSize(uri);
        }
        else
        {
            throw new Exception("Invalid location: " + uri.toString());            
        }
    }
    
    public Boolean isLocal() 
    {
        return local;
    }
    
    public String getFileSource()
    {
        return uri.getAuthority();
    }
    
    public String getFullURI()
    {
        return uri.toString();
    }
    
    public String getFilePath()
    {
        String prePath = uri.getPath();
        if (prePath.length() > 0)
            return prePath.substring(1);
        return "";
    }
            
    public String getFileName()
    {
        String []split = getFilePath().split("/");
        if (split.length > 0)
        {
            return split[split.length-1];
        }
        return null;
    }
    public Long getFileSize()
    {
        if (isLocal() == true)
        {
            return size.getFileSize();
        }
        else
        {
            return size.getFileSize();
        }
    }
}
