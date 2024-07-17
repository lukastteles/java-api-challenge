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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UpdateCartItemsTest {

    @InjectMocks
    private UpdateCartItems updateCartItems;

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
        when(cartItemDataGateway.save(any())).thenReturn(cartItem);
        when(cartItemDataGateway.findByProductId(any())).thenReturn(cartItem);
        when(cartItemDataGateway.list()).thenReturn(List.of(cartItem));
        var cartItensReturned = updateCartItems.execute(List.of(cartItem));
        assertEquals(List.of(cartItem), cartItensReturned);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsExceptionWhenInvalidParameters() {
        updateCartItems.execute(null);
    }
}
