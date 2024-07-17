package com.lukastteles.java_api_challenge.gateways.outputs;

import com.lukastteles.java_api_challenge.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDataGateway {

    Product save(Product product);

    Optional<Product> findById(Integer id);

    void delete(Integer id);

    List<Product> findAllByNameAndCategoryName(String name, String categoryName);
}
