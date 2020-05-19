package com.twu.refactoring;

import static com.twu.refactoring.PriceCode.NEW_RELEASE;
import static java.lang.Math.max;

public class Movie {

    private final String title;
    private PriceCode priceCode;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public void setPriceCode(PriceCode priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    double amount(int daysRented) {
        return priceCode.basePrice + max(daysRented - priceCode.dayLimit, 0) * priceCode.extraPrice;
    }

    public boolean isNew() {
        return priceCode == NEW_RELEASE;
    }
}

