package com.bookstore.bookstore.dto.book;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public record BookRequest(
        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "ISBN is required")
        @Size(max = 20, message = "ISBN must be at most 20 characters")
        String isbn,

        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be positive")
        BigDecimal price,

        @NotNull(message = "Stock quantity is required")
        @Min(value = 0, message = "Stock cannot be negative")
        Integer stockQuantity,

        @NotNull(message = "Publisher is required")
        Long publisherId,

        @NotEmpty(message = "At least one author is required")
        List<Long> authorIds,

        List<Long> categoryIds
) {
}
