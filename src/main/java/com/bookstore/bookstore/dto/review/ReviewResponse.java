package com.bookstore.bookstore.dto.review;

import java.time.LocalDateTime;

public record ReviewResponse(
        Long id,
        Long userId,
        String userEmail,
        Long bookId,
        Integer rating,
        LocalDateTime createdAt
) {
}
