package com.example.demo.activities;

import com.example.demo.dto.orders.OrderAddress;
import com.example.demo.dto.orders.OrderBill;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface OrderActivities {

    @ActivityMethod
    int getDistance(OrderAddress orderAddress);

    @ActivityMethod
    String sendBill(OrderBill orderBill);
}
