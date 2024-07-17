package com.lukastteles.java_api_challenge.usecases.product;

import com.lukastteles.java_api_challenge.domain.Category;
import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.gateways.outputs.ProductDataGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateOrUpdateProductTest {

    @InjectMocks
    private CreateOrUpdateProduct createOrUpdateProduct;

    @Mock
    private ProductDataGateway productDataGateway;

    private Product product;

    @Before
    public void init() {
        product = Product.builder()
                .id(1)
                .name("Teste")
                .category(Category.builder().id(1).build())
                .build();
    }

    @Test
    public void shouldExecute() {
        when(productDataGateway.save(any())).thenReturn(product);
        var productReturned = createOrUpdateProduct.execute(product);
        assertEquals(product, productReturned);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsExceptionWhenInvalidParameters() {
        createOrUpdateProduct.execute(null);
    }
}
