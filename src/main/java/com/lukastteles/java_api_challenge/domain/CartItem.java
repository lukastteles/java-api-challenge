package com.lukastteles.java_api_challenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    private Integer id;
    private Product product;
    private Integer quantity;
}
