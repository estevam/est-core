package com.est.encryption;

import java.util.UUID;

/**
* @author estevam
*/
public class GUID {
    //UUID - GUID (Universally / Globally Unique IDentifier) is 
    //frequently use in programming. Some of its usage are for 
    //creating random file names, session id in web application, 
    //transaction id and for record’s primary keys in database 
    //replacing the sequence or auto generated number.    
    // Creating a random UUID (Universally unique identifier).
   public static void main(String args[]) {
       UUID uuid = UUID.randomUUID();
       String uid = uuid.toString();
       System.out.println(uid);
   }
}
