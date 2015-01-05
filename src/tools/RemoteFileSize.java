/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.net.URI;
import java.util.Random;

/**
 *
 * @author antman
 */
public class RemoteFileSize implements FileSize {

    private URI uri;
    private Random rand;
    //private static Integer IOAccess = 0;
    private Long cacheSize = 0L;
    private Long lastUpdate = 0L;
    
    
    public RemoteFileSize(URI uri)
    {
        this.uri = uri;
        rand = new Random(System.currentTimeMillis());
    }
    
    @Override
    public Long getFileSize() {
        Long cur = System.currentTimeMillis();
        Long diff = cur - lastUpdate;
        if ( diff >= 10L*1000L)
        {
            //return (long)(10000F * rand.nextFloat() + 5000);
            //System.out.println("Remote File Size: " + IOAccess.toString());
            //IOAccess++;
            cacheSize += (long)(rand.nextFloat() * 10000F);
            lastUpdate = System.currentTimeMillis();
        }
        
        return cacheSize;
    }
    
}
