package com.bookstore.bookstore.dto.book;

import com.bookstore.bookstore.dto.author.AuthorResponse;
import com.bookstore.bookstore.dto.category.CategoryResponse;
import com.bookstore.bookstore.dto.publisher.PublisherResponse;

import java.math.BigDecimal;
import java.util.List;

public record BookResponse(
        Long id,
        String title,
        String isbn,
        BigDecimal price,
        Integer stockQuantity,
        PublisherResponse publisher,
        List<AuthorResponse> authors,
        List<CategoryResponse> categories,
        Double averageRating
) {
}
