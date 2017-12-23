
package com.est.file;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author estevam
 */
public class FileTest {

    File file = new File("/home/estevam/pic.png");
    boolean exists = file.exists();

    public void fileCheck() {
        if (exists) {
            System.out.println("file  exist");
        } else {
            System.out.println("file not exist");
        }
    }
    public void actionFile(){
        
       @SuppressWarnings("unused")
	boolean status = file.delete();
       @SuppressWarnings("unused")
	boolean createDiretorio = file.mkdir();

    }
    
    public void openFile() throws MalformedURLException{
      // load image in folder  
      String img  ="/home/estevam/images/pic.png";  
      @SuppressWarnings("unused")
	URL url = (new File(img)).toURI().toURL();
      
      // load image in package resource
      url = getClass().getResource(img);
    }
    
    public static void main(String[] args){
    
    }
}
