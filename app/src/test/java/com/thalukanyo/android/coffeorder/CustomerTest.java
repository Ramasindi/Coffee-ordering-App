package com.thalukanyo.android.coffeorder;

import com.thalukanyo.android.coffeorder.models.Customer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
    private Customer bean;

    @Before
    public void initialize(){
        bean = new Customer("Bean" , "0111111111", "me@me.com");
    }


    @Test
    public void validatedCustomer(){
        Assert.assertEquals("Customer name ", "Bean", bean.getCustomerName());
        Assert.assertEquals("Customer mobile ", "0111111111", bean.getCustomerPhoneNumber());
    }

    @Test
    public void validatePhoneNumber(){
        Assert.assertTrue(bean.isPhoneNumberValid("0111111111"));

    }
}
