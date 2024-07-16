package com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers;

import com.lukastteles.java_api_challenge.domain.CartItem;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.CartItemRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartItemRequestMapper {


    List<CartItem> from(List<CartItemRequest> cartItemRequestList);

    @Mapping(target = "product.id", source = "productId")
    CartItem from(CartItemRequest cartItemRequest);
}
