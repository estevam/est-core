
package com.est.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Estevam
 * @return return IP from box developer and user (Estevam) token 
 * @version version 1.0
 * @since 13 April 2012
 * 
 */

public class UIConfig {

    private static final String PROP = "/opt/disternet/uiconfig/uiconf.properties";
   
    public static String getValue(String aKey, String aDefault) {
        Properties prop = new Properties();
        
        String value;
        try {
            FileInputStream in = new FileInputStream(PROP);
            prop.load(in);
            value = prop.getProperty(aKey);
            in.close();
        } catch (IOException ex) {
            value = aDefault;
        }
        
        return value;
    }
    
}

