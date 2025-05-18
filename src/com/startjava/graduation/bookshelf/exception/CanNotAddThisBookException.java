package com.startjava.graduation.bookshelf.exception;

public class CanNotAddThisBookException extends RuntimeException {
    public CanNotAddThisBookException(String message) {
        super(message);
    }
}
