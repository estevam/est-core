package com.est.xml.jaxb;


import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * @author estevam
 */
public class TvRating {

    private static final HashMap<Integer, Rating> iRatingMap;
    public static String ROOT_URL_PACKAGE ="/src/com/est/xml/jaxb/rating.xml";
    
    public TvRating() {
    }
    static {

        iRatingMap = new HashMap<Integer, Rating>();
        System.out.println(xmlPath());
        
        System.out.println(xmlPath());
        File file = new File(xmlPath());
        System.out.println(file.exists());
        JAXBContext jaxbContext = null;
        Unmarshaller jaxbUnmarshaller = null;
        RatingListMaker ratingListMaker = null;

        try {
            jaxbContext = JAXBContext.newInstance(RatingListMaker.class);
            jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ratingListMaker = (RatingListMaker) jaxbUnmarshaller.unmarshal(file);
        }
        catch (JAXBException ex) {
            Logger.getLogger(TvRating.class.getName()).log(Level.SEVERE, ex.toString());
        }

        if (ratingListMaker != null) {

            ArrayList<Rating> ratingList = ratingListMaker.getRatingList();
            Integer ratingValue;
            for (Rating rating : ratingList) {
                ratingValue = Integer.decode(rating.getValue());
                iRatingMap.put(ratingValue, rating);
            }
        }
    }

    /**
     * FindTVRating
     * @param aRatingFromEpg aRatingHex int Ex: 12
     * @return Rating
     */
    public Rating findTVRating(int aRatingFromEpg) {

        if (!iRatingMap.containsKey(aRatingFromEpg)) {
            return new Rating();
        }

        return iRatingMap.get(aRatingFromEpg);
    }

    public Collection<Rating> getTvRatingCollection() {
        return iRatingMap.values();
    }

    
    public static String xmlPath() {
        File file = new File(new File("").getAbsolutePath() +ROOT_URL_PACKAGE);
        return file.toString();
    }
}



