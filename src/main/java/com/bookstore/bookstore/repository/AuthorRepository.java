package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AuthorRepository extends JpaRepository<Author, Long>,
        JpaSpecificationExecutor<Author> {

    boolean existsByNameIgnoreCase(String name);


}
