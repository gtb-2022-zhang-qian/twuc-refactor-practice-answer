package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return countBy(new Even());
    }

    public int countOdd() {
        return countBy(new Odd());
    }

    public int countPositive() {
        return countBy(new Positive());
    }

    public int countNegative() {
        return countBy(new Negative());
    }

    private int countBy(CountStrategy strategy) {
        int count = 0;
        for (int number : numbers) {
            if(strategy.isRightNumber(number))
                count++;
        }
        return count;
    }
}
