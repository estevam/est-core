/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.validate;

/**
 *
 * @author estevam
 */
public class Validate {
    
    public static void main(String[] args) {
     
    }

    // validate URL
    public static boolean validateUrl(String aUrl) {
        String urlPattern = "^http(s{0,1})://[a-zA-Z0-9_/\\-\\.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/\\&\\?\\=\\-\\.\\~\\%]*";
        return aUrl.matches(urlPattern);
    }

    // validate email
    public static boolean validateEmail(String aEmail) {
        String emailPattern = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})";
        return aEmail.matches(emailPattern);
    }

    public static String validateString(String aItem){
        if(aItem == null){
            aItem="";
        }
        return aItem;
    }
    
    public static boolean validateStringBoolean(String aItem){
        if(aItem == null || aItem.isEmpty()){
            return true;
        }
        return false;
    }
    
    public static boolean validatePhoneNumber(String aItem) {
        if (aItem == null) {
            aItem = "";
        }
        String phoneNumber = "\\d{3}-\\d{7}";// format 000-0000000
        //                   "\\d{3}-\\d{3}-\\d{4}";// format 000-000-0000
        return aItem.matches(phoneNumber);
    }

    
    public static boolean validateZipCode(String aItem) {

        if (aItem == null) {
            aItem = "";
        }
        
        String zipCodePattern = "^[ABCEGHJKLMNPRSTVXY]{1}\\d{1}[A-Z]{1} *\\d{1}[A-Z]{1}\\d{1}$";
        System.out.println("test:"+ aItem.matches(zipCodePattern));
        return aItem.matches(zipCodePattern);
              
//    ^[ABCEGHJKLMNPRSTVXY]{1}\d{1}[A-Z]{1} *\d{1}[A-Z]{1}\d{1}$
//    Matches Canadian PostalCode formats with or without spaces (e.g., "T2X 1V4" or "T2X1V4")
//
//    ^\d{5}(-\d{4})?$
//    Matches all US format zip code formats (e.g., "94105-0011" or "94105") 
//
//    (^\d{5}(-\d{4})?$)|(^[ABCEGHJKLMNPRSTVXY]{1}\d{1}[A-Z]{1} *\d{1}[A-Z]{1}\d{1}$)
//    Matches US or Canadian zip codes in above formats.
 
    }
   
}
