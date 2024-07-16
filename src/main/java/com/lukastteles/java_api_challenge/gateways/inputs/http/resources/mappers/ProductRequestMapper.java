package com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers;

import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {

    @Mapping(target = "category.id", source = "categoryId")
    Product from(ProductRequest productRequest);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "productRequest.name")
    @Mapping(target = "price", source = "productRequest.price")
    @Mapping(target = "category.id", source = "productRequest.categoryId")
    Product from(ProductRequest productRequest, Integer id);

}
