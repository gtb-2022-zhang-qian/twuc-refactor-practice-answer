package com.twu.refactoring;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private static final double TAX_RATE = .10;

    private final String customerName;
    private final String customerAddress;
    private final List<LineItem> lineItems;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
    }

    public String customerInformation() {
        return customerName + customerAddress;
    }

    private double totalAmountWithoutTax() {
        return lineItems.stream().mapToDouble(LineItem::totalAmount).sum();
    }

    public double totalTax() {
        return totalAmountWithoutTax() * TAX_RATE;
    }

    public double totalAmount() {
        return totalAmountWithoutTax() + totalTax();
    }

    public String itemsInformation() {
        return lineItems.stream().map(LineItem::toString).collect(Collectors.joining("\n"));
    }
}
