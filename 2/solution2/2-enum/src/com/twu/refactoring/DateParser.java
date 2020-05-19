package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;

        year = Parser.YEAR.parse(dateAndTimeString);

        month = Parser.MONTH.parse(dateAndTimeString);

        date = Parser.DATE.parse(dateAndTimeString);

        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
            minute = 0;
        } else {
            hour = Parser.HOUR.parse(dateAndTimeString);

            minute = Parser.MINUTE.parse(dateAndTimeString);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

}
