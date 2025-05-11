package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    public static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int booksCount;

    public Book[] getBooks() {
        return Arrays.copyOf(books, booksCount);
    }

    public int getBooksCount() {
        return booksCount;
    }

    public void save(Book book) {
        if (booksCount >= CAPACITY) {
            System.out.println("В шкафу нет места");
            return;
        }
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
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                System.arraycopy(books, i + 1, books, i, booksCount - i - 1);
                books[booksCount - 1] = null;
                booksCount--;
                break;
            }
        }
    }

    public void clear() {
        Arrays.fill(books, 0, booksCount, null);
        booksCount = 0;
    }
}
