package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entity.BookAuthor;
import com.bookstore.bookstore.entity.BookAuthorId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorId> {

    List<BookAuthor> findByBookId(Long bookId);
    void deleteByBookId(Long bookId);

}
