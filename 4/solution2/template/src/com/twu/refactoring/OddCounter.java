package com.twu.refactoring;

public class OddCounter extends Counter {
    @Override
    protected boolean isCount(int number) {
        return number % 2 == 1;
    }

}
