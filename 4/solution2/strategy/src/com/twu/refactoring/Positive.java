package com.twu.refactoring;

public class Positive implements CountStrategy {
    @Override
    public boolean isRightNumber(int number) {
        return number >= 0;
    }
}
