/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.date;

import java.util.Date;

/**
 *
 * @author estevam
 */
public class DaysBetweenDates {

    public static int getDaysBetweenDates(Date startDate, Date endDate) {
        long MILISECONDS_PER_DAY = 24 * 60 * 60 * 1000;
        long diff = endDate.getTime() - startDate.getTime();
        int days = (int) Math.floor(diff / MILISECONDS_PER_DAY);
        return days;
    }
}
