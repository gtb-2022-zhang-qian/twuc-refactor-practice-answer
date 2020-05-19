package com.twu.refactoring;

public class TimeParser extends BaseParser {

    protected TimeParser(String name, int field, int beginIndex, int length, int minLimit, int maxLimit) {
        super(name, field, beginIndex, length, minLimit, maxLimit);
    }

    @Override
    protected int parseValue(String dateAndTime) {
        if(dateAndTime.substring(11, 12).equals("Z")) {
            return 0;
        }
        return super.parseValue(dateAndTime);
    }
}
