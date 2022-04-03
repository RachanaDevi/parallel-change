package com.parallel.change.kata;

import com.parallel.change.kata.exception.InvalidItemPriceException;

import java.util.Objects;

public class Price {

    private final Double value;
    private static final int LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT = 100;
    private static final double ZERO = 0.0;
    private static final Price ZERO_PRICE = new Price(ZERO);

    private Price(Double value) {
        this.value = value;
    }

    public static Price from(Double value) {
        if (Objects.isNull(value) || value.equals(ZERO))
            throw new InvalidItemPriceException(value);

        return new Price(value);
    }

    static Price zero() {
        return ZERO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(value, price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean isEligibleForDiscount() {
        return this.value >= LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT;
    }

    public Price add(Price otherPrice) {
        return new Price(this.value + otherPrice.value);
    }
}
