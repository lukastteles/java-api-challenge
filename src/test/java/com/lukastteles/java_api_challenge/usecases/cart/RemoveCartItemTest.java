package com.lukastteles.java_api_challenge.usecases.cart;

import com.lukastteles.java_api_challenge.domain.CartItem;
import com.lukastteles.java_api_challenge.domain.Product;
import com.lukastteles.java_api_challenge.gateways.outputs.CartItemDataGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RemoveCartItemTest {

    @InjectMocks
    private RemoveCartItem removeCartItem;

    @Mock
    private CartItemDataGateway cartItemDataGateway;

    private CartItem cartItem;

    @Before
    public void init() {
        cartItem = CartItem.builder()
                .id(1)
                .product(Product.builder().id(1).build())
                .build();
    }

    @Test
    public void shouldExecute() {
        when(cartItemDataGateway.findByProductId(any())).thenReturn(cartItem);
        removeCartItem.execute(cartItem.getProduct().getId());
        verify(cartItemDataGateway, times(1)).remove(cartItem);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsExceptionWhenInvalidParameters() {
        removeCartItem.execute(null);
    }
}
