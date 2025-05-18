package com.example.demo.fixtures;

import com.example.demo.dto.orders.OrderRequest;

public class OrderRequestFixtures {

    private OrderRequestFixtures() {
    }

    public static OrderRequest getOrderRequest() {
        return new OrderRequest(
                "1747568868",
                CustomerFixtures.getCustomer(),
                OrderItemFixtures.getOrderItems(),
                true,
                OrderAddressFixtures.getOrderAddress()
        );
    }
}
