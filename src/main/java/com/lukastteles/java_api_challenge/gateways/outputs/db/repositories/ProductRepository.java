package com.lukastteles.java_api_challenge.gateways.outputs.db.repositories;

import com.lukastteles.java_api_challenge.gateways.outputs.db.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

    List<ProductEntity> findAllByNameContainingOrCategoryNameContaining(String name, String categoryName);

}
