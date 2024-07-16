package com.lukastteles.java_api_challenge.gateways.outputs;

import com.lukastteles.java_api_challenge.domain.CartItem;

import java.util.List;

public interface CartItemDataGateway {

    List<CartItem> list();

    CartItem findByProductId(Integer productId);

    CartItem save(CartItem cartItem);

    void remove(CartItem cartItem);
}
