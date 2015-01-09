/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanagementtools;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import tools.FileInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author antman
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    
    private static void  testURL(String urlString) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {
        URL url = new URL(urlString);
        System.out.println("URL is: " + url.toString());

        URI uri = url.toURI();
        System.out.println("URI is: " + uri.toString());

        if(uri.getAuthority() != null && uri.getAuthority().length() > 0) {
            // Hack for UNC Path
            uri = (new URL("file://" + urlString.substring("file:".length()))).toURI();
        }

        File file = new File(uri);
        System.out.println("File is: " + file.toString());

        String parent = file.getParent();
        System.out.println("Parent is: " + parent);

        System.out.println("____________________________________________________________");
    }
    public static void main(String[] args) throws URISyntaxException, Exception {
        // TODO code application logic here
        URI remote = new URI("remote://dod_admin@xxx.xxx.xxx.xxx:22/home/dod_admin/testfile");
        URI local = new URI("local:/X:/test.txt");
        /*System.out.println("Scheme: " + remote.getScheme());
        System.out.println("Auth: " + remote.getAuthority());
        System.out.println("Path: " + remote.getPath());
        System.out.println("Userinfo: " + remote.getUserInfo());
        System.out.println("host: " + remote.getHost());
        System.out.println("Port: " + remote.getPort());*/
        
        
        
        
        /*System.out.println("Scheme: " + local.getScheme());
        System.out.println("Auth: " + local.getAuthority());
        System.out.println("Path: " + local.getPath());
        System.out.println("Userinfo: " + local.getUserInfo());
        System.out.println("host: " + local.getHost());
        System.out.println("Port: " + local.getPort());*/
        
        
        try
        {
            testURL("file:///Z:/dir/file.txt");
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
            //System.out.println("URL: " + testURL.toString());
        
        
        FileInfo test = new FileInfo(local);
        System.out.println("Local filesize: " + test.getFileSize());
        test = new FileInfo(remote);
        System.out.println("Remote filesize: " + test.getFileSize());
        
        
    }
    
}
