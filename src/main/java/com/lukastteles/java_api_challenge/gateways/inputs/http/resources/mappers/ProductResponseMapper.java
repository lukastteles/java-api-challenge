package com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers;

import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CategoryResponseMapper.class)
public interface ProductResponseMapper {

    ProductResponse from(Product product);
}
