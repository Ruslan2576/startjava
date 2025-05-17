package com.startjava.graduation.bookshelf;

import com.startjava.graduation.bookshelf.exception.CanNotRemoveSuchBook;
import com.startjava.graduation.bookshelf.exception.NoSuchBookException;
import java.util.Arrays;

public class Bookshelf {
    public static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int booksCount;
    private int shelfLen;

    public Book[] getBooks() {
        return Arrays.copyOf(books, booksCount);
    }

    public int getBooksCount() {
        return booksCount;
    }

    public int getShelfLen() {
        return shelfLen;
    }

    public void add(Book book) {
        if (booksCount >= CAPACITY) {
            System.out.println("В шкафу нет места");
            return;
        }
        books[booksCount++] = book;

        if (book.toString().length() > shelfLen) {
            updateShelfLen();
        }
    }

    public Book find(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        throw new NoSuchBookException("Такой книги у меня нет");
    }

    public void remove(String title) {
        if (title == null) {
            throw new CanNotRemoveSuchBook("Не могу удалить такую книгу, её нет на полке");
        }
        Book book = null;
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                book = books[i];
                System.arraycopy(books, i + 1, books, i, booksCount - i - 1);
                books[booksCount - 1] = null;
                booksCount--;
                break;
            }
        }

        assert book != null;
        if (book.toString().length() == shelfLen) {
            updateShelfLen();
        }
    }

    public void clear() {
        Arrays.fill(books, 0, booksCount, null);
        booksCount = 0;
    }

    private void updateShelfLen() {
        shelfLen = 0;
        for (Book book : getBooks()) {
            if (book.toString().length() > shelfLen) {
                shelfLen = book.toString().length();
            }
        }
    }
}
