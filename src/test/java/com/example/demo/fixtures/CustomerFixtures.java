package com.example.demo.fixtures;

import com.example.demo.dto.customers.Customer;

public class CustomerFixtures {

    private CustomerFixtures() {
    }

    public static Customer getCustomer() {

        return new Customer(
                "12938",
                "Maria Garcia",
                "marcia1985@example.com",
                "0789231231"
        );
    }
}
