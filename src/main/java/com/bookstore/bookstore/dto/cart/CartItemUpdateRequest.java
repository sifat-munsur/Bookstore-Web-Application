package com.bookstore.bookstore.dto.cart;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CartItemUpdateRequest(
        @NotNull
        @Min(value = 1, message = "Quantity must be at least 1")
        Integer quantity
) {
}
