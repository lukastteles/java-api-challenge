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
public class UpdateCartItems {

    private final CartItemDataGateway cartItemDataGateway;

    public List<CartItem> execute(List<CartItem> cartItems){
        for (CartItem item: cartItems){
            CartItem cartItem = cartItemDataGateway.findByProductId(item.getProduct().getId());
            if(cartItem != null){
                cartItem.setQuantity(item.getQuantity());
            }
            cartItemDataGateway.save(cartItem);
        }
        return cartItemDataGateway.list();
    }
}
