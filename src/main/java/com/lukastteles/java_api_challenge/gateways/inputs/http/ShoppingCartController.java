package com.lukastteles.java_api_challenge.gateways.inputs.http;

import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.CartItemRequest;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.CartItemResponse;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers.CartItemRequestMapper;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers.CartItemResponseMapper;
import com.lukastteles.java_api_challenge.usecases.cart.AddCartItem;
import com.lukastteles.java_api_challenge.usecases.cart.FindCartItens;
import com.lukastteles.java_api_challenge.usecases.cart.RemoveCartItem;
import com.lukastteles.java_api_challenge.usecases.cart.UpdateCartItems;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart")
public class ShoppingCartController {

    //use cases
    private final FindCartItens findCartItens;
    private final AddCartItem addCartItem;
    private final UpdateCartItems updateCartItems;
    private final RemoveCartItem removeCartItem;

    //mappers
    private final CartItemRequestMapper cartItemRequestMapper;
    private final CartItemResponseMapper cartItemResponseMapper;

    @ResponseStatus(OK)
    @GetMapping
    public List<CartItemResponse> listCart() {
        return cartItemResponseMapper.from(findCartItens.execute());
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public List<CartItemResponse> addCartItem(@RequestBody @Valid final CartItemRequest request) {
        return cartItemResponseMapper.from(
                addCartItem.execute(cartItemRequestMapper.from(request))
        );
    }

    @ResponseStatus(CREATED)
    @PutMapping
    public List<CartItemResponse> updateCart(
            @RequestBody @Valid final List<CartItemRequest> request) {
        return cartItemResponseMapper.from(
                updateCartItems.execute(cartItemRequestMapper.from(request))
        );
    }

    @ResponseStatus(OK)
    @DeleteMapping(path = "/{productId}")
    public void removeCartItem(@PathVariable Integer productId) {
        removeCartItem.execute(productId);
    }

}
