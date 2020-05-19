package com.twu.refactoring;

import java.util.regex.Pattern;

public enum Parser {
    YEAR("Year", 0, 4, 2000, 2012),
    MONTH("Month", 5, 2, 1, 12),
    DATE("Date", 8, 2, 1, 31),
    HOUR("Hour", 11, 2, 0, 23),
    MINUTE("Minute", 14, 2, 0, 59);

    private final String name;
    private final int beginIndex;
    private final int length;
    private final int minLimit;
    private final int maxLimit;

    Parser(String name, int beginIndex, int length, int minLimit, int maxLimit) {
        this.name = name;
        this.beginIndex = beginIndex;
        this.length = length;
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
    }

    public int parse(String dateAndTime) {
        int partOfDateOrTime = parseToInt(getPartOfDateOrTime(dateAndTime));
        checkLimit(partOfDateOrTime);
        return partOfDateOrTime;
    }

    private void checkLimit(int partOfDateOrTime) {
        if (partOfDateOrTime < minLimit || partOfDateOrTime > maxLimit)
            throw new IllegalArgumentException(name + " cannot be less than " + minLimit + " or more than " + maxLimit);
    }

    private int parseToInt(String partOf) {
        if(!Pattern.matches("^\\d+$", partOf)) {
            throw new IllegalArgumentException(name + " is not an integer");
        }
        return Integer.parseInt(partOf);
    }

    private String getPartOfDateOrTime(String dateAndTime) {
        if(dateAndTime.length() < beginIndex + length) {
            throw new IllegalArgumentException(name + " string is less than " + length + " characters");

        }
        return dateAndTime.substring(beginIndex, beginIndex + length);
    }

}
