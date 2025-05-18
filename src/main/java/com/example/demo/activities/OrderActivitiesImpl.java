package com.example.demo.activities;

import com.example.demo.common.Workflows;
import com.example.demo.dto.orders.OrderAddress;
import com.example.demo.dto.orders.OrderBill;
import com.example.demo.dto.orders.OrderItem;
import com.example.demo.utils.OrderUtils;
import io.temporal.spring.boot.ActivityImpl;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@ActivityImpl(workers = Workflows.ORDER_WORKER, taskQueues = Workflows.ORDER_TASK_QUEUE)
public class OrderActivitiesImpl implements OrderActivities {

    @Override
    public BigDecimal calculateOrderTotal(List<OrderItem> orderItems) {
        return OrderUtils.getTotalOrderAmount(orderItems);
    }

    @Override
    public int estimateDeliveryDistance(OrderAddress orderAddress) {
        return 15;
    }

    @Override
    public String sendBill(OrderBill orderBill) {
        return "Send order %s".formatted(orderBill.orderNumber());
    }
}
