package com.example.demo.dto.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

public class Customer {

    @JsonDeserialize
    public String customerId;

    @JsonDeserialize
    public String name;

    @JsonDeserialize
    public String email;

    @JsonDeserialize
    public String phone;

    public Customer() {
    }

    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
