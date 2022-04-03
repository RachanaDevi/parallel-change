package com.parallel.change.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Items {

    private final List<Item> items;

    public Items() {
        items = new ArrayList<>();
    }

    public Double totalPrice() {
        return prices().reduce(Price.ZERO, Double::sum);
    }

    public boolean eligibleForDiscount() {
        return items.stream().anyMatch(Item::isEligibleForDiscount);
    }

    public int size() {
        return items.size();
    }

    public void add(Item item) {
        if (!Objects.isNull(item))
            items.add(item);
    }

    // breaking encapsulation as we are exposing value from Item,
    // but we can put it in the same package so
    // that is not accessible from outside, hence saving it
    private Stream<Double> prices() {
        return items.stream().map(Item::value);
    }
}