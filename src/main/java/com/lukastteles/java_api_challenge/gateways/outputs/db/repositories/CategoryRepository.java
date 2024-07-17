package com.lukastteles.java_api_challenge.gateways.outputs.db.repositories;

import com.lukastteles.java_api_challenge.gateways.outputs.db.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

    List<CategoryEntity> findAllByNameContaining(String name);
}
