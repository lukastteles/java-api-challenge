package com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers;

import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {

    Product from(ProductRequest productRequest);

    @Mapping(target = "name", source = "productRequest.name")
    @Mapping(target = "value", source = "productRequest.value")
    @Mapping(target = "id", source = "id")
    Product from(ProductRequest productRequest, Integer id);

}
