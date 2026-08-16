package com.bookstore.bookstore.dto.category;

import java.util.List;

public record CategoryResponse(
        Long id,
        String name,
        Long parentId,
        List<CategoryResponse> subCategories
) {
}
