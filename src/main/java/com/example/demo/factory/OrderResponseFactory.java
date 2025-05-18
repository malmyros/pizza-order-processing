package com.example.demo.factory;

import com.example.demo.dto.orders.OrderResponse;

import java.math.BigDecimal;
import java.time.Instant;

public class OrderResponseFactory {

    private OrderResponseFactory() {
    }

    public static OrderResponse getOrderResponse(
            String orderNumber,
            BigDecimal totalOrderAmount) {

        return new OrderResponse(
                orderNumber,
                totalOrderAmount,
                Instant.now());
    }
}
