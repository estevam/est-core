package com.est.string;

/**
 *
 * @author Estevam
 * @return encode uri
 * @version version 1.0
 * @since 13 April 2012
 * 
 * 
 
The encodeURI() function is used to encode a URI.
This function encodes special characters, except: , / ? : @ & = + $ #

 */

public class URIEncoder {
 
    private static String mark = "-_.!~*'()\"";
 
    public static String encodeURI(String argString) {
        
        StringBuilder uri = new StringBuilder();        
        char[] chars = argString.toCharArray();
        
        for(int i = 0; i<chars.length; i++) {
            char c = chars[i];
            if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') || mark.indexOf(c) != -1) {
                uri.append(c);
            }
            else {
                uri.append("%");
                uri.append(Integer.toHexString((int)c));
            }
        }
        return uri.toString();
    }
}
