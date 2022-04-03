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

    public Price totalPrice() {
        return prices().reduce(Price::add).orElse(Price.zero());
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

    private Stream<Price> prices() {
        return items.stream().map(Item::price);
    }
}