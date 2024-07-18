package com.lukastteles.java_api_challenge.gateways.outputs.db;

import com.lukastteles.java_api_challenge.domain.CartItem;
import com.lukastteles.java_api_challenge.gateways.outputs.CartItemDataGateway;
import com.lukastteles.java_api_challenge.gateways.outputs.db.entities.mappers.CartItemEntityMapper;
import com.lukastteles.java_api_challenge.gateways.outputs.db.repositories.CartItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Optional.of;

@Component
@RequiredArgsConstructor
@Slf4j
public class CartItemDataGatewayImpl implements CartItemDataGateway {

    private final CartItemRepository cartItemRepository;
    private final CartItemEntityMapper cartItemEntityMapper;

    @Override
    public List<CartItem> list() {
        log.info("Listing cart itens");
        return of(cartItemRepository.findAll())
                .map(cartItemEntityMapper::from)
                .orElseThrow();
    }

    @Override
    public CartItem findByProductId(Integer productId) {
        return of(productId)
                .map(cartItemRepository::findByProductId)
                .map(cartItemEntityMapper::from)
                .orElse(null);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        log.info("Saving Cart Item with pruduct id: {}", cartItem.getProduct().getId());
        return of(cartItem)
                .map(cartItemEntityMapper::from)
                .map(cartItemRepository::save)
                .map(cartItemEntityMapper::from)
                .orElseThrow();
    }

    @Override
    public void remove(CartItem cartItem) {
        log.info("Deleting Cart Item with product id: {}", cartItem.getProduct().getId());
        cartItemRepository.delete(cartItemEntityMapper.from(cartItem));
    }
}
