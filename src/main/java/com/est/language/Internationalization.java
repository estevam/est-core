
package com.est.language;


import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
public class Internationalization {
    
    
    private static String languageCountry;
    

    public static void main(String[] args) throws IOException {

        
        System.out.println("===================Internationalization===================");
        System.out.println("");
        Locale targetFrance = new Locale("fr", "FR"); // French language, French region
        ResourceBundle franceBundle = ResourceBundle.getBundle("com.est.language.Language", targetFrance);
        System.out.println("Language in " + targetFrance + ": " + franceBundle.getString("greeting"));

        Locale targetSpain = new Locale("es", "ES"); // French language, French region
        ResourceBundle spainBundle = ResourceBundle.getBundle("com.est.language.Language", targetSpain);
        System.out.println("Language in " + targetSpain + ": " + spainBundle.getString("greeting"));
        
        Locale.setDefault(new Locale("en", "EN"));
        ResourceBundle bundle = ResourceBundle.getBundle("com.est.language.LanguageDefault");
        System.out.println("Language Default " + Locale.getDefault() + ": " + bundle.getString("greeting"));
        
        System.out.println("");
        System.out.println("===========================================================");
        

    }
    
    public String getCurrentLanguageCountry(){

     return languageCountry;
    }
    
      
}
