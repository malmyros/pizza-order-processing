package com.example.demo.activities;

import com.example.demo.common.Workflows;
import com.example.demo.dto.orders.OrderAddress;
import com.example.demo.dto.orders.OrderBill;
import io.temporal.spring.boot.ActivityImpl;
import org.springframework.stereotype.Component;

@Component
@ActivityImpl(workers = Workflows.ORDER_WORKER, taskQueues = Workflows.ORDER_TASK_QUEUE)
public class OrderActivitiesImpl implements OrderActivities {

    @Override
    public int getDistance(OrderAddress orderAddress) {
        return 15;
    }

    @Override
    public String sendBill(OrderBill orderBill) {
        return "Send order %s".formatted(orderBill.orderNumber());
    }
}
