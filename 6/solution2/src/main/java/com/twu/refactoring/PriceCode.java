package com.twu.refactoring;

public enum PriceCode {
    CHILDRENS(1.5, 3, 1.5),
    REGULAR(2, 2, 1.5),
    NEW_RELEASE(0, 0, 3);

    public final double basePrice;
    public final int dayLimit;
    public final double extraPrice;

    PriceCode(double basePrice, int dayLimit, double extraPrice) {
        this.basePrice = basePrice;
        this.dayLimit = dayLimit;
        this.extraPrice = extraPrice;
    }

}
