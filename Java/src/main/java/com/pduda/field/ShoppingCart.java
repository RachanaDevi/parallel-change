package com.pduda.field;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static final int LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT = 100;
    private final List<Integer> prices = new ArrayList<>();

    public int calculateTotalPrice() {
        return prices.stream().reduce(Integer::sum).get();
    }

    public boolean hasDiscount() {
        return prices.stream().anyMatch(price -> price >= LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT);
    }

    public int numberOfProducts() {
        return prices.size();
    }

    public void add(int price) {
        this.prices.add(price);
    }
}
