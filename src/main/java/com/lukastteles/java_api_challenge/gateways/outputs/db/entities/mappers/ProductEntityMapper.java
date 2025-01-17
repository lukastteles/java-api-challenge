package com.lukastteles.java_api_challenge.gateways.outputs.db.entities.mappers;

import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.gateways.outputs.db.entities.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CategoryEntityMapper.class)
public interface ProductEntityMapper {

    ProductEntity from(Product product);

    Product from(ProductEntity productEntity);

    List<Product> from(List<ProductEntity> productEntities);
}
