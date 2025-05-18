package com.example.demo.dto.orders;


import com.example.demo.dto.customers.Customer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(description = "The pizza order request")
public record OrderRequest(

        @JsonDeserialize
        @NotBlank(message = "The order number cannot be empty")
        @Schema(description = "The unique order number", example = "1747565338")
        String orderNumber,

        @JsonDeserialize
        @NotNull(message = "The customer cannot be null")
        @Schema(description = "The customer that is ordering the pizza")
        Customer customer,

        @JsonDeserialize
        @NotEmpty(message = "The order items cannot be empty")
        @Schema(description = "The pizzas the customer is ordering")
        List<@NotNull OrderItem> orderItems,

        @JsonDeserialize
        @Schema(description = "Whether the order should be delivered or picked up", example = "true")
        boolean isDelivery,

        @JsonDeserialize
        @NotNull(message = "The order address cannot be null")
        @Schema(description = "The address the pizza's will be delivered at")
        OrderAddress orderAddress
) {
}
