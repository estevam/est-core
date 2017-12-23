
package com.est.xml;

import java.io.File;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author estevam
 */
public class TvRating {
  
    String PATH_RATING = "/com/disternet/debox/ratings";

    public TvRating() {
    }
    /**
     *   
     * @param String aRatingCountry Ex: /es_tv_ratings.xml
     * @param aRatingHex int        Ex: 12
     * @return Rating
     */
    public Rating findTVRating(String aRatingCountry, int aRatingHex) {

        String ratingHex = convertIntToHex(aRatingHex);
        System.out.println("Value: " + ratingHex);
        Rating rating = new Rating();
        try {
            URL url = getResource(aRatingCountry);
            String pathXml = url.toString();
            //pathXml = pathXml.replace("file:", "");
            //pathXml ="/home/estevam/NetBeansProjects/bld/daMpOverlay/src/main/resources/com/disternet/debox/ratings/es_tv_ratings.xml";
            File fXmlFile = new File(pathXml);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList nList = doc.getElementsByTagName("rating");
            String value;

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    value = eElement.getAttribute("value");
                    System.out.println("======");
                    System.out.println(value);
                    System.out.println(ratingHex);

                    if (ratingHex.equals(value)) {
                        rating.setMinimum_age(eElement.getElementsByTagName("minimum_age").item(0).getTextContent());
                        rating.setDisplay_text(eElement.getElementsByTagName("display_text").item(0).getTextContent());
                        rating.setDisplay_image("/"+eElement.getElementsByTagName("display_image").item(0).getTextContent());
                        rating.setType(eElement.getElementsByTagName("type").item(0).getTextContent());
                        rating.setCountry_code(eElement.getElementsByTagName("country_code").item(0).getTextContent());
                        rating.setDescription_native(eElement.getElementsByTagName("description_native").item(0).getTextContent());
                        rating.setDescription_english(eElement.getElementsByTagName("description_english").item(0).getTextContent());
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rating;
    }

    private static String convertIntToHex(int d) {
        String hex = Integer.toString(d, 16);
        if (hex.length() == 1) {
            hex = "0x0" + hex.toUpperCase();
        } else if (hex.length() == 2) {
            hex = "0x" + hex.toUpperCase();
        }
        return hex.trim();
    }
    
    private URL getResource(String aPath) {
        return getClass().getResource(PATH_RATING + aPath);
    }
    
//    Test 
//    public static void main(String args[]) {
//        TvRating f = new TvRating();
//        f.findTVRating("/es_tv_ratings.xml", 31);
//
//    }
}
