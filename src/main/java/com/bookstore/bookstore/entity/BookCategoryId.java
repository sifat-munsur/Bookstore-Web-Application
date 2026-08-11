package com.bookstore.bookstore.entity;


import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookCategoryId implements Serializable {
    private Long bookId;
    private Long categoryId;
}
