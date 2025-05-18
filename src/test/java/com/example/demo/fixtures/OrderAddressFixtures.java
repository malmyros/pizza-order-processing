package com.example.demo.fixtures;

import com.example.demo.dto.orders.OrderAddress;

public class OrderAddressFixtures {

    private OrderAddressFixtures() {
    }

    public static OrderAddress getOrderAddress() {
        return new OrderAddress(
                "701 Mission Street",
                "Apartment 9C",
                "San Francisco",
                "CA",
                "94103"
        );
    }
}
