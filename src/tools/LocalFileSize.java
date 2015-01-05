/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.File;
import java.net.URI;

/**
 *
 * @author antman
 */
public class LocalFileSize implements FileSize {
    
    private URI uri;
    private Long lastUpdate = 0L;
    private Long cacheSize = 0L;
    
    //static Integer IOAccess = 0;
    
    public LocalFileSize(URI uri)
    {
        this.uri = uri;
    }

    @Override
    public Long getFileSize() {
        Long cur = System.currentTimeMillis();
        Long diff = cur - lastUpdate;
        if ( diff >= 10L*1000L)
        {
            //System.out.println("local File Size: " + IOAccess.toString());
            //IOAccess++;
            try
            {
                String path = uri.getPath();
                if (path.length() > 0)
                    path = path.substring(1);

                File f = new File(path);
                cacheSize = f.length();
                lastUpdate = System.currentTimeMillis();
            }
            catch (Exception ex)
            {
                return 0L;
            }
        }
        return cacheSize;
    }
    
}
