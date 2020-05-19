package com.twu.refactoring;

public class EvenCounter extends Counter {

    @Override
    protected boolean isCount(int number) {
        return number % 2 == 0;
    }

}
