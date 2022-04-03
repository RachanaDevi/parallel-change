package com.parallel.change.kata;

import com.parallel.change.kata.exception.InvalidItemPriceException;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceTest {

    @Test(expected = InvalidItemPriceException.class)
    public void shouldReturnItemWithZeroValue() {
        Price priceWithZeroValue = Price.from(0.0);
    }

    @Test(expected = InvalidItemPriceException.class)
    public void shouldReturnItemWithNull() {
        Price priceWithNullValue = Price.from(null);
    }

    @Test
    public void shouldReturnTrueForCheckForPriceGreaterThanNinetyNine() {
        Price actualPrice = Price.from(100.0);

        assertTrue(actualPrice.isEligibleForDiscount());
    }

    @Test
    public void shouldReturnFalseForCheckForPriceGreaterThanNinetyNine() {
        Price actualPrice = Price.from(99.0);

        assertFalse(actualPrice.isEligibleForDiscount());
    }

    @Test
    public void shouldAddTwoPrices() {
        Price price = Price.from(10.012);
        Price otherPrice = Price.from(20.21);

        assertEquals(price.add(otherPrice), Price.from(30.222));
    }
}
