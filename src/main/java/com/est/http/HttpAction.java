/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jeremy Hsu
 */
public class HttpAction{
   
    static public class HttpStatus {

        private int iResponseCode;
        private String iContent = new String();
        private boolean iSuccess;

        HttpStatus(int responseCode, String content, boolean aSuccess) {
            iResponseCode = responseCode;
            iContent = content;
            iSuccess = aSuccess;
        }
       
        public int getResponseCode() {
            return iResponseCode;
        }

        public String getContent() {
            return iContent;
        }
        
        public boolean isSuccuess() {
            return iSuccess;
        }
    }

    static public String put(String url, String data) {
        HttpStatus status = request("PUT", url, data);
        return status.getContent();
    }

    static public String delete(String url) {
        HttpStatus status = request("DELETE", url, "");
        return status.getContent();
    }

    static public String post(String url, String data) {
        HttpStatus status = request("POST", url, data);
        return status.getContent();
    }

    static public String get(String url) {
        HttpStatus status = request("GET", url, "");
        if (!status.isSuccuess()) {
            return "";
        }
        
        return status.getContent();
    }
    
    static public HttpStatus request(
            String Action, String urlString,
            String data) {
        System.out.println("URL String::" + urlString);
        boolean isSuccess = false;
        int responseCode = 0;
        String rStr;
        HttpURLConnection conn = null;
        
        try {
            if (urlString.startsWith("http:")) {
                URL url = new URL(urlString);
                conn = (HttpURLConnection) url.openConnection();
            } else if(urlString.startsWith("https:")) {
                //Trust all Certificate SSL
                SSLTrustManager trustManager = new SSLTrustManager();
                conn = trustManager.addTrustAllCertificate(urlString);
            }
            
            String user_agent = "com.est.http";
          
            conn.setReadTimeout(60000);    
            conn.setConnectTimeout(3000);
            conn.setDoOutput(true);
            conn.setRequestMethod(Action);
            conn.setRequestProperty("User-Agent", user_agent);
            
            if (Action.equals("DELETE") || Action.equals("GET")) {
            } else {
                conn.setRequestProperty("Accept", "*/*");
                conn.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded");
                OutputStreamWriter wr =
                        new OutputStreamWriter(conn.getOutputStream());
                wr.write(data, 0, data.length());
                wr.flush();
                wr.close();
            }

            responseCode = conn.getResponseCode();
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    (InputStream) conn.getContent()));
            rStr = new String();

            String str;
            while (((str = rd.readLine())) != null) {
                rStr = rStr.concat(str);
            }
            rd.close();
            isSuccess = true;
        } catch (SocketTimeoutException e) {
            responseCode = HttpURLConnection.HTTP_CLIENT_TIMEOUT;
            rStr = "";
        } catch (IOException e) {
            rStr = "";
            if (conn != null) {
                InputStream input = (InputStream) conn.getErrorStream();
                if (input == null) {
                    responseCode = -1;
                    return new HttpStatus(responseCode, rStr, isSuccess);
                }
                
                BufferedReader rd = new BufferedReader(
                        new InputStreamReader(input));
                String str;
                //String errorStr = new String();
                try {
                    responseCode = conn.getResponseCode();
                    while (((str = rd.readLine())) != null) {
                        rStr = rStr.concat(str);
                    }

                    rd.close();
                    Logger.getLogger(HttpAction.class.getName()).log(Level.INFO,
                            "Http Error({0} {1}): {2}", new Object[] 
                            {Action, urlString, responseCode});

                } 
                catch (IOException ex) {
                    Logger.getLogger(HttpAction.class.getName()).log(Level.SEVERE, 
                            ex.toString());
                }
            }
        }

        return new HttpStatus(responseCode, rStr, isSuccess);
    }
}
