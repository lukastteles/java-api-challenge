package com.lukastteles.java_api_challenge.gateways.outputs.db;

import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.gateways.outputs.ProductDataGateway;
import com.lukastteles.java_api_challenge.gateways.outputs.db.entities.mappers.ProductEntityMapper;
import com.lukastteles.java_api_challenge.gateways.outputs.db.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Optional.of;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductDataGatewayImpl implements ProductDataGateway {

    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public Product save(Product product) {
        log.info("Saving product with id: {}", product.getId());
        return of(product)
                .map(productEntityMapper::from)
                .map(productRepository::save)
                .map(p -> productRepository.findById(p.getId()).orElseThrow())
                .map(productEntityMapper::from)
                .orElseThrow();
    }

    @Override
    public Product findById(Integer id) {
        log.info("Finding product with id: {}", id);
        return productRepository.findById(id)
                .map(productEntityMapper::from)
                .orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        log.info("Deleting product with id: {}", id);
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllByNameAndCategoryName(String name, String categoryName) {
        return productEntityMapper.from(
                productRepository.findAllByNameContainingOrCategoryNameContaining(name, categoryName)
        );
    }
}
