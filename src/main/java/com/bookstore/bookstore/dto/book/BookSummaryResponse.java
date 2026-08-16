package com.bookstore.bookstore.dto.book;

import java.math.BigDecimal;

public record BookSummaryResponse(
        Long id,
        String title,
        String isbn,
        BigDecimal price
) {
}
