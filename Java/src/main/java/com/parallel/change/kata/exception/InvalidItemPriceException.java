package com.parallel.change.kata.exception;

public class InvalidItemPriceException extends IllegalArgumentException {

    public InvalidItemPriceException(Object itemPrice) {
        super(String.format("Price of the Item is cannot be null or zero. Price: %s", itemPrice));
    }
}
