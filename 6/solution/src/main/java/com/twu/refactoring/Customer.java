package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String statement() {
		String result = "Rental Record for " + name + "\n";
		result += toStringRentals();
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getTotalRenterPoints()) + " frequent renter points";

		return result;
	}

	private String toStringRentals() {
		return rentalList.stream()
				.map(Rental::getString)
				.reduce("", (string1, string2) -> string1 + string2);
	}

	private double getTotalAmount() {
		return rentalList.stream()
				.map(Rental::getRentalPrice)
				.reduce(0d, (price1, price2) -> price1 + price2);
	}

	private int getTotalRenterPoints() {
		return rentalList.stream()
				.map(Rental::getPoints)
				.reduce(0, (points1, points2) -> points1 + points2);
	}
}
