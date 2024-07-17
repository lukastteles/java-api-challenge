package com.lukastteles.java_api_challenge.gateways.outputs;

import com.lukastteles.java_api_challenge.domain.Category;

import java.util.List;

public interface CategoryDataGateway {

    Category save(Category category);

    Category findById(Integer id);

    void delete(Integer id);

    List<Category> findAllByName(String name);
}
