/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.http;

/**
 *
 * @author Jeremy Hsu
 */
public interface HttpConnectionDelegate {
    public void onHttpClientRequestComplete(HttpConnection aClient, 
                HttpConnection.ResponseDataType aType, String aData);
        public void onHttpClientRequestFailed(HttpConnection aClient);
}
