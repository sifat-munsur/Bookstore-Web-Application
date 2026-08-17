package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    boolean existsByNameIgnoreCase(String name);

}
