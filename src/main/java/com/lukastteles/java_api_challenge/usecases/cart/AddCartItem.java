package com.lukastteles.java_api_challenge.usecases.cart;

import com.lukastteles.java_api_challenge.domain.CartItem;
import com.lukastteles.java_api_challenge.gateways.outputs.CartItemDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Optional.of;

@Component
@RequiredArgsConstructor
@Slf4j
public class AddCartItem {

    private final CartItemDataGateway cartItemDataGateway;

    public List<CartItem> execute(CartItem cartItem){
        of(cartItem)
                .map(c -> cartItemDataGateway.findByProductId(c.getProduct().getId()))
                .ifPresentOrElse(
                    c -> {
                        c.setQuantity(cartItem.getQuantity());
                        cartItemDataGateway.save(c);
                    },
                    () -> cartItemDataGateway.save(cartItem)
                );
        log.info("Added cart item: {}", cartItem);
        return cartItemDataGateway.list();
    }
}
