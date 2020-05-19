package com.twu.refactoring;

public class Even implements CountStrategy {
    @Override
    public boolean isRightNumber(int number) {
        return number % 2 == 0;
    }
}
