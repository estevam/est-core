package com.est.xml.jaxb;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author estevam
 */

@XmlRootElement(name = "document")
public class RatingListMaker {
    
    public ArrayList<Rating> iRatingList;
    
    @XmlElement(name = "rating")
    public void setRatingList(ArrayList<Rating> ratingList) {
          iRatingList = ratingList;
    }

    public ArrayList<Rating> getRatingList() {
        return iRatingList;
    }
}

