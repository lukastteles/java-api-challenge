package com.lukastteles.java_api_challenge.usecases.category;

import com.lukastteles.java_api_challenge.gateways.outputs.CategoryDataGateway;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DeleteCategory {

    private final CategoryDataGateway categoryDataGateway;

    public void execute(@NonNull final Integer id) {
        categoryDataGateway.delete(id);
        log.info("category with id: {} deleted", id);
    }
}
