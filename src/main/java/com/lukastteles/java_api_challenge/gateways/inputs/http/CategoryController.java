package com.lukastteles.java_api_challenge.gateways.inputs.http;

import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.CategoryRequest;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.CategoryResponse;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers.CategoryRequestMapper;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers.CategoryResponseMapper;
import com.lukastteles.java_api_challenge.usecases.category.CreateOrUpdateCategory;
import com.lukastteles.java_api_challenge.usecases.category.DeleteCategory;
import com.lukastteles.java_api_challenge.usecases.category.FindCategory;
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
@RequestMapping(value = "/categories")
public class CategoryController {

    //use cases
    private final CreateOrUpdateCategory createOrUpdateCategory;
    private final FindCategory findCategory;
    private final DeleteCategory deleteCategory;

    //mappers
    private final CategoryRequestMapper categoryRequestMapper;
    private final CategoryResponseMapper categoryResponseMapper;

    @ResponseStatus(OK)
    @GetMapping(path = "/{id}")
    public CategoryResponse getCategory(@PathVariable Integer id) {
        return categoryResponseMapper.from(findCategory.execute(id));
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<CategoryResponse> getCategoriesByName(
            @RequestParam String containingName) {
        return categoryResponseMapper.from(findCategory.execute(containingName));
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public CategoryResponse createCategory(@RequestBody @Valid final CategoryRequest request) {
        return categoryResponseMapper.from(
                createOrUpdateCategory.execute(categoryRequestMapper.from(request))
        );
    }

    @ResponseStatus(CREATED)
    @PutMapping(path = "/{id}")
    public CategoryResponse updateCategory(
            @PathVariable Integer id,
            @RequestBody @Valid final CategoryRequest request) {
        return categoryResponseMapper.from(
                createOrUpdateCategory.execute(categoryRequestMapper.from(request, id))
        );
    }

    @ResponseStatus(OK)
    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        deleteCategory.execute(id);
    }

}
