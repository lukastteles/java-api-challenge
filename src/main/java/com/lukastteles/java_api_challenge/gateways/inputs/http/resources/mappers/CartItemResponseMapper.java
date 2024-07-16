package com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers;

import com.lukastteles.java_api_challenge.domain.CartItem;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.CartItemResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartItemResponseMapper {

    List<CartItemResponse> from(List<CartItem> cartItems);
}
