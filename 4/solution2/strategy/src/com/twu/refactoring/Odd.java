package com.twu.refactoring;

public class Odd implements CountStrategy {
    @Override
    public boolean isRightNumber(int number) {
        return number % 2 == 1;
    }
}
