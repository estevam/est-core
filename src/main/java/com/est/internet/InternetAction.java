package com.est.internet;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 *
 * @author estevam
 */
public class InternetAction {

    public static boolean iStatus;
    public static HttpURLConnection iUrlConnect;
    private static final String URL = "http://www.google.com";
    private static ArrayList<String> iNetInterface;
    private static boolean iNetInterfaceStatus = false;
    
    public static boolean checkInternetStatus() throws MalformedURLException, IOException {

        iNetInterface = new ArrayList<String>();

        // search for network interfaces and if network cable is conected - 
        // "NetworkInterface" will add interface in to the list. 

        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        int num = 0;
        while (interfaces.hasMoreElements()) {
            NetworkInterface interf = interfaces.nextElement();
            if (interf.isUp()) {
                String inter = interf.getDisplayName();
                iNetInterface.add(num, inter);
                num++;
            }
        }

        // if network cable is conected - "NetworkInterface" will add interface  
        // in to the list. 
        
        for (String x : iNetInterface) {

            if (x.toString().equals("eth0")) {
                iNetInterfaceStatus = true;
            }
            if (x.toString().equals("eth1")) {
                iNetInterfaceStatus = true;
            }
            if (x.toString().equals("eth2")) {
                iNetInterfaceStatus = true;
            }

        }

        // if network exist check internet status

        if (iNetInterfaceStatus == true) {
            try {
                URL url = new URL(URL);
                HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();

                Object objData = urlConnect.getContent();
                System.out.println(objData);
                iStatus = true;
                return iStatus;
                

            }
            catch (UnknownHostException e) {
                iStatus = false;
                return iStatus;
            }
            catch (IOException e) {
                iStatus = false;
                return iStatus;
            }

        }
        else {

            return false;
        }
    }
}
