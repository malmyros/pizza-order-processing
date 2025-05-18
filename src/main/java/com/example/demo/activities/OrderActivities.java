package com.example.demo.activities;

import com.example.demo.dto.common.OrderAddress;
import com.example.demo.dto.common.OrderBill;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface OrderActivities {

    @ActivityMethod
    int getDistance(OrderAddress orderAddress);

    @ActivityMethod
    String sendBill(OrderBill orderBill);
}
