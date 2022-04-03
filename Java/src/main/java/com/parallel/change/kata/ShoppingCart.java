package com.parallel.change.kata;

import java.util.Objects;

public class ShoppingCart {

    private final Items items;

    public ShoppingCart() {
        items = new Items();
    }

    public Price totalPrice() {
        return items.totalPrice();
    }

    public boolean hasDiscount() {
        return items.eligibleForDiscount();
    }

    public int numberOfProducts() {
        return items.size();
    }

    public void add(Item item) {
        if (!Objects.isNull(item))
            this.items.add(item);
    }
}
