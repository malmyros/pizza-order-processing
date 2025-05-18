package com.example.demo.dto.orders;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Schema(description = "The order bill")
public record OrderBill(

        @JsonDeserialize
        @NotBlank(message = "The order number cannot be empty")
        @Schema(description = "The unique order number", example = "1747565338")
        String orderNumber,

        @JsonDeserialize
        @NotBlank(message = "The customer id cannot be null")
        @Schema(description = "The customer's unique id", example = "1747565338")
        String customerId,

        @JsonDeserialize
        @NotNull(message = "The amount cannot be null")
        @Schema(description = "The total amount of the order", example = "25.22")
        BigDecimal amount,

        @JsonDeserialize
        @NotBlank(message = "The description cannot be empty")
        @Schema(description = "The order's bill description", example = "Send order 1747565338")
        String description
) {

}
