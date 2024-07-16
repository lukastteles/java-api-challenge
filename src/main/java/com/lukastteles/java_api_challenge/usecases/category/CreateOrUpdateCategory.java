package com.lukastteles.java_api_challenge.usecases.category;

import com.lukastteles.java_api_challenge.domain.Category;
import com.lukastteles.java_api_challenge.gateways.outputs.CategoryDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateOrUpdateCategory {

    private final CategoryDataGateway categoryDataGateway;

    public Category execute(final Category product) {
        final Category categorySaved = categoryDataGateway.save(product);
        log.info("Saved category: {}", categorySaved);
        return categorySaved;
    }
}
