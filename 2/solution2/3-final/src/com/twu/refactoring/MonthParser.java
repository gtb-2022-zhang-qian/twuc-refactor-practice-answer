package com.twu.refactoring;

public class MonthParser extends BaseParser {

    protected MonthParser(String name, int field, int beginIndex, int length, int minLimit, int maxLimit) {
        super(name, field, beginIndex, length, minLimit, maxLimit);
    }

    @Override
    protected int parseValue(String dateAndTime) {
        return super.parseValue(dateAndTime) - 1;
    }
}
