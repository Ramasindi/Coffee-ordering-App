package com.thalukanyo.android.coffeorder;

import com.thalukanyo.android.coffeorder.models.CoffeeOrder;
import com.thalukanyo.android.coffeorder.models.Customer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class CoffeeOrderTest {
    Customer bean = new Customer("Bean" , "0111111111", "me@me.com");
    ArrayList<String> toppings = new ArrayList<String>();
    CoffeeOrder order = new CoffeeOrder("Cappuccino", 22.50, toppings, bean, 1);

    @Test
    public void validateCoffee() {
        String name = "Cappuccino";
        double price = 22.50;
        ArrayList<String> toppings = new ArrayList<String>();
        int quantity = 1;
        Assert.assertEquals("Coffee name", name, order.getCoffeeName());
        Assert.assertEquals("Coffee price", price, order.getCoffeePrice(), 0);
        Assert.assertEquals("Quantity", quantity, order.getQuantity());
        Assert.assertEquals("Extras", toppings, order.getExtras());
    }
}
