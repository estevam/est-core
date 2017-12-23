/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.Years;

/**
 *
 * @author estevam
 */
public class YearBetweenDates {
    public static void main(String args[]){
      YearBetweenDates test = new YearBetweenDates();
       // converter sua string em calendar         
       Calendar cal = test.stringToCalendar("23/04/1985");
       //convert calendar em joda
       DateTime checkDate  = test.convertCalendarToDateTime(cal);
       // current time machine
       DateTime now  = DateTime.now();
   
       // joda calcula os anos, dias, minutes etc... pra vc !
       int years = test.calcularIdade(checkDate,now);
        System.out.println(years);

        
        
    }
    
    public int calcularIdade( DateTime checkDate, DateTime now) {
       return  Years.yearsBetween(checkDate, now).toPeriod().getYears();            
    }

    public DateTime convertCalendarToDateTime(Calendar aCalendar) {
        DateTime dateTime = new DateTime(aCalendar);
        return dateTime;
    }

   
   public Calendar stringToCalendar(String aDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = formatter.parse(aDate);
        } catch (ParseException ex) {
            Logger.getLogger(YearBetweenDates.class.getName()).log(Level.SEVERE, ex.toString());
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal;
    }

}
