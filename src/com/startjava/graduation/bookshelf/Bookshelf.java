package com.startjava.graduation.bookshelf;

import com.startjava.graduation.bookshelf.exception.CanNotAddThisBookException;
import com.startjava.graduation.bookshelf.exception.CanNotRemoveSuchBook;
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
        try {
            if (booksCount < CAPACITY) {
                books[booksCount++] = book;
            }

            if (getBookLen(book) > shelfLen) {
                updateShelfLen();
            }
        } catch (CanNotAddThisBookException ex) {
            System.out.println("В шкафу нет места");
        }
    }

    public Book find(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        System.out.print("В шкафу нет такой книги");
        return null;
    }

    public void remove(Book book) {
        try {
            if (book == null) {
                throw new CanNotRemoveSuchBook(" не могу её удалить");
            }

            for (int i = 0; i < booksCount; i++) {
                if (books[i].getTitle().equals(book.getTitle())) {
                    System.arraycopy(books, i + 1, books, i, booksCount - i - 1);
                    books[--booksCount] = null;
                    if (getBookLen(book) == shelfLen) {
                        updateShelfLen();
                    }
                    break;
                }
            }
        } catch (CanNotRemoveSuchBook ex) {
            System.out.print(ex.getMessage());
        }
    }

    public void clear() {
        Arrays.fill(books, 0, booksCount, null);
        booksCount = 0;
    }

    public int getBookLen(Book book) {
        return book.toString().length();
    }

    private void updateShelfLen() {
        shelfLen = 0;
        for (Book book : getBooks()) {
            shelfLen = Math.max(shelfLen, getBookLen(book));
        }
    }
}
