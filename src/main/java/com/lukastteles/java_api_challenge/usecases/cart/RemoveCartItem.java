package com.lukastteles.java_api_challenge.usecases.cart;

import com.lukastteles.java_api_challenge.domain.CartItem;
import com.lukastteles.java_api_challenge.gateways.outputs.CartItemDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RemoveCartItem {

    private final CartItemDataGateway cartItemDataGateway;

    public void execute(Integer productId){
        CartItem cartItem = cartItemDataGateway.findByProductId(productId);
        cartItemDataGateway.remove(cartItem);
        log.info("Removed cart item: {}", cartItem);
    }
}
