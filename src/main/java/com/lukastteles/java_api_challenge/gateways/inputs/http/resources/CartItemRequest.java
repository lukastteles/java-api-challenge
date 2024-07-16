package com.lukastteles.java_api_challenge.gateways.inputs.http.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemRequest {

    @NotNull( message = "Product id is mandatory")
    @Schema(description = "Product id", example = "123", requiredMode = REQUIRED)
    private Integer productId;

    @NotNull( message = "Quantity is mandatory")
    @Schema(description = "Quantity", example = "1", requiredMode = REQUIRED)
    private Integer quantity;

}
