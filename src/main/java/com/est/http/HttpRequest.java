/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.http;

/**
 *
 * @author user1
 */
public class HttpRequest {
    public enum Method {
        GET,
        POST,
        PUT,
        DELETE
    }
    
    String iUrl;
    String iBody;
    Method iMethod;
    
    public HttpRequest(String aUrl) {
        iUrl = aUrl;
        iMethod = Method.GET;
        iBody = "";
    }
    
    public HttpRequest(HttpRequest aRequest) {
        iBody = aRequest.iBody.toString();
        iMethod = aRequest.iMethod;
        iUrl = aRequest.iUrl.toString();
    }
    
    public void setMethod(Method aMethod) {
        iMethod = aMethod;
    }
    
    public void setBody(String aBody) {
        iBody = aBody.toString();
    }
    
    public String getMethod() {
        if (iMethod == Method.DELETE) {
            return "DELETE";
        }
        else if (iMethod == Method.POST) {
            return "POST";
        }
        else if (iMethod == Method.PUT) {
            return "PUT";
        }
        
        return "GET";
    }
}
