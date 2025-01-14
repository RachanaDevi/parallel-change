package com.pduda.field;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    @Test
    public void singleItem_numberOfProductsInTheCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10.2);

        assertEquals(1, shoppingCart.numberOfProducts());
    }

    @Test
    public void singleItem_totalPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10.01);

        assertEquals(10, shoppingCart.calculateTotalPrice());
    }

    @Test
    public void singleItem_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(100.0);

        Assert.assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void singleItem_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(99.0);

        Assert.assertFalse(shoppingCart.hasDiscount());
    }

    @Test
    public void multipleItems_numberOfProductsInTheCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(1);
        shoppingCart.add(2);

        assertEquals(2, shoppingCart.numberOfProducts());
    }

    @Test
    public void multipleItems_totalPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(1);
        shoppingCart.add(2);

        assertEquals(3, shoppingCart.calculateTotalPrice());
    }

    @Test
    public void multipleItems_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(100.1);
        shoppingCart.add(90.2);

        Assert.assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void multipleItems_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(99.2);
        shoppingCart.add(-100);

        Assert.assertFalse(shoppingCart.hasDiscount());
    }
}
