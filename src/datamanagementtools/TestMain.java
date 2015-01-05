/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanagementtools;

import tools.FileInfo;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author antman
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException, Exception {
        // TODO code application logic here
        URI remote = new URI("remote://dod_admin@172.20.16.37:22/home/dod_admin/testfile");
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
        
        FileInfo test = new FileInfo(local);
        System.out.println("Local filesize: " + test.getFileSize());
        test = new FileInfo(remote);
        System.out.println("Remote filesize: " + test.getFileSize());
        
        
    }
    
}
