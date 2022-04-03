package com.parallel.change.kata;

import com.parallel.change.kata.exception.InvalidItemPriceException;

import java.util.Objects;

public class Item {

    private static final int LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT = 100;
    private static final Double ZERO_PRICE = 0.0;
    private final Double value;

    private Item(Double value) {
        this.value = value;
    }

    public static Item from(Double value) {
        if (Objects.isNull(value) || value.equals(ZERO_PRICE))
            throw new InvalidItemPriceException(value);

        return new Item(value);
    }

    public boolean isEligibleForDiscount() {
        return this.value >= LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT;
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

    Double value() {
        return this.value;
    }
}
