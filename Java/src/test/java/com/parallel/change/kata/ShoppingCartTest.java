package com.parallel.change.kata;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    @Test
    public void singleItem_numberOfProductsInTheCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Item.from(10.2));

        assertEquals(1, shoppingCart.numberOfProducts());
    }

    @Test
    public void singleItem_totalPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Item.from(10.01));

        assertEquals(10.01, shoppingCart.totalPrice(), 0);
    }

    @Test
    public void singleItem_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Item.from(100.0));

        Assert.assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void singleItem_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Item.from(99.0));

        Assert.assertFalse(shoppingCart.hasDiscount());
    }

    @Test
    public void multipleItems_numberOfProductsInTheCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Item.from(1.0));
        shoppingCart.add(Item.from(2.0));

        assertEquals(2, shoppingCart.numberOfProducts());
    }

    @Test
    public void multipleItems_totalPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Item.from(1.0));
        shoppingCart.add(Item.from(2.0));

        assertEquals(3.0, shoppingCart.totalPrice(), 0);
    }

    @Test
    public void multipleItems_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Item.from(100.1));
        shoppingCart.add(Item.from(90.2));

        Assert.assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void multipleItems_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Item.from(99.2));
        shoppingCart.add(Item.from(-100.0));

        Assert.assertFalse(shoppingCart.hasDiscount());
    }

    @Test
    public void shouldHaveNoItemsInShoppingCartIfAddedItemIsNull() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(null);

        assertEquals(0, shoppingCart.numberOfProducts());
    }
}
