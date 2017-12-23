/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.absolute_path;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author estevam
 */
public class TestStreams {

    public String ROOT_URL_PACKAGE ="/com/est/absolute_path";
    
    public static void main(String args[]) throws IOException {
       
       // System.out.println(t.getPath());
    
    }
    
    /**
     * deve colocar o "/" na string. Ex: "/picture.png"
     * @param aPath
     * @return 
     */
    public URL getAbsolutPath(String aPath){
        return getClass().getResource(ROOT_URL_PACKAGE + aPath);    
    }

    public String getPath(){
          return getClass().getResource("").toString();
    }
    
    public String getAbsolutPathString(String aPackagePath, String aFilename) {
        File file = new File(new File("").getAbsolutePath() + aPackagePath + aFilename);
        return file.toString();
    }

    public File getAbsolutPathFile(String aPackagePath, String aFilename) {
        File file = new File(new File("").getAbsolutePath() + aPackagePath + aFilename);
        System.out.println(file.toString());
        return file;
    }
   
}
