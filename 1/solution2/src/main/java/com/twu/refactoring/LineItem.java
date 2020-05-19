package com.twu.refactoring;

public class LineItem {
	private final String description;
	private final double price;
	private final int quantity;

	public LineItem(String description, double price, int quantity) {
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public double totalAmount() {
        return price * quantity;
    }

    @Override
	public String toString() {
		return description + '\t' + price + '\t' + quantity + '\t' + totalAmount();
	}
}