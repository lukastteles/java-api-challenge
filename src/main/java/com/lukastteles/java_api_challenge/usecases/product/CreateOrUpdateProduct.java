package com.lukastteles.java_api_challenge.usecases.product;

import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.gateways.outputs.ProductDataGateway;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateOrUpdateProduct {

    private final ProductDataGateway productDataGateway;

    public Product execute(@NonNull final Product product) {
        final Product productSaved = productDataGateway.save(product);
        log.info("Saved product: {}", productSaved);
        return productSaved;
    }
}
