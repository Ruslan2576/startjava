package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    public static final int BOOKSHELF_SIZE = 10;
    private final Book[] books = new Book[BOOKSHELF_SIZE];
    private int booksCount;

    public Book[] getBooks() {
        return books;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public void save(Book book) {
        books[booksCount++] = book;
    }

    public Book find(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        System.out.println("Такой книги у меня нет");
        return null;
    }

    public void delete(String title) {
        int index = 0;
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                index = i;
            }
        }
        System.arraycopy(books, index + 1, books, index, BOOKSHELF_SIZE - (index + 1));
        books[BOOKSHELF_SIZE - 1] = null;
        booksCount--;
    }

    public void clear() {
        Arrays.fill(books, 0, booksCount, null);
        booksCount = 0;
    }
}
