package com.twu.refactoring;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getRentalPrice() {
        double amount = 0d;

        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (daysRented > 2) amount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                amount += 1.5;
                if (daysRented > 3) amount += (daysRented - 3) * 1.5;
            break;
        }

        return amount;
    }

    public int getPoints() {
        int frequentRenterPoints = 1;

        if (movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }

    public String getString() {
        return "\t" + movie.getTitle() + "\t" + String.valueOf(getRentalPrice()) + "\n";
    }
}