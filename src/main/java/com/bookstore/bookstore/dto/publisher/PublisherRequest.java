package com.bookstore.bookstore.dto.publisher;

import jakarta.validation.constraints.NotBlank;

public record PublisherRequest(
        @NotBlank(message = "Publisher name is required")
        String name) {
}
