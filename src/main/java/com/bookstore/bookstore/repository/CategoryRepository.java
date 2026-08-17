package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByParentIsNull();
    List<Category> findByParentId(Long parentId);
    boolean existsByNameIgnoreCase(String name);

}
