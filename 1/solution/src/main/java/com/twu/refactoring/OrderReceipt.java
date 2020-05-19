package com.twu.refactoring;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();
		printHeaders(output);

		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.toString());
		}

		output.append("Sales Tax").append('\t').append(order.getTotalSalesTax());
		output.append("Total Amount").append('\t').append(order.getTotal());

		return output.toString();
	}

	private void printHeaders(StringBuilder output) {
		output.append("======Printing Orders======\n");
		output.append(order.getCustomerName());
		output.append(order.getCustomerAddress());
	}
}