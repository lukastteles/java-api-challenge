package com.lukastteles.java_api_challenge.gateways.inputs.http.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    @Schema(description = "Product ID", example = "123")
    private Integer id;

    @Schema(description = "Product name", example = "name test")
    private String name;

    @Schema(description = "Product price", example = "1.23")
    private BigDecimal price;

    @Schema(description = "Category")
    private CategoryResponse category;
}
