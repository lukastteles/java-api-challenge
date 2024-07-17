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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FindCategoryTest {

    @InjectMocks
    private FindCategory findCategory;

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
        when(categoryDataGateway.findById(anyInt())).thenReturn(category);
        var categoryReturned = findCategory.execute(1);
        assertEquals(category, categoryReturned);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsExceptionWhenInvalidParameters() {
        findCategory.execute((Integer) null);
    }
}
