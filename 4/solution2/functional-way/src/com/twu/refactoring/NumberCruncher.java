package com.twu.refactoring;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return countBy(number -> number % 2 == 0);
    }

    public int countOdd() {
        return countBy(number -> number % 2 == 1);
    }

    public int countPositive() {
        return countBy(number -> number >= 0);
    }

    public int countNegative() {
        return countBy(number -> number < 0);
    }

    private int countBy(IntPredicate predicate) {
        return (int) Arrays.stream(numbers).filter(predicate).count();
    }

}
