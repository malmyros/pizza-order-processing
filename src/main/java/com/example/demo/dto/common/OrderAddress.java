package com.example.demo.dto.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class OrderAddress {

    @JsonDeserialize
    public String line1;

    @JsonDeserialize
    public String line2;

    @JsonDeserialize
    public String city;

    @JsonDeserialize
    public String state;

    @JsonDeserialize
    public String postcode;

    public OrderAddress() {
    }

    public OrderAddress(String line1, String line2, String city, String state, String postcode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
    }
}
