package com.example.demo.activities;

import com.example.demo.dto.orders.OrderAddress;
import com.example.demo.dto.orders.OrderBill;
import com.example.demo.dto.orders.OrderItem;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.math.BigDecimal;
import java.util.List;

@ActivityInterface
public interface OrderActivities {

    @ActivityMethod
    BigDecimal calculateOrderTotal(List<OrderItem> orderItems);

    @ActivityMethod
    int estimateDeliveryDistance(OrderAddress orderAddress);

    @ActivityMethod
    String sendBill(OrderBill orderBill);
}
