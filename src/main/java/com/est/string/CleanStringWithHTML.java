
package com.est.string;

import org.jsoup.Jsoup;

/**
 *
 * @author Estevam
 * @return return String with clean HTML using jsoup-1.6.2.jar 
 * @version version 1.0
 * @since 13 April 2012
 * 
 */

public class CleanStringWithHTML {

    public static String stripHtml(String aText)  {
           String cleanText =  Jsoup.parse(aText).text();
    return cleanText;
    }

}
