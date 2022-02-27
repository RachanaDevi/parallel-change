package com.pduda.field;

import java.util.Objects;

public class Item {

    private static final int LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT = 100;
    private final Double value;

    private Item(double value) {
        this.value = value;
    }

    public static Item from(Double value) {
        return new Item(value);
    }

    public boolean isEligibleForDiscount() {
        return this.value >= LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT;
    }

    public Item add(Item otherItem) {
        return new Item(this.value + otherItem.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int integerValue() {
        return this.value.intValue();
    }
}
