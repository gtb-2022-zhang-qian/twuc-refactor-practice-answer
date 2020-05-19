package com.twu.refactoring;

public class Negative implements CountStrategy {
    @Override
    public boolean isRightNumber(int number) {
        return number < 0;
    }
}
