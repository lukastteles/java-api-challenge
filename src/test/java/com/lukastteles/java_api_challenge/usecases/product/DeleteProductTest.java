package com.lukastteles.java_api_challenge.usecases.product;

import com.lukastteles.java_api_challenge.domain.Category;
import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.gateways.outputs.CategoryDataGateway;
import com.lukastteles.java_api_challenge.gateways.outputs.ProductDataGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class DeleteProductTest {

    @InjectMocks
    private DeleteProduct deleteProduct;

    @Mock
    private ProductDataGateway productDataGateway;

    @Mock
    private CategoryDataGateway categoryDataGateway;

    private Product product;
    private Category category;

    @Before
    public void init() {
        category = Category.builder()
                .id(1)
                .name("categoria")
                .build();
        product = Product.builder()
                .id(1)
                .name("Produto")
                .category(category)
                .build();
    }

    @Test
    public void shouldExecute() {
        categoryDataGateway.save(category);
        productDataGateway.save(product);

        deleteProduct.execute(product.getId());

        assertNull(productDataGateway.findById(product.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsExceptionWhenInvalidParameters() {
        deleteProduct.execute(null);
    }
}
