package com.lukastteles.java_api_challenge.gateways.outputs.db.repositories;

import com.lukastteles.java_api_challenge.gateways.outputs.db.entities.CartItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer> {

    CartItemEntity findByProductId(Integer id);

}
