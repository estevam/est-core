package com.est.xml.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author estevam
 */

@XmlRootElement
public class Rating {

    private String iValue;
    private int iMinimum_age;
    private String iDisplay_text;
    private String iDisplay_image;
    private String iType;
    private String iCountry_code;
    private String iDescription_native;
    private String iDescription_english;
    private boolean iCanLock;
    private List<String>iBlock;
    
    public String getValue() {
        return iValue;
    }
    
    @XmlAttribute // get the value at tag rating
    public void setValue(String value) {
        this.iValue = value;
    }

    public int getMinimum_age() {
        return iMinimum_age;
    }

    @XmlElement(name = "minimum_age")
    public void setMinimum_age(String minimum_age) {
        this.iMinimum_age = Integer.parseInt(minimum_age);
    }

    public String getDisplay_text() {
        return iDisplay_text;
    }

    @XmlElement(name = "display_text")
    public void setDisplay_text(String display_text) {
        this.iDisplay_text = display_text;
    }

    public String getDisplay_image() {
        return iDisplay_image;
    }

    @XmlElement(name = "display_image")
    public void setDisplay_image(String display_image) {
        this.iDisplay_image = display_image;
    }

    public String getType() {
        return iType;
    }

    @XmlElement(name = "type")
    public void setType(String type) {
        this.iType = type;
    }

    public String getCountry_code() {
        return iCountry_code;
    }

    @XmlElement(name = "country_code")
    public void setCountry_code(String country_code) {
        this.iCountry_code = country_code;
    }

    public String getDescription_native() {
        return iDescription_native;
    }

    @XmlElement(name = "description_native")
    public void setDescription_native(String description_native) {
        this.iDescription_native = description_native;
    }

    public String getDescription_english() {
        return iDescription_english;
    }

    @XmlElement(name = "description_english")
    public void setDescription_english(String description_english) {
        this.iDescription_english = description_english;
    }

    public boolean getCanLock() {
        return iCanLock;
    }

    @XmlElement(name = "can_lock")
    public void setCanLock(boolean aCanLock) {
        iCanLock = aCanLock;
    }
    
    public List<String> getBlock() {
        return iBlock;
    }

    @XmlElementWrapper(name="block_list")
    @XmlElement(name="item")
    public void setBlock(List<String> block) {
        this.iBlock = block;
    }
}

