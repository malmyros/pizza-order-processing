package com.example.demo.utils;

import com.example.demo.dto.orders.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class OrderUtils {

    private OrderUtils() {
    }

    public static BigDecimal getTotalOrderAmount(
            List<OrderItem> orderItems) {

        return orderItems
                .stream()
                .map(OrderItem::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
