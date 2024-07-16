package com.lukastteles.java_api_challenge.gateways.inputs.http.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

    @Schema(description = "Category ID", example = "123")
    private Integer id;

    @Schema(description = "Category name", example = "name test")
    private String name;

}
