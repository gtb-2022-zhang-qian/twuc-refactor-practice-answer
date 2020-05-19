package com.twu.refactoring;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static com.twu.refactoring.Parser.parsers;

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
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
//        for (Parser parser : parsers) {
//            calendar = parser.parse(dateAndTimeString).setTo(calendar);
//        }
        calendar = Arrays.stream(parsers).map(parser -> parser.parse(dateAndTimeString))
                .reduce(calendar, (c, calendarValue) -> calendarValue.setTo(c), (c1, c2) -> c1);
        return calendar.getTime();
    }

}
