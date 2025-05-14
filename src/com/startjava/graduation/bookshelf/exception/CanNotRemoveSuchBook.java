package com.startjava.graduation.bookshelf.exception;

public class CanNotRemoveSuchBook extends RuntimeException {
    public CanNotRemoveSuchBook(String message) {
        super(message);
    }
}
