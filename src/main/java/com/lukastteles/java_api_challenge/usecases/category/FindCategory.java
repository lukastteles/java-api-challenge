package com.lukastteles.java_api_challenge.usecases.category;

import com.lukastteles.java_api_challenge.domain.Category;
import com.lukastteles.java_api_challenge.exceptions.NotFoundException;
import com.lukastteles.java_api_challenge.gateways.outputs.CategoryDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FindCategory {

    private final CategoryDataGateway categoryDataGateway;

    public Category execute(final Integer id) {
        final Category category = categoryDataGateway.findById(id).orElseThrow(NotFoundException::new);
        log.info("category found: {}", category);
        return category;
    }
}
