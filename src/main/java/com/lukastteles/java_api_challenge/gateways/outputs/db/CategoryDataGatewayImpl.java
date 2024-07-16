package com.lukastteles.java_api_challenge.gateways.outputs.db;

import com.lukastteles.java_api_challenge.domain.Category;
import com.lukastteles.java_api_challenge.gateways.outputs.CategoryDataGateway;
import com.lukastteles.java_api_challenge.gateways.outputs.db.entities.mappers.CategoryEntityMapper;
import com.lukastteles.java_api_challenge.gateways.outputs.db.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Optional.of;

@Component
@RequiredArgsConstructor
@Slf4j
public class CategoryDataGatewayImpl implements CategoryDataGateway {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public Category save(Category category) {
        log.info("Saving category with id: {}", category.getId());
        return of(category)
                .map(categoryEntityMapper::from)
                .map(categoryRepository::save)
                .map(categoryEntityMapper::from)
                .orElseThrow();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        log.info("Finding category with id: {}", id);
        return categoryRepository.findById(id).map(categoryEntityMapper::from);
    }

    @Override
    public void delete(Integer id) {
        log.info("Deleting category with id: {}", id);
        categoryRepository.deleteById(id);
    }
}
