package com.thalukanyo.android.coffeorder;

import com.thalukanyo.android.coffeorder.models.CoffeeOrder;
import com.thalukanyo.android.coffeorder.models.Customer;

import org.junit.Assert;
import org.junit.Test;


public class CoffeeOrderTest {
    Customer bean = new Customer("Bean" , "0111111111");
    String[] toppings = {};
    CoffeeOrder order = new CoffeeOrder("Cappuccino", 22.50, toppings, bean, 1);

    @Test
    public void validateCoffee() {
        String name = "Cappuccino";
        double price = 22.50;
        String[] toppings = {};
        int quantity = 1;
        Assert.assertEquals("Coffee name", name, order.getCoffeeName());
        Assert.assertEquals("Coffee price", price, order.getCoffeePrice(), 0);
        Assert.assertEquals("Quantity", quantity, order.getQuantity());
        Assert.assertArrayEquals("Extras", toppings, order.getExtras());

    }
}
