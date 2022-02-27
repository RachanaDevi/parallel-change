package com.pduda.field;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Item> items = new ArrayList<>();

    public int calculateTotalPrice() {
        return items.stream().reduce(Item::add).get().integerValue();
    }

    public boolean hasDiscount() {
        return items.stream().anyMatch(Item::greaterThanNinetyNine);
    }

    public int numberOfProducts() {
        return items.size();
    }

    public void add(double itemPrice) {
        this.items.add(Item.from(itemPrice));
    }
}
