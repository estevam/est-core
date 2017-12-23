/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.timezone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Estevam
 */
public class UITimeZone {

    public static Date convertTimeZoneDate(String aDataUTC) throws ParseException {// 100%

        SimpleDateFormat sdfgmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfgmt.setTimeZone(TimeZone.getTimeZone("UTC"));

        SimpleDateFormat sdfmad = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar c = Calendar.getInstance();
        String timeZone = c.getTimeZone().getID(); //UTC,America/Toronto, America/Vancouver

        sdfmad.setTimeZone(TimeZone.getTimeZone(timeZone));

        Date date = null;
        try {
            date = sdfgmt.parse(aDataUTC);
        } catch (ParseException e) {
        }

        return date;

    }

    public static String convertTimeZoneUTC(String aDataUTC) throws ParseException {

        SimpleDateFormat sdfgmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfgmt.setTimeZone(TimeZone.getTimeZone("UTC"));

        SimpleDateFormat sdfmad = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar c = Calendar.getInstance();
        String timeZone = c.getTimeZone().getID();

        sdfmad.setTimeZone(TimeZone.getTimeZone(timeZone));

        Date inptdate = null;
        try {
            inptdate = sdfgmt.parse(aDataUTC);
        } catch (ParseException e) {
        }

        // System.out.println("UTC: " + sdfgmt.format(inptdate));
        // System.out.println(timeZone + ": "  + sdfmad.format(inptdate));

        String time = sdfmad.format(inptdate);
        return time;

    }
}
