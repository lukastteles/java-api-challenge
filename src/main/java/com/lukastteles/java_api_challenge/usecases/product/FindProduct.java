package com.lukastteles.java_api_challenge.usecases.product;

import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.exceptions.NotFoundException;
import com.lukastteles.java_api_challenge.gateways.outputs.ProductDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FindProduct {

    private final ProductDataGateway productDataGateway;

    public Product execute(final Integer id) {
        final Product product = productDataGateway.findById(id).orElseThrow(NotFoundException::new);
        log.info("product found: {}", product);
        return product;
    }

}
