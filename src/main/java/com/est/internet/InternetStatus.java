/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.internet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 *
 * @author estevam
 */
public class InternetStatus {
    
  
    /**
     * old code take to long for get connection response 
     * 
     * @throws MalformedURLException
     * @throws IOException
     * @return boolean
     */
    public static boolean checkInternetStatus() throws MalformedURLException, IOException {
        
       try {
 
           URL url = new URL("http://www.google.com");
 
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
   
            if(urlConnect.getConnectTimeout() == 0){
              return false;  
            }else{
              return true;
            }
        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
    
    
    /**
     * old code take to long for get connection response 
     * 
     * @throws MalformedURLException
     * @throws IOException
     * @return boolean
     */
    public static boolean checkInternetStatus_OLD() throws MalformedURLException, IOException {
        
       try {
            //make a URL to a known source
            URL url = new URL("http://www.google.com");
            //open a connection to that source
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            //trying to retrieve data from the source. If there
            //is no connection, this line will fail
            System.out.println(urlConnect);
            return true;
            
        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

}
