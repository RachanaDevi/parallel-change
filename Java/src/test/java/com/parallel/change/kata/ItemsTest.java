package com.parallel.change.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemsTest {

    @Test
    public void shouldReturnItemsTotalPrice() {
        Items items = new Items();
        items.add(Item.from(100.00));
        items.add(Item.from(102.10));

        assertEquals(202.10, items.totalPrice(), 0);
    }

    @Test
    public void shouldReturnTrueIfAnyItemIsEligibleForDiscount() {
        Items items = new Items();
        items.add(Item.from(100.00));
        items.add(Item.from(10.10));

        assertTrue(items.eligibleForDiscount());
    }

    @Test
    public void shouldReturnFalseIfNoItemIsEligibleForDiscount() {
        Items items = new Items();
        items.add(Item.from(10.00));
        items.add(Item.from(10.10));

        assertFalse(items.eligibleForDiscount());
    }

    @Test
    public void shouldReturnTotalItemsAsZeroIfAddedItemIsNull() {
        Items items = new Items();
        items.add(null);

        assertEquals(0, items.size());
    }

    @Test
    public void shouldReturnHowManyItemsArePresent() {
        Items items = new Items();
        items.add(Item.from(10.00));
        items.add(Item.from(10.10));

        assertEquals(2, items.size());
    }

    @Test
    public void shouldReturnTotalPriceAsZeroIfThereAreNoItemsPresent() {
        Items items = new Items();

        assertEquals(0.0, items.totalPrice(), 0);
    }

    @Test
    public void shouldNotBeEligibleForDiscountIfThereAreNoItems() {
        Items items = new Items();

        assertFalse(items.eligibleForDiscount());
    }
}