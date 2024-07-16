package com.lukastteles.java_api_challenge.gateways.outputs.db.entities.mappers;

import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.gateways.outputs.db.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    ProductEntity from(Product product);

    Product from(ProductEntity productEntity);
}
