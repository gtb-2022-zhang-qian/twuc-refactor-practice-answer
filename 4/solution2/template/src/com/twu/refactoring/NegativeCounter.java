package com.twu.refactoring;

public class NegativeCounter extends Counter {
    @Override
    protected boolean isCount(int number) {
        return number < 0;
    }
}
