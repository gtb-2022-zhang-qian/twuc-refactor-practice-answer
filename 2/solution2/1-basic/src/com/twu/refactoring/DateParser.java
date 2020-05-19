package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

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

        year = parse("Year", 0, 4, 2000, 2012);

        month = parse("Month", 5, 2, 1, 12);

        date = parse("Date", 8, 2, 1, 31);

        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
            minute = 0;
        } else {
            hour = parse("Hour", 11, 2, 0, 23);

            minute = parse("Minute", 14, 2, 0, 59);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private int parse(final String name, int beginIndex, int length, int minLimit, int maxLimit) {
        if(dateAndTimeString.length() < beginIndex + length) {
            throw new IllegalArgumentException(name + " string is less than " + length + " characters");

        }
        String partOf = dateAndTimeString.substring(beginIndex, beginIndex + length);
        if(!Pattern.matches("^\\d+$", partOf)) {
            throw new IllegalArgumentException(name + " is not an integer");

        }
        int month = Integer.parseInt(partOf);
        if (month < minLimit || month > maxLimit)
            throw new IllegalArgumentException(name + " cannot be less than " + minLimit + " or more than " + maxLimit);
        return month;
    }

}
