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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateOrUpdateCategoryTest {

    @InjectMocks
    private CreateOrUpdateCategory createOrUpdateCategory;

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
        when(categoryDataGateway.save(any())).thenReturn(category);
        var categoryReturned = createOrUpdateCategory.execute(category);
        assertEquals(category, categoryReturned);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsExceptionWhenInvalidParameters() {
        createOrUpdateCategory.execute(null);
    }
}
