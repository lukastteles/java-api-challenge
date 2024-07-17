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

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FindCartItensTest {

    @InjectMocks
    private FindCartItens findCartItens;

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
        when(cartItemDataGateway.list()).thenReturn(List.of(cartItem));
        var cartItensReturned = findCartItens.execute();
        assertEquals(List.of(cartItem), cartItensReturned);
    }

    @Test
    public void shouldExecuteWithNoResult() {
        when(cartItemDataGateway.list()).thenReturn(emptyList());
        var cartItensReturned = findCartItens.execute();
        assertEquals(emptyList(), cartItensReturned);
    }
}
