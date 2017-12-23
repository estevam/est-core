/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevam
 */
public class CalendarExamples {

    public static void main(String[] args) {
        dateToCalendar();
        formatDate();
        operationCalendar();
        checkCalendar();
    }

    public static void dateToCalendar() {
        Date dateNow = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateNow);
        System.out.println(cal.getTime());
        System.out.println("hh: " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("mm: " + cal.get(Calendar.MINUTE));
        System.out.println("month: " + cal.get(Calendar.MONTH));

    }
    
    public static void formatDate() {
       Date dateNow = new Date();
       SimpleDateFormat sdf = new SimpleDateFormat("MMM, MMMMM, EEEEE, EEE, yyyy-MM-dd HH:mm:ss a z");
       String date = sdf.format(dateNow);
       System.out.println(date);
       
       // formats
       // ("h:mm a")  clock format
       // ("yyyy.MM.dd.HH.mm.ss")
       // ("E, dd MMM yyyy HH:mm:ss Z")
       // ("MM/dd/yy")
    }
    public static void otherFormatDate(){
       String pattern = "MM/dd/yyyy";
       SimpleDateFormat myFormat = new SimpleDateFormat(pattern);
       System.out.println(myFormat.format(new Date()));
    }
    
    public static void operationCalendar(){
       Calendar cal = Calendar.getInstance();
       System.out.println("Date now: " + cal.getTime());
    
       cal.add(Calendar.MINUTE, 1); // add minute
       System.out.println("Date add sec: " + cal.getTime());
       
       cal.add(Calendar.MINUTE, -1); // add minute
       System.out.println("Date delete sec: " + cal.getTime()); 
   
           int minStarting = cal.get(Calendar.MINUTE);

        if (minStarting < 30) { // minutes 00 or 30 
            
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
        }
        else {
            
            cal.set(Calendar.MINUTE, 30);
            cal.set(Calendar.SECOND, 0);
        }
        System.out.println("Date Min 30 or 00: " + cal.getTime());
    }
    
    
    public static void checkCalendar() {
        Calendar calNow = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 30);

        if (calNow.before(cal)) {
            System.out.println("Time now is before:" + cal.getTime());
        }

        if (calNow.after(cal)) {
            System.out.println("Time now is after:" + cal.getTime());
           
        }
        
        if(calNow.equals(cal)){
          System.out.println("Time now is equals:" + cal.getTime());
        }
        // Date has before and call too
    }
    
    public String zeroAdd(int num) {
        String number = (num < 10) ? ("0" + num) : ("" + num);
        return number;

    }
    
    public Date stringToDate(String aDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(aDate);
        } catch (ParseException ex) {
            Logger.getLogger(CalendarExamples.class.getName()).log(Level.SEVERE, ex.toString());
        }

        return date;
    }
    
        
    public Calendar stringToCalendar(String aDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(aDate);
        } catch (ParseException ex) {
            Logger.getLogger(CalendarExamples.class.getName()).log(Level.SEVERE, ex.toString());
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal;
    }
    
    
//   multilingual month   
    
//    private String getMonthCreate(int timeMonth) {
//        int month = Integer.parseInt(timeMonth);
//
//        final String LANGMAP[] = {
//            "monthJanuary",
//            "monthFebruary",
//            "monthMarch",
//            "monthApril",
//            "monthMay",
//            "monthJune",
//            "monthJuly",
//            "monthAugust",
//            "monthSeptember",
//            "monthOctober",
//            "monthNovember",
//            "monthDecember",};
//
//        return iLanguage.getString(LANGMAP[month]);
//    }
    
    // date & calendar -  after and before 




}


    
