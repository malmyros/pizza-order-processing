package com.example.demo.factory;

import com.example.demo.dto.common.OrderBill;
import com.example.demo.dto.orders.OrderRequest;

import java.math.BigDecimal;

public class OrderBillFactory {

    private OrderBillFactory() {
    }

    public static OrderBill getOrderBill(
            OrderRequest orderRequest,
            BigDecimal orderTotalAmount) {

        return new OrderBill(
                orderRequest.orderNumber(),
                orderRequest.customer().customerId,
                orderTotalAmount,
                orderRequest.orderNumber());
    }
}
