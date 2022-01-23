package com.pduda.field;

import java.util.Objects;

public class Price {

    private static final int LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT = 100;
    private final Double value;

    private Price(double value) {
        this.value = value;
    }

    public static Price from(Double value) {
        return new Price(value);
    }

    public boolean greaterThanNinetyNine() {
        return this.value >= LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT;
    }

    public Price add(Price otherPrice) {
        return new Price(this.value + otherPrice.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Double.compare(price.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int integerValue() {
        return this.value.intValue();
    }
}
