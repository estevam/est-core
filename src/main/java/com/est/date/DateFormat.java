package com.est.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author estevam
 */

public class DateFormat {

    public static void main(String[] args) {

        formatCurruentDate();

    }

    public static void formatCurruentDate() { // formatting date
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat myFormat = new SimpleDateFormat(pattern);
        System.out.println(myFormat.format(new Date()));
    }
    
    public String zeroAdd(int num) { // zero add in time
        String number = (num < 10) ? ("0" + num) : ("" + num);
        return number;

    }

}
