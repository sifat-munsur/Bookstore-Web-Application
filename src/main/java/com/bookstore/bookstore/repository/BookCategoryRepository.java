package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entity.BookCategory;
import com.bookstore.bookstore.entity.BookCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCategoryRepository extends JpaRepository<BookCategory, BookCategoryId> {

    List<BookCategory> findByBookId(Long bookId);
    void deleteByBookId(Long bookId);

}
