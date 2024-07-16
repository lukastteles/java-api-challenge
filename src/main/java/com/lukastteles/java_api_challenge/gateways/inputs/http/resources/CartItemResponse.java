package com.lukastteles.java_api_challenge.gateways.inputs.http.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemResponse {

    @Schema(description = "Product")
    private ProductResponse product;

    @Schema(description = "Quantity", example = "1")
    private Integer quantity;
}
