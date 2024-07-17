package com.lukastteles.java_api_challenge.usecases.product;

import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.gateways.outputs.ProductDataGateway;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class FindProduct {

    private final ProductDataGateway productDataGateway;

    public Product execute(@NonNull final Integer id) {
        final Product product = productDataGateway.findById(id);
        log.info("product found: {}", product);
        return product;
    }

    public List<Product> execute(final String name, final String categoryName) {
        final List<Product> products = productDataGateway.findAllByNameAndCategoryName(name, categoryName);
        log.info("products found: {}", products);
        return products;
    }

}
