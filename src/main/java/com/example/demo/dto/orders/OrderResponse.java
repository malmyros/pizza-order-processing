package com.example.demo.dto.orders;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.Instant;

@Schema(description = "The pizza order response")
public record OrderResponse(

        @JsonDeserialize
        @NotBlank(message = "The order number cannot be empty")
        @Schema(description = "The unique order number", example = "1747565338")
        String orderNumber,

        @JsonDeserialize
        @NotNull(message = "The total amount cannot be null")
        @Schema(description = "The total amount of the order", example = "25.22")
        BigDecimal totalAmount,

        @JsonDeserialize
        @NotNull(message = "The order date cannot be null")
        @Schema(description = "The date the order was placed", example = "2025-05-18T10:48:58.017998Z")
        Instant orderDate
) {
}
