package com.bookstore.bookstore.exception;

public class InsufficientStockException extends RuntimeException {

    public InsufficientStockException(String bookTitle, int available, int requested) {
        super(String.format(
                "Insufficient stock for '%s'. Available: %d, Requested: %d",
                bookTitle, available, requested
        ));
    }

}
