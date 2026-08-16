package com.bookstore.bookstore.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ReviewRequest(
        @NotNull(message = "Book id is required")
        Long bookId,

        @NotNull
        @Min(value = 1, message = "Rating must be between 1 and 5")
        @Max(value = 5, message = "Rating must be between 1 and 5")
        Integer rating
) {
}
