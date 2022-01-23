package com.pduda.field;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriceTest {

    @Test
    public void shouldReturnTrueForCheckForPriceGreaterThanNinetyNine() {
        Price price = Price.from(100.0);

        assertTrue(price.greaterThanNinetyNine());
    }

    @Test
    public void shouldReturnFalseForCheckForPriceGreaterThanNinetyNine() {
        Price price = Price.from(99.0);

        assertFalse(price.greaterThanNinetyNine());
    }

    @Test
    public void shouldAddTwoPrices() {
        Price price = Price.from(10.02);
        Price otherPrice = Price.from(12.23);

        assertEquals(Price.from(22.25), price.add(otherPrice));
    }

    @Test
    public void shouldEquateTwoPricesHavingSameValues() {
        Price price = Price.from(10.02);
        Price otherPrice = Price.from(10.02);

        assertEquals(price, otherPrice);
    }

    @Test
    public void shouldReturnIntegerValueOfPrice() {
        Price price = Price.from(10.21);

        assertEquals(10, price.integerValue());
    }
}