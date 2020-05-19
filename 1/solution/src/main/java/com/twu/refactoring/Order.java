package com.twu.refactoring;

import java.util.List;

public class Order {
    private static final double TAX_RATE = .10;
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotalSalesTax() {
        return getTotalWithoutSalesTax() * TAX_RATE;
    }

    public double getTotal() {
        return getTotalWithoutSalesTax() + getTotalSalesTax();
    }

    private double getTotalWithoutSalesTax() {
        double total = 0d;

        for (LineItem lineItem : getLineItems()) {
            total += lineItem.totalAmount();
        }

        return total;
    }
}
