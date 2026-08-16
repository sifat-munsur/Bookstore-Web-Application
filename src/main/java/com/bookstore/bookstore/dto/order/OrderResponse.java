package com.bookstore.bookstore.dto.order;

import com.bookstore.bookstore.entity.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponse(
        Long id,
        Long userId,
        OrderStatus status,
        BigDecimal totalAmount,
        LocalDateTime createdAt,
        List<OrderItemResponse> items
) {
}
