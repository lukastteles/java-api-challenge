package com.lukastteles.java_api_challenge.gateways.outputs.db.entities.mappers;

import com.lukastteles.java_api_challenge.domain.CartItem;
import com.lukastteles.java_api_challenge.gateways.outputs.db.entities.CartItemEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartItemEntityMapper {

    CartItem from(CartItemEntity cartItemEntity);

    CartItemEntity from(CartItem cartItem);

    List<CartItem> from(Iterable<CartItemEntity> cartItemEntityIterable);

    Iterable<CartItemEntity> from(List<CartItem> cartItems);

}
