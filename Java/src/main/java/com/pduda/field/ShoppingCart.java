package com.pduda.field;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Price> prices = new ArrayList<>();

    public int calculateTotalPrice() {
        return prices.stream().reduce(Price::add).get().integerValue();
    }

    public boolean hasDiscount() {
        return prices.stream().anyMatch(Price::greaterThanNinetyNine);
    }

    public int numberOfProducts() {
        return prices.size();
    }

    public void add(double price) {
        this.prices.add(Price.from(price));
    }
}
