package com.twu.refactoring;

public class Receipt {

    private static final double SALES_TAX_RATE = 0.1;

    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double getTotalCost() {
        return taxi.totalCost() * (1 + SALES_TAX_RATE);
    }

}
