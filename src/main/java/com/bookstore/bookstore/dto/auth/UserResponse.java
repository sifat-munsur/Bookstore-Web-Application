package com.bookstore.bookstore.dto.auth;

import com.bookstore.bookstore.entity.Role;

public record UserResponse(
        Long id,
        String email,
        Role role
) {
}
