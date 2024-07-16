package com.lukastteles.java_api_challenge.gateways.inputs.http.resources.mappers;

import com.lukastteles.java_api_challenge.domain.Category;
import com.lukastteles.java_api_challenge.gateways.inputs.http.resources.CategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryRequestMapper {

    Category from(CategoryRequest categoryRequest);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "categoryRequest.name")
    Category from(CategoryRequest categoryRequest, Integer id);
}
