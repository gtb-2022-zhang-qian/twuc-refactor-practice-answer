package com.twu.refactoring;

public class Rental {

    private final Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double amount() {
        return movie.amount(daysRented);
    }

    public int frequentRenterPoints() {
        return hasBonus() ? 2 : 1;
    }

    private boolean hasBonus() {
        return movie.isNew() && daysRented > 1;
    }

    public String statement() {
        return "\t" + movie.getTitle() + "\t" + amount() + "\n";
    }
}