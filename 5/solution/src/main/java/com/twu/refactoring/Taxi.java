package com.twu.refactoring;

public class Taxi {
    private static final double PEAK_TIME_MULTIPLIER = 1.2;
    private static final double OFF_PEAK_MULTIPLIER = 1.0;
    private static final int RATE_CHANGE_DISTANCE = 10;
    private static final int PRE_RATE_CHANGE_NON_AC_RATE = 15;
    private static final int POST_RATE_CHANGE_NON_AC_RATE = 12;
    private static final int PRE_RATE_CHANGE_AC_RATE = 20;
    private static final int POST_RATE_CHANGE_AC_RATE = 17;

    private boolean airConditioned;
    private final int totalKms;
    private final boolean peakTime;

    public Taxi(boolean airConditioned, int totalKms, boolean peakTime) {
        this.airConditioned = airConditioned;
        this.totalKms = totalKms;
        this.peakTime = peakTime;
    }

    public double getTaxiCharge() {
        double taxiCharge = 0d;
        double peakTimeMultiple = getPeakTimeMultiple();

        taxiCharge += Math.min(RATE_CHANGE_DISTANCE, totalKms) * getPreRateAcRate() * peakTimeMultiple;
        taxiCharge += Math.max(0, totalKms - RATE_CHANGE_DISTANCE) * getPostRateAcRate() * peakTimeMultiple;

        return taxiCharge;
    }

    private double getPeakTimeMultiple() {
        return peakTime ? PEAK_TIME_MULTIPLIER : OFF_PEAK_MULTIPLIER;
    }

    private int getPostRateAcRate() {
        return airConditioned ? POST_RATE_CHANGE_AC_RATE : POST_RATE_CHANGE_NON_AC_RATE;
    }

    private int getPreRateAcRate() {
        return airConditioned ? PRE_RATE_CHANGE_AC_RATE : PRE_RATE_CHANGE_NON_AC_RATE;
    }
}
