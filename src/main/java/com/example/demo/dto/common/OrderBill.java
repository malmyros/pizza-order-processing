package com.example.demo.dto.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderBill {

    @JsonDeserialize
    public String orderNumber;

    @JsonDeserialize
    public String customerId;

    @JsonDeserialize
    public BigDecimal amount;

    @JsonDeserialize
    public String description;

    public OrderBill() {
    }

    public OrderBill(String orderNumber, String customerId, BigDecimal amount, String description) {
        this.orderNumber = orderNumber;
        this.customerId = customerId;
        this.amount = amount;
        this.description = description;
    }
}
