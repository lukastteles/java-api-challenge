package com.lukastteles.java_api_challenge.gateways.outputs.db.repositories;

import com.lukastteles.java_api_challenge.gateways.outputs.db.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

}
