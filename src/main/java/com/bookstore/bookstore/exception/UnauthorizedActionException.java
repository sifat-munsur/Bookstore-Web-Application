package com.bookstore.bookstore.exception;

public class UnauthorizedActionException extends RuntimeException{

    public UnauthorizedActionException(String message) {
        super(message);
    }

}
