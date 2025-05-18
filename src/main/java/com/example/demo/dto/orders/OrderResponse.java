package com.example.demo.dto.orders;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderResponse(

        String orderNumber,

        BigDecimal totalAmount,

        Instant orderDate
) {
}
