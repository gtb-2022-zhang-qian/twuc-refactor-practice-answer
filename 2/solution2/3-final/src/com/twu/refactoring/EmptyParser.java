package com.twu.refactoring;

import com.twu.refactoring.model.CalendarValue;

public class EmptyParser implements Parser {
    private final int field;

    protected EmptyParser(int field) {
        this.field = field;
    }

    @Override
    public CalendarValue parse(String dateAndTime) {
        return new CalendarValue(field, 0);
    }

}
