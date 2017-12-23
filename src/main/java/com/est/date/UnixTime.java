/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.date;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author estevam
 */
public class UnixTime {

    public int unixTime(Date aUnixTime) {

        Calendar c = Calendar.getInstance();
        c.setTime(aUnixTime);
        return (int) (c.getTimeInMillis() / 1000L);
    }
}
