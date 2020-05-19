package com.twu.refactoring;

public class Taxi {
    private final boolean airConditioned;
    private final int totalKms;
    private final boolean peakTime;

    public Taxi(boolean airConditioned, int totalKms, boolean peakTime) {
        this.airConditioned = airConditioned;
        this.totalKms = totalKms;
        this.peakTime = peakTime;
    }

    double totalCost() {
        return FIXED_CHARGE + (preRate() + postRate()) * peakTimeMultiplier();
    }

    private double peakTimeMultiplier() {
        return peakTime ? 1.2 : 1.0;
    }

    private int postRate() {
        return postKms() * (airConditioned ? POST_RATE_CHANGE_AC_RATE: POST_RATE_CHANGE_NON_AC_RATE);
    }

    private int postKms() {
        return Math.max(0, totalKms - RATE_CHANGE_DISTANCE);
    }

    private int preRate() {
        return basicKms() * (airConditioned ? PRE_RATE_CHANGE_AC_RATE: PRE_RATE_CHANGE_NON_AC_RATE);
    }

    private int basicKms() {
        return Math.min(RATE_CHANGE_DISTANCE, totalKms);
    }

    private static final int FIXED_CHARGE = 50;
    private static final int RATE_CHANGE_DISTANCE = 10;
    private static final int PRE_RATE_CHANGE_NON_AC_RATE = 15;
    private static final int POST_RATE_CHANGE_NON_AC_RATE = 12;
    private static final int PRE_RATE_CHANGE_AC_RATE = 20;
    private static final int POST_RATE_CHANGE_AC_RATE = 17;
}
