package com.twu.refactoring;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Customer {

    private final String name;
    private final ArrayList<Rental> rentalList = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public String statement() {
        return header()
                + rentalsStatement()
                + footer();
    }

    private String header() {
        return "Rental Record for " + name + "\n";
    }

    private String rentalsStatement() {
        return rentalList.stream().map(Rental::statement).collect(Collectors.joining());
    }

    private String footer() {
        return "Amount owed is " + totalAmount() + "\n"
                + "You earned " + totalFrequentRenterPoints() + " frequent renter points";
    }

    private int totalFrequentRenterPoints() {
        return rentalList.stream().mapToInt(Rental::frequentRenterPoints).sum();
    }

    private double totalAmount() {
        return rentalList.stream().mapToDouble(Rental::amount).sum();
    }

}
