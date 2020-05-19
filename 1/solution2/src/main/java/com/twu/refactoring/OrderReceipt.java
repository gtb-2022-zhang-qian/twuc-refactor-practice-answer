package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
	private static final String HEADER = "======Printing Orders======";
	private final Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		output.append(HEADER).append("\n");

        output.append(order.customerInformation()).append("\n");

		output.append(order.itemsInformation()).append("\n");

		output.append("Sales Tax").append('\t').append(order.totalTax()).append("\n");

		output.append("Total Amount").append('\t').append(order.totalAmount());
		return output.toString();
	}

}