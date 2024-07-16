package com.lukastteles.java_api_challenge.gateways.outputs;

import com.lukastteles.java_api_challenge.domain.Category;

import java.util.Optional;

public interface CategoryDataGateway {

    Category save(Category category);

    Optional<Category> findById(Integer id);

    void delete(Integer id);
}
