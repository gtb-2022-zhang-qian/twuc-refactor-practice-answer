package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    private INumberType isEven = (int number) -> number % 2 == 0;
    private INumberType isPositive = (int number) -> number >= 0;
    private INumberType isOdd = (int number) -> number % 2 != 0;
    private INumberType isNegative = (int number) -> number < 0;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return countNumber(isEven);
    }

    public int countOdd() {
        return countNumber(isOdd);
    }

    public int countPositive() {
        return countNumber(isPositive);
    }

    public int countNegative() {
        return countNumber(isNegative);
    }

    private int countNumber(INumberType function) {
        int count = 0;
        for (int number : numbers) {
            if (function.testNumber(number))
                count++;
        }
        return count;
    }
}