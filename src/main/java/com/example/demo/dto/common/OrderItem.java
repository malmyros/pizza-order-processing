package com.example.demo.dto.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;

public class OrderItem {

    @JsonDeserialize
    public String description;

    @JsonDeserialize
    public BigDecimal price;

    public OrderItem() {
    }

    public OrderItem(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }
}
