package com.bookstore.bookstore.dto.cart;

import com.bookstore.bookstore.dto.book.BookSummaryResponse;

import java.math.BigDecimal;

public record CartItemResponse(
        Long id,
        BookSummaryResponse book,
        Integer quantity,
        BigDecimal lineTotal
) {
}
