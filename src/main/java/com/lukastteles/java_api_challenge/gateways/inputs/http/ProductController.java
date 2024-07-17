package com.lukastteles.java_api_challenge.gateways.inputs.http;

import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.ProductRequest;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.ProductResponse;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers.ProductRequestMapper;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers.ProductResponseMapper;
import com.lukastteles.java_api_challenge.usecases.product.CreateOrUpdateProduct;
import com.lukastteles.java_api_challenge.usecases.product.DeleteProduct;
import com.lukastteles.java_api_challenge.usecases.product.FindProduct;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    //use cases
    private final CreateOrUpdateProduct createOrUpdateProduct;
    private final FindProduct findProduct;
    private final DeleteProduct deleteProduct;


    //mappers
    private final ProductRequestMapper productRequestMapper;
    private  final ProductResponseMapper productResponseMapper;

    @ResponseStatus(OK)
    @GetMapping(path = "/{id}")
    public ProductResponse getProduct(@PathVariable Integer id) {
        return productResponseMapper.from(findProduct.execute(id));
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<ProductResponse> getProductsByNameOrCategoryName(
            @RequestParam(required = false) String containingName,
            @RequestParam(required = false) String containingCategoryName) {
        return productResponseMapper.from(findProduct.execute(containingName, containingCategoryName));
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public ProductResponse createProduct(@RequestBody @Valid final ProductRequest request) {
        return productResponseMapper.from(
                createOrUpdateProduct.execute(productRequestMapper.from(request))
        );
    }

    @ResponseStatus(CREATED)
    @PutMapping(path = "/{id}")
    public ProductResponse updateProduct(
            @PathVariable Integer id,
            @RequestBody @Valid final ProductRequest request) {
        return productResponseMapper.from(
                createOrUpdateProduct.execute(productRequestMapper.from(request, id))
        );
    }

    @ResponseStatus(OK)
    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        deleteProduct.execute(id);
    }
}
