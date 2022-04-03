package com.parallel.change.kata;

import com.parallel.change.kata.exception.InvalidItemPriceException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void shouldReturnTrueForCheckForPriceGreaterThanNinetyNine() {
        Item item = Item.from(Price.from(100.0));

        assertTrue(item.isEligibleForDiscount());
    }

    @Test
    public void shouldReturnFalseForCheckForPriceGreaterThanNinetyNine() {
        Item item = Item.from(Price.from(99.0));

        assertFalse(item.isEligibleForDiscount());
    }

    @Test
    public void shouldEquateTwoPricesHavingSameValues() {
        Item item = Item.from(Price.from(10.02));
        Item otherItem = Item.from(Price.from(10.02));

        assertEquals(item, otherItem);
    }

    @Test
    public void shouldReturnValueOfPrice() {
        Item item = Item.from(Price.from(10.21));

        assertEquals(10.21, item.value(), 0);
    }
}