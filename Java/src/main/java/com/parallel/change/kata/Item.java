package com.parallel.change.kata;

import java.util.Objects;

public class Item {

    private final Price price;

    private Item(Price price) {
        this.price = price;
    }

    public static Item from(Price price) {
        return new Item(price);
    }

    public boolean isEligibleForDiscount() {
        return this.price.isEligibleForDiscount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    Price price() {
        return this.price;
    }
}
