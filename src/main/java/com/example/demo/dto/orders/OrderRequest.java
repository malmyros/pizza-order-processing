package com.example.demo.dto.orders;

import com.example.demo.dto.common.OrderAddress;
import com.example.demo.dto.common.Customer;
import com.example.demo.dto.common.OrderItem;

import java.util.List;

public record OrderRequest(

        String orderNumber,

        Customer customer,

        List<OrderItem> orderItems,

        boolean isDelivery,

        OrderAddress orderAddress
) {
}
