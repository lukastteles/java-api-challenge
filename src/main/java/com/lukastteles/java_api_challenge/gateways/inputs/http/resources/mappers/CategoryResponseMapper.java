package com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers;

import com.lukastteles.java_api_challenge.domain.Category;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryResponseMapper {

    CategoryResponse from(Category category);
}
