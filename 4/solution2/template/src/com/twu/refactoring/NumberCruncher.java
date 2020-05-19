package com.twu.refactoring;

public class NumberCruncher {
    private static final EvenCounter evenCounter = new EvenCounter();
    private static final OddCounter oddCounter = new OddCounter();
    private static final PositiveCounter positiveCounter = new PositiveCounter();
    private static final NegativeCounter negativeCounter = new NegativeCounter();

    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return evenCounter.count(numbers);
    }

    public int countOdd() {
        return oddCounter.count(numbers);
    }

    public int countPositive() {
        return positiveCounter.count(numbers);
    }

    public int countNegative() {
        return negativeCounter.count(numbers);
    }
}
