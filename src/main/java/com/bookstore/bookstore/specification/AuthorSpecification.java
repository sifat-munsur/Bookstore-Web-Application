package com.bookstore.bookstore.specification;

import com.bookstore.bookstore.entity.Author;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {

    private AuthorSpecification() {}

    public static Specification<Author> nameContains(String name) {
        return (root, query, cb) ->
                name == null || name.isBlank()
                        ? cb.conjunction()
                        : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

}
