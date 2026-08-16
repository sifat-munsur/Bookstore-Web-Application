package com.bookstore.bookstore.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank @Email(message = "Valid email is required")
        String email,

        @NotBlank
        @Size(min = 8, message = "Password must be at least 8 characters")
        String password
) {
}
