package com.lukastteles.java_api_challenge.gateways.outputs.db.entities.mappers;

import com.lukastteles.java_api_challenge.domain.Category;
import com.lukastteles.java_api_challenge.gateways.outputs.db.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

    CategoryEntity from(Category category);

    Category from(CategoryEntity categoryEntity);
}
