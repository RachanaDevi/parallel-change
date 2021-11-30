package com.pduda.field;

import java.util.Arrays;

public class ShoppingCart {
    private int[] prices;

    public int calculateTotalPrice() {
        return Arrays.stream(prices).reduce(Integer::sum).getAsInt();
    }

    public boolean hasDiscount() {
        return Arrays.stream(prices).filter(price -> price >= 100).findAny().isPresent();
    }

    public int numberOfProducts() {
        return prices.length;
    }

    public void add(int... prices) {
        this.prices = prices;
    }
}
