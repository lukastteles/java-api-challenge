package com.lukastteles.java_api_challenge.usecases.cart;

import com.lukastteles.java_api_challenge.domain.CartItem;
import com.lukastteles.java_api_challenge.gateways.outputs.CartItemDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class FindCartItens {

    private final CartItemDataGateway cartItemDataGateway;

    public List<CartItem> execute() {
        List<CartItem> cartItems = cartItemDataGateway.list();
        log.info("Cart items found: {}", cartItems);
        return cartItems;
    }


}
