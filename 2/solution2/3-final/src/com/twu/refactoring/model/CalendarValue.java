package com.twu.refactoring.model;

import java.util.Calendar;

public class CalendarValue {
    private final int field;
    private final int value;

    public CalendarValue(int field, int value) {
        this.field = field;
        this.value = value;
    }

    public Calendar setTo(Calendar calendar) {
        calendar.set(field, value);
        return calendar;
    }

}
