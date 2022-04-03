package com.parallel.change.kata;

import com.parallel.change.kata.exception.InvalidItemPriceException;

import java.util.Objects;

public class Price {

    private final Double value;
    private static final int LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT = 100;
    public static final double ZERO = 0.0;

    private Price(Double value) {
        this.value = value;
    }

    public static Price from(Double value) {
        if (Objects.isNull(value) || value.equals(ZERO))
            throw new InvalidItemPriceException(value);

        return new Price(value);
    }

    Double value() {
        return value;
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
}
