package com.est.date;

import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;

/**
 *
 * @author estevam
 */

public class JodaTimeUtil {

    /**
     * Convert UTC time to local time
     *
     * @param aDateTime
     * @return
     */
    public static DateTime convertLocaltoUTCTime(DateTime aDateTime) {

        DateTimeZone defaultZone = DateTimeZone.forID("UTC");
        //DateTimeZone.setDefault(defaultZone);
        DateTime utcTime = aDateTime.withZone(DateTimeZone.forID(defaultZone.toString()));

        return utcTime;
    }

    public static String formatDateTime(DateTime aStartTime, DateTime aEndTime) {
        int day = aStartTime.getDayOfMonth();
        int month = aStartTime.getMonthOfYear();
        int year = aStartTime.getYear();

        String dateString = String.valueOf(day) + "/" + String.format("%02d", month)
                + "/" + String.valueOf(year).replaceAll("20", "");

        DateTime.Property Hours = aStartTime.hourOfDay();
        DateTime.Property minutes = aStartTime.minuteOfHour();
        String strStartTime = String.format("%02d", Hours.get()) + ":" + String.format("%02d", minutes.get());

        DateTime.Property endHr = aEndTime.hourOfDay();
        DateTime.Property endMin = aEndTime.minuteOfHour();
        String strEndTime = String.format("%02d", endHr.get()) + ":" + String.format("%02d", endMin.get());

        String timeString = strStartTime + "-" + strEndTime;

        return dateString + " | " + timeString;
    }

    public static String convertToWeekday(int weekDay, ResourceBundle aLanguage) {
        switch (weekDay) {
            case 1:
                return aLanguage.getString("weekMonday");
            case 2:
                return aLanguage.getString("weekTuesday");
            case 3:
                return aLanguage.getString("weekWednesday");
            case 4:
                return aLanguage.getString("weekThursday");
            case 5:
                return aLanguage.getString("weekFriday");
            case 6:
                return aLanguage.getString("weekSaturday");
            case 7:
                return aLanguage.getString("weekSunday");
            default:
                return "";
        }
    }

    public static DateTime convertUTCtoLocalTime(DateTime aDateTime) {

        DateTimeZone defaultZone = DateTimeZone.getDefault();
        DateTimeZone.setDefault(defaultZone);
        DateTime dtLocal = aDateTime.withZone(DateTimeZone.forID(defaultZone.toString()));

        return dtLocal;
    }

    /**
     * getInterval - Calculate the interval between to dates<br/>
     *
     * @param DateTime aCalendarStart
     * @param DateTime aCalendarEnd
     * @param int aType: 0=years, 1=month, 2=days, 3=hours, 4=min, 5=sec
     * @return int
     */
    public static int findProgramDuration(DateTime aStart, DateTime aEnd, int aType) {

        int interval = 0;
        Period period = new Period(aStart, aEnd);

        switch (aType) {

            case 0:
                interval = period.getYears();
                break;
            case 1:
                interval = period.getMonths();
                break;
            case 2:
                interval = period.getDays();
                break;
            case 3:
                interval = period.getHours();
                break;
            case 4:
                interval = period.getMinutes();
                break;
            case 5:
                interval = period.getMillis();
                break;
        }
        return interval;
    }

    /**
     *
     * @param aDateTime
     * @return MONDAY = 1 | TUESDAY = 2 | WEDNESDAY = | THURSDAY = 4 | FRIDAY =
     * 5 | SATURDAY = 6 | SUNDAY = 7;
     */
    public static int findDayOfWeek(DateTime aDateTime) {
        int num = aDateTime.getDayOfWeek();
        return num;
    }

    /**
     * formatDateTimeString
     *
     * @param aTime
     * @return
     */
    public static String formatDateTimeString(DateTime aTime) {
        return aTime.toString("yyyy-MM-dd hh:mm:ss");
    }

    /**
     * formatDateTimeHHmm
     *
     * @param aTime
     * @return
     */
    public String formatDateTimeHHmm(DateTime aTime) {
        return aTime.toString("hh:mm");
    }

    /**
     * Validate String check if is null or not
     *
     * @param String aStr
     * @return Valid String
     */
    public static String validateString(String aStr) {
        if (aStr == null) {
            aStr = "";
        }
        return aStr;
    }

    /**
     * Parse Int to String
     *
     * @param Int aNum
     * @return String
     */
    public static String parseIntToString(int aNum) {
        String stringNum = Integer.toString(aNum);
        return stringNum;
    }

    /**
     * Parse String to Int
     *
     *
     * @param String aStr
     * @return Int
     */
    public static int parseStringToInt(String aNumString) {
        int num = Integer.parseInt(aNumString);
        return num;
    }

    /**
     * convertToUnixTime
     *
     * @param aUnixTime
     * @return
     */
    @SuppressWarnings("null")
	public int convertToUnixTime(Date aUnixTime) {
        Calendar cal = null;
        cal.setTime(aUnixTime);
        return (int) (cal.getTimeInMillis() / 1000L);
    }

    /**
     * convertTimestampToCalendar
     *
     * @param aTimestamp
     * @return
     */
    @SuppressWarnings("null")
    public DateTime convertTimestampToDateTime(int aTimestamp) {
        Calendar cal = null;
        cal.setTimeInMillis(aTimestamp);
        DateTime datetime = convertCalendarToDateTime(cal);
        return datetime;
    }

    public static String addZero(int num) {
        String number = (num < 10) ? ("0" + num) : ("" + num);
        return number;
    }

    /**
     * convertDateTimeToCalendar
     *
     * @param aDateTime
     * @return
     */
    public Calendar convertDateTimeToCalendar(DateTime aDateTime) {
        return aDateTime.toGregorianCalendar();
    }

    /**
     * convertCalendarToDateTime
     *
     * @param aCalendar
     * @return
     */
    public DateTime convertCalendarToDateTime(Calendar aCalendar) {
        DateTime dateTime = new DateTime(aCalendar);
        return dateTime;
    }

    /**
     * truncate channel name
     *
     * @param aTitle
     * @return
     */
    public static String truncateChannelName(String aTitle) {
        aTitle = validateString(aTitle);
        if (aTitle.length() > 10) {
            aTitle = aTitle.substring(0, 11) + "...";
        }
        return aTitle;
    }
}

 