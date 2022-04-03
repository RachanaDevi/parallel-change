package com.parallel.change.kata.exception;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvalidItemPriceExceptionTest {

    @Test
    public void shouldReturnExceptionMessageWithItemPriceAsZero() {
        InvalidItemPriceException invalidItemPriceException = new InvalidItemPriceException(0.0);

        assertEquals(invalidItemPriceException.getMessage(), "Price of the Item is invalid. Price: 0.0");
    }

    @Test
    public void shouldReturnExceptionMessageWithItemPriceAsNull() {
        InvalidItemPriceException invalidItemPriceException = new InvalidItemPriceException(null);

        assertEquals(invalidItemPriceException.getMessage(), "Price of the Item is invalid. Price: null");
    }
}