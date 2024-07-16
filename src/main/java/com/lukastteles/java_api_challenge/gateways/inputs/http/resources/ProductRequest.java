package com.lukastteles.java_api_challenge.gateways.inputs.http.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    @NotBlank( message = "Product name is mandatory")
    @Schema(description = "Product name", example = "name test", requiredMode = REQUIRED)
    private String name;

    @NotNull( message = "Product price is mandatory")
    @Schema(description = "Product price", example = "1.23", requiredMode = REQUIRED)
    private BigDecimal price;

    @NotNull( message = "Category ID is mandatory")
    @Schema(description = "Category ID", example = "321", requiredMode = REQUIRED)
    private Integer categoryId;

}
