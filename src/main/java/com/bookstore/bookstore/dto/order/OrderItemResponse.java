package com.bookstore.bookstore.dto.order;

import java.math.BigDecimal;

public record OrderItemResponse(
        Long id,
        Long bookId,
        String bookTitle,
        Integer quantity,
        BigDecimal unitPrice,
        BigDecimal lineTotal
) {
}
