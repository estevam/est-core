
package com.est.rest.client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author Estevam
 */
@SuppressWarnings("deprecation")
public class HttpActionSimples {
    
    static public String put(String aUrl, String aData) {
        return request("PUT", aUrl, aData);
    }
    
    static public String delete(String aUrl) {
        return request("DELETE", aUrl, "");
    }
    
    static public String post(String aUrl, String aData) {
        return request("POST", aUrl, aData);
    }
    
    static public String get(String aUrl) {
        return request("GET", aUrl, "");
    }
    
    @SuppressWarnings({ "resource" })
	static public boolean checkHTTPstatus(String aUrl) {
        HttpResponse response = null;
        HttpGet getRequest = new HttpGet(aUrl);
        getRequest.addHeader("accept", "application/json");
        
        try {
            response = new DefaultHttpClient().execute(getRequest);
        } catch (IOException ex) {
            Logger.getLogger(HttpActionSimples.class.getName()).log(Level.SEVERE, ex.toString());
        }

        if (response.getStatusLine().getStatusCode() != 200) {
            System.out.println("Failed -> HTTP error code : " + response.getStatusLine().getStatusCode());
            return false;
        } else {
            System.out.println("HTTP response successfully :)");
            return true;
        }
    }

    static public String request(String aAction, String aUrlString, String aData) {
        String rStr;
        try {
            URL url = new URL(aUrlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           
            conn.setDoOutput(true);
            conn.setRequestMethod(aAction);
            conn.setConnectTimeout(3000);
            conn.setRequestProperty("User-Agent", "com.estevam.service");
            
            
            if (aAction.equals("DELETE") || aAction.equals("GET")) {
                
            }
            else {
                conn.setRequestProperty("Accept", "*/*");
                conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
                OutputStreamWriter wr = 
                        new OutputStreamWriter(conn.getOutputStream());
                wr.write(aData, 0, aData.length());
                wr.flush();
                wr.close();
            }
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    (InputStream) conn.getContent()));
            rStr = new String();
            
            String str;
            while (((str = rd.readLine())) != null) {
                rStr = rStr.concat(str);
            }
            rd.close();
        }
        catch (IOException e) {
            rStr = "";
        }
        
        return rStr;
    }
}
