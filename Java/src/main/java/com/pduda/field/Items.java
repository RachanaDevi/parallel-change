package com.pduda.field;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Items {

    private final List<Item> items;

    public Items() {
        items = new ArrayList<>();
    }

    public Double totalPrice() {
        return items.stream().reduce(Item::addPriceOf).orElse(Item.zeroPrice()).value();
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
}