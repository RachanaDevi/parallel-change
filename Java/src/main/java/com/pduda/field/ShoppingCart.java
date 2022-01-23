package com.pduda.field;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static final int LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT = 100;
    private final List<Double> prices = new ArrayList<>();

    public double calculateTotalPrice() {
        return prices.stream().reduce(Double::sum).get();
    }

    public boolean hasDiscount() {
        for (Double price : prices) {
            if (priceHasDiscount(price)) return true;
        }
        return false;
    }

    private static boolean priceHasDiscount(Double price) {
        return price >= LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT;
    }

    public int numberOfProducts() {
        return prices.size();
    }

    public void add(double price) {
        this.prices.add(price);
    }
}
