package com.example.demo.fixtures;

import com.example.demo.dto.orders.OrderBill;
import com.example.demo.dto.orders.OrderRequest;
import com.example.demo.factory.OrderBillFactory;
import com.example.demo.utils.OrderUtils;

public class OrderBillFixtures {

    private OrderBillFixtures() {
    }

    public static OrderBill getOrderBill() {

        OrderRequest orderRequest = OrderRequestFixtures.getOrderRequest();
        return OrderBillFactory.getOrderBill(
                orderRequest,
                OrderUtils.getTotalOrderAmount(orderRequest.orderItems()));
    }
}
