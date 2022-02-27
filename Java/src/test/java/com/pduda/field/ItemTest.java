package com.pduda.field;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void shouldReturnTrueForCheckForPriceGreaterThanNinetyNine() {
        Item item = Item.from(100.0);

        assertTrue(item.isEligibleForDiscount());
    }

    @Test
    public void shouldReturnFalseForCheckForPriceGreaterThanNinetyNine() {
        Item item = Item.from(99.0);

        assertFalse(item.isEligibleForDiscount());
    }

    @Test
    public void shouldAddTwoPrices() {
        Item item = Item.from(10.02);
        Item otherItem = Item.from(12.23);

        assertEquals(Item.from(22.25), item.add(otherItem));
    }

    @Test
    public void shouldEquateTwoPricesHavingSameValues() {
        Item item = Item.from(10.02);
        Item otherItem = Item.from(10.02);

        assertEquals(item, otherItem);
    }

    @Test
    public void shouldReturnIntegerValueOfPrice() {
        Item item = Item.from(10.21);

        assertEquals(10, item.integerValue());
    }
}