package com.twu.refactoring;

import com.twu.refactoring.model.CalendarValue;

import java.util.regex.Pattern;

public class BaseParser implements Parser {

    private final String name;
    private final int beginIndex;
    private final int length;
    private final int minLimit;
    private final int maxLimit;
    protected final int field;

    protected BaseParser(String name, int field, int beginIndex, int length, int minLimit, int maxLimit) {
        this.name = name;
        this.field = field;
        this.beginIndex = beginIndex;
        this.length = length;
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
    }

    @Override
    public CalendarValue parse(String dateAndTime) {
        return new CalendarValue(field, parseValue(dateAndTime));
    }

    protected int parseValue(String dateAndTime) {
        int partOfDateOrTime = parseToInt(getPartOfDateOrTime(dateAndTime));
        checkLimit(partOfDateOrTime);
        return partOfDateOrTime;
    }

    private void checkLimit(int partOfDateOrTime) {
        if (partOfDateOrTime < minLimit || partOfDateOrTime > maxLimit)
            throw new IllegalArgumentException(name + " cannot be less than " + minLimit + " or more than " + maxLimit);
    }

    private int parseToInt(String partOf) {
        if (!Pattern.matches("^\\d+$", partOf)) {
            throw new IllegalArgumentException(name + " is not an integer");
        }
        return Integer.parseInt(partOf);
    }

    private String getPartOfDateOrTime(String dateAndTime) {
        if (dateAndTime.length() < beginIndex + length) {
            throw new IllegalArgumentException(name + " string is less than " + length + " characters");

        }
        return dateAndTime.substring(beginIndex, beginIndex + length);
    }

}
