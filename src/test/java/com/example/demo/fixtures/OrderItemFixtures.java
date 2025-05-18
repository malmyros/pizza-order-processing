package com.example.demo.fixtures;

import com.example.demo.dto.orders.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class OrderItemFixtures {

    public static OrderItem getLargePizza() {
        return new OrderItem(
                "Large, with pepperoni",
                new BigDecimal("15.00"));
    }

    public static OrderItem getSmallPizza() {
        return new OrderItem(
                "Small, with mushrooms and onions",
                new BigDecimal("10.00"));
    }

    public static List<OrderItem> getOrderItems() {
        return List.of(
                OrderItemFixtures.getLargePizza(),
                OrderItemFixtures.getSmallPizza()
        );
    }
}
