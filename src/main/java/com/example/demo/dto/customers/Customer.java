package com.example.demo.dto.customers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "The customer ordering a pizza")
public record Customer(

        @JsonDeserialize
        @NotBlank(message = "The customer id cannot be null")
        @Schema(description = "The customer's unique id", example = "1747565338")
        String customerId,

        @JsonDeserialize
        @NotBlank(message = "The customer's name cannot be empty")
        @Schema(description = "The customer's full name", example = "Michail Almyros")
        String name,

        @JsonDeserialize
        @NotBlank(message = "The customer's e-mail address cannot be empty")
        @Schema(description = "The customer's e-mail address", example = "customer@example.com")
        String email,

        @JsonDeserialize
        @NotBlank(message = "The customer's phone number cannot be empty")
        @Schema(description = "The customer's phone number", example = "0789231231")
        String phone
) {
}
