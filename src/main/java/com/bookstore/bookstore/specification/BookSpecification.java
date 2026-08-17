package com.bookstore.bookstore.specification;

import com.bookstore.bookstore.dto.book.BookSearchCriteria;
import com.bookstore.bookstore.entity.*;
import com.bookstore.bookstore.entity.BookAuthor;
import com.bookstore.bookstore.entity.Publisher;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class BookSpecification {

    private BookSpecification() {}

    public static Specification<Book> fromCriteria(BookSearchCriteria criteria) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Avoid duplicate rows when joining to-many relations
            if (query.getResultType() != Long.class && query.getResultType() != long.class) {
                query.distinct(true);
            }

            if (criteria.title() != null && !criteria.title().isBlank()) {
                predicates.add(cb.like(
                        cb.lower(root.get("title")),
                        "%" + criteria.title().toLowerCase() + "%"
                ));
            }

            if (criteria.isbn() != null && !criteria.isbn().isBlank()) {
                predicates.add(cb.equal(root.get("isbn"), criteria.isbn()));
            }

            if (criteria.publisherId() != null) {
                Join<Book, Publisher> publisherJoin = root.join("publisher", JoinType.LEFT);
                predicates.add(cb.equal(publisherJoin.get("id"), criteria.publisherId()));
            }

            if (criteria.authorId() != null) {
                Join<Book, BookAuthor> bookAuthorJoin = root.join("bookAuthors", JoinType.INNER);
                predicates.add(cb.equal(bookAuthorJoin.get("author").get("id"), criteria.authorId()));
            }

            if (criteria.categoryId() != null) {
                Join<Book, BookCategory> bookCategoryJoin = root.join("bookCategories", JoinType.INNER);
                predicates.add(cb.equal(bookCategoryJoin.get("category").get("id"), criteria.categoryId()));
            }

            if (criteria.minPrice() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), criteria.minPrice()));
            }

            if (criteria.maxPrice() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), criteria.maxPrice()));
            }

            if (Boolean.TRUE.equals(criteria.inStockOnly())) {
                predicates.add(cb.greaterThan(root.get("stockQuantity"), 0));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Book> hasTitleContaining(String title) {
        return (root, query, cb) ->
                title == null || title.isBlank()
                        ? cb.conjunction()
                        : cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<Book> priceBetween(BigDecimal min, BigDecimal max) {
        return (root, query, cb) -> {
            if (min == null && max == null) return cb.conjunction();
            if (min != null && max != null) return cb.between(root.get("price"), min, max);
            if (min != null) return cb.greaterThanOrEqualTo(root.get("price"), min);
            return cb.lessThanOrEqualTo(root.get("price"), max);
        };
    }

}
