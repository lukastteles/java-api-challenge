package com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers;

import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CategoryResponseMapper.class)
public interface ProductResponseMapper {

    ProductResponse from(Product product);

    List<ProductResponse> from(List<Product> products);
}
