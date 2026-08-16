package com.bookstore.bookstore.dto.book;

import java.math.BigDecimal;

public record BookSearchCriteria(
        String title,
        String isbn,
        Long authorId,
        Long categoryId,
        Long publisherId,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        Boolean inStockOnly
) {
}
