package com.startjava.graduation.bookshelf.exception;

public class NoSuchBookException extends RuntimeException {
    public NoSuchBookException(String message) {
        super(message);
    }
}
