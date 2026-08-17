package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entity.CartItem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @EntityGraph(attributePaths = {"book", "book.publisher"})
    List<CartItem> findByUserId(Long userId);

    Optional<CartItem> findByUserIdAndBookId(Long userId, Long bookId);

    boolean existsByUserIdAndBookId(Long userId, Long bookId);

    void deleteByUserId(Long userId);

    void deleteByUserIdAndBookId(Long userId, Long bookId);

}
