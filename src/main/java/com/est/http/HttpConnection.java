/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author estevam
 */
public class HttpConnection implements Runnable {
    private static final int TIMEOUT = 30000; // 30 seconds
    private int iTimeout = TIMEOUT;
    @SuppressWarnings("unused")
	private HttpConnectionDelegate iDelegate;
    private HttpRequest iRequest;
    private Thread iThread;
    
    public enum ResponseDataType {
        Text,
        Binary
    }
    
    public enum Status {
        Pending,
        InProgress,
        Failed,
    }
     
    public HttpConnection(HttpRequest aRequest, 
            HttpConnectionDelegate aDelegate) {
        iRequest = new HttpRequest(aRequest);
        iDelegate = aDelegate;
    }
    
    public synchronized Status start() {
        if (iThread != null) {
            return Status.InProgress;
        }
        
        iThread = new Thread(this);
        iThread.start();
        
        return Status.InProgress;
    }
    
    public synchronized void cancel() {
        if (iThread == null) {
            return;
        }
        
        iThread = null;
    }
    
    String request() throws IOException {
        String rStr;

        URL url = new URL(iRequest.iUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setDoOutput(true);
        conn.setRequestMethod(iRequest.getMethod());
        conn.setRequestProperty("User-Agent",
                "MHG HttpConnection");
        conn.setConnectTimeout(iTimeout);
        if (iRequest.iMethod == HttpRequest.Method.DELETE
                || iRequest.iMethod == HttpRequest.Method.GET) {
        }
        else {
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            OutputStreamWriter wr =
                    new OutputStreamWriter(conn.getOutputStream());
            wr.write(iRequest.iBody, 0, iRequest.iBody.length());
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

        return rStr;
    }
    
    @Override
    public void run() {
        Thread me = Thread.currentThread();
        @SuppressWarnings("unused")
		boolean hasError = false;
        
        
        @SuppressWarnings("unused")
		String result = "";
        try {
            result = request();
        }
        catch (IOException ex) {
            hasError = true;
        }

        synchronized (this) {
            if (me != iThread) {
                return;
            }
        
            iThread = null;
        }    
    }
}
