package com.twu.refactoring;

public class PositiveCounter extends Counter {

    @Override
    protected boolean isCount(int number) {
        return number >= 0;
    }

}
