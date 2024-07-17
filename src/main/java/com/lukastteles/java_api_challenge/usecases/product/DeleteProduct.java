package com.lukastteles.java_api_challenge.usecases.product;

import com.lukastteles.java_api_challenge.gateways.outputs.ProductDataGateway;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DeleteProduct {

    private final ProductDataGateway productDataGateway;

    public void execute(@NonNull final Integer id) {
        productDataGateway.delete(id);
        log.info("product with id: {} deleted", id);
    }
}
