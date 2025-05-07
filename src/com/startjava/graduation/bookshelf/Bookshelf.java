package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    public static final int LEN_ARRAY = 10;
    private static final int DASH_COUNT = 50;
    private final Book[] books = new Book[LEN_ARRAY];
    private int booksCount;
    private int deleteIndex;

    public int getBooksCount() {
        return booksCount;
    }

    public int getDeleteIndex() {
        return deleteIndex;
    }

    public void save(Book book) {
        books[booksCount++] = book;
        System.out.println("Книга добавлена в шкаф");
    }

    public Book find(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                deleteIndex = i;
                return books[i];
            }
        }
        System.out.println("Такой книги у меня нет");
        return null;
    }

    public void delete(int index) {
        System.arraycopy(books, index + 1, books, index, LEN_ARRAY - (index + 1));
        books[LEN_ARRAY - 1] = null;
        booksCount--;
        System.out.println("Книга удалена.");
    }

    public void clear() {
        Arrays.fill(books, null);
        booksCount = 0;
        System.out.println("Все книги удалены.");
    }

    public void showAllBooks() {
        System.out.printf("В шкафу книг - %d, свободно полок - %d%n", booksCount, LEN_ARRAY - booksCount);
        for (int i = 0; i < booksCount; i++) {
            System.out.println("|" + books[i] + " ".repeat(DASH_COUNT - books[i].toString().length()) + "|");
            System.out.println("|" + "-".repeat(DASH_COUNT) + "|");
        }
    }
}
