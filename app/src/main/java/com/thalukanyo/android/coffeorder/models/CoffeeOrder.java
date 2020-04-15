package com.thalukanyo.android.coffeorder.models;

import java.util.ArrayList;

public class CoffeeOrder {

    private String coffeeName;
    private double coffeePrice;
    private ArrayList<String> extras;
    private Customer customer;
    private int quantity;

    public CoffeeOrder(String coffeeName, double coffeePrice, ArrayList<String> extras, Customer customer, int quantity) {
        this.coffeeName = coffeeName;
        this.coffeePrice = coffeePrice;
        this.extras = extras;
        this.customer = customer;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public double getCoffeePrice() {
        return coffeePrice;
    }

    public void setCoffeePrice(double coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    public ArrayList<String> getExtras() {
        return extras;
    }

    public void setExtras(ArrayList<String> extras) {
        this.extras = extras;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CoffeeOrder{" +
                "coffeeName='" + coffeeName + '\'' +
                ", coffeePrice=" + coffeePrice +
                ", extras=" + extras +
                ", customer=" + customer +
                ", quantity=" + quantity +
                '}';
    }
}
