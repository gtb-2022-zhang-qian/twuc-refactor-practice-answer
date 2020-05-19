package com.twu.refactoring;

import com.twu.refactoring.model.CalendarValue;

import java.util.Calendar;

public interface Parser {
    CalendarValue parse(String dateAndTime);

    Parser YEAR = new BaseParser("Year", Calendar.YEAR, 0, 4, 2000, 2012);
    Parser MONTH = new MonthParser("Month", Calendar.MONTH, 5, 2, 1, 12);
    Parser DATE = new BaseParser("Date", Calendar.DATE, 8,2,1,31);
    Parser HOUR = new TimeParser("Hour", Calendar.HOUR_OF_DAY, 11, 2, 0, 23);
    Parser MINUTE = new TimeParser("Minute", Calendar.MINUTE, 14, 2, 0, 59);
    Parser SECOND = new EmptyParser(Calendar.SECOND);
    Parser MILLISECOND = new EmptyParser(Calendar.MILLISECOND);

    Parser[] parsers = new Parser[]{YEAR, MONTH, DATE, HOUR, MINUTE, SECOND, MILLISECOND};
}
