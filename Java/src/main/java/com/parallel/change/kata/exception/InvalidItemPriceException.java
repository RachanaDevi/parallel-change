package com.parallel.change.kata.exception;

public class InvalidItemPriceException extends IllegalArgumentException {

    public InvalidItemPriceException(Object itemPrice) {
        super(String.format("Price of the Item is invalid. Price: %s", itemPrice));
    }
}
