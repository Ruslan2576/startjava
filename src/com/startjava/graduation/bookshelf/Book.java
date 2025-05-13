package com.startjava.graduation.bookshelf;

import java.time.Year;

public class Book {
    private final String author;
    private final String title;
    private final Year year;

    public Book(String author, String title, Year year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + year;
    }
}
