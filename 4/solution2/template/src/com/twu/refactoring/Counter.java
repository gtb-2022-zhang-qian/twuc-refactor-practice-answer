package com.twu.refactoring;

public abstract class Counter {
    public int count(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (isCount(number)) count++;
        }
        return count;
    }

    protected abstract boolean isCount(int number);
}
