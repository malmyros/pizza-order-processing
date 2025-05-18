package com.example.demo.dto.orders;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Schema(description = "The order item")
public record OrderItem(

        @JsonDeserialize
        @NotBlank(message = "The order item description cannot be empty")
        @Schema(description = "The order items description", example = "Large pizza, with pepperoni")
        String description,

        @JsonDeserialize
        @NotNull(message = "The price of the order item cannot be null")
        @Schema(description = "The order item's price", example = "15.22")
        BigDecimal price
) {

}
