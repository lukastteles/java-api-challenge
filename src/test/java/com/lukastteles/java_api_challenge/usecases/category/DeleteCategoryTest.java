package com.lukastteles.java_api_challenge.usecases.category;

import com.lukastteles.java_api_challenge.domain.Category;
import com.lukastteles.java_api_challenge.gateways.outputs.CategoryDataGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DeleteCategoryTest {

    @InjectMocks
    private DeleteCategory deleteCategory;

    @Mock
    private CategoryDataGateway categoryDataGateway;

    private Category category;

    @Before
    public void init() {
        category = Category.builder()
                .id(1)
                .build();
    }

    @Test
    public void shouldExecute() {
        categoryDataGateway.save(category);
        deleteCategory.execute(category.getId());

        assertEquals(null, categoryDataGateway.findById(category.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsExceptionWhenInvalidParameters() {
        deleteCategory.execute(null);
    }
}
