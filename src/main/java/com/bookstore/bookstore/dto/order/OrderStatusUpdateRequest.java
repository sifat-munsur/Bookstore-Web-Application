package com.bookstore.bookstore.dto.order;

import com.bookstore.bookstore.entity.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record OrderStatusUpdateRequest(
        @NotNull(message = "Status is required")
        OrderStatus status
) {
}
