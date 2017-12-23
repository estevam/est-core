
 
package com.est.db;

/**
 *
 * @author estevam
 */
@SuppressWarnings("serial")
public class ConnectionDbException extends Exception  {
    
    public ConnectionDbException() {
    }
    
    public ConnectionDbException(String arg) {
        super(arg);
    }
    
    public ConnectionDbException(Throwable arg) {
        super(arg);
    }
    
    public ConnectionDbException(String arg, Throwable arg1) {
        super(arg, arg1);
    }
}