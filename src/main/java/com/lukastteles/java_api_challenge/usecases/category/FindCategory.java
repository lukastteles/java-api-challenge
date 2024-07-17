package com.lukastteles.java_api_challenge.usecases.category;

import com.lukastteles.java_api_challenge.domain.Category;
import com.lukastteles.java_api_challenge.gateways.outputs.CategoryDataGateway;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class FindCategory {

    private final CategoryDataGateway categoryDataGateway;

    public Category execute(@NonNull final Integer id) {
        final Category category = categoryDataGateway.findById(id);
        log.info("category found: {}", category);
        return category;
    }

    public List<Category> execute(final String name) {
        final List<Category> categories = categoryDataGateway.findAllByName(name);
        log.info("categories found: {}", categories);
        return categories;
    }
}
