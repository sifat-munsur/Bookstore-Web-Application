package com.bookstore.bookstore.dto.author;

import jakarta.validation.constraints.NotBlank;

public record AuthorRequest(
    @NotBlank(message = "Author name is required")
    String name
    ){
}
