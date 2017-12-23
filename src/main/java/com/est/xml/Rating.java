/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.xml;

/**
 *
 * @author estevam
 */
public class Rating {
      public String Minimum_age;
      public String Display_text;
      public String Display_image;
      public String Type;
      public String Country_code;
      public String Description_native;
      public String Description_english;
    
    public String getMinimum_age() {
        return Minimum_age;
    }

    public void setMinimum_age(String Minimum_age) {
        this.Minimum_age = Minimum_age;
    }

    public String getDisplay_text() {
        return Display_text;
    }

    public void setDisplay_text(String Display_text) {
        this.Display_text = Display_text;
    }

    public String getDisplay_image() {
        return Display_image;
    }

    public void setDisplay_image(String Display_image) {
        this.Display_image = Display_image;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getCountry_code() {
        return Country_code;
    }

    public void setCountry_code(String Country_code) {
        this.Country_code = Country_code;
    }

    public String getDescription_native() {
        return Description_native;
    }

    public void setDescription_native(String Description_native) {
        this.Description_native = Description_native;
    }

    public String getDescription_english() {
        return Description_english;
    }

    public void setDescription_english(String Description_english) {
        this.Description_english = Description_english;
    } 
}
