package com.lukastteles.java_api_challenge.usecases.category;

import com.lukastteles.java_api_challenge.domain.Category;
import com.lukastteles.java_api_challenge.gateways.outputs.CategoryDataGateway;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateOrUpdateCategory {

    private final CategoryDataGateway categoryDataGateway;

    public Category execute(@NonNull final Category category) {
        final Category categorySaved = categoryDataGateway.save(category);
        log.info("Saved category: {}", categorySaved);
        return categorySaved;
    }
}
