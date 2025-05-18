package com.example.demo.dto.orders;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "The customer's address")
public record OrderAddress(

        @JsonDeserialize
        @NotBlank(message = "The line 1 address cannot be empty")
        @Schema(description = "The line 1 address", example = "701 Mission Street")
        String line1,

        @JsonDeserialize
        @NotBlank(message = "The line 2 address cannot be empty")
        @Schema(description = "The line 2 address", example = "Apartment 9C")
        String line2,

        @JsonDeserialize
        @NotBlank(message = "The city cannot be empty")
        @Schema(description = "The city of the address", example = "San Francisco")
        String city,

        @JsonDeserialize
        @NotBlank(message = "The state cannot be empty")
        @Schema(description = "The state of the address", example = "CA")
        String state,

        @JsonDeserialize
        @NotBlank(message = "The postcode cannot be empty")
        @Schema(description = "The postcode of the address", example = "94103")
        String postcode
) {
}
