package com.startjava.graduation.bookshelf;

import static com.startjava.graduation.bookshelf.Bookshelf.LEN_ARRAY;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    private static final String GREETING = "Привет, это книжный шкаф. Тут ты можешь хранить свои книги.";
    private static final int MAX_CHOICE_MENU = 6;
    private static final int MIN_CHOICE_MENU = 1;
    private static final int SPEED_PRINTING = 100;

    private static final String MENU = """
            1.save
            2.find
            3.delete
            4.clear
            5.show all books
            6.exit
            """;
    private static final Scanner SCAN = new Scanner(System.in);
    private static final Bookshelf BOOKSHELF = new Bookshelf();

    public static void main(String[] args) throws InterruptedException {
        printGreeting();
        Book book;
        String title;
        Menu action = null;
        while (action != Menu.EXIT) {
            action = menu();
            switch (action) {
                case SAVE -> {
                    book = createBook();
                    if (book != null) {
                        BOOKSHELF.save(book);
                    }
                }
                case FIND -> {
                    title = inputBookTitle();
                    book = BOOKSHELF.find(title);
                    if (book != null) {
                        System.out.println("Книга, которую вы искали");
                        System.out.println(book);
                    }
                }
                case DELETE -> {
                    title = inputBookTitle();
                    book = BOOKSHELF.find(title);
                    if (book != null) {
                        BOOKSHELF.delete(BOOKSHELF.getDeleteIndex());
                    }
                }
                case CLEAR -> {
                    BOOKSHELF.clear();
                    SCAN.nextLine();
                }
                case SHOW_ALL_BOOKS -> {
                    BOOKSHELF.showAllBooks();
                    SCAN.nextLine();
                }
                default -> action = Menu.EXIT;
            }

            if (action != Menu.EXIT) {
                System.out.print("Для продолжения работы нажмите клавишу <Enter>");
                SCAN.nextLine();
            }
        }
    }

    private static void printGreeting() throws InterruptedException {
        for (String c : GREETING.split("")) {
            System.out.print(c);
            Thread.sleep(SPEED_PRINTING);
        }
        System.out.println();
    }

    private static Menu menu() {
        if (BOOKSHELF.getBooksCount() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
        }

        int choice;
        System.out.print(MENU);
        System.out.print("Выберите необходимое действие, введя его номер: ");
        do {
            try {
                choice = SCAN.nextInt();
                if (choice < MIN_CHOICE_MENU || choice > MAX_CHOICE_MENU) {
                    throw new InputMismatchException();
                }
                return switch (choice) {
                    case 1 -> Menu.SAVE;
                    case 2 -> Menu.FIND;
                    case 3 -> Menu.DELETE;
                    case 4 -> Menu.CLEAR;
                    case 5 -> Menu.SHOW_ALL_BOOKS;
                    case 6 -> Menu.EXIT;
                    default -> null;
                };
            } catch (InputMismatchException e) {
                System.out.print("Ошибка: введите номер из списка: ");
                SCAN.nextLine();
            }
        } while (true);
    }

    private static Book createBook() {
        if (BOOKSHELF.getBooksCount() == LEN_ARRAY) {
            System.out.println("В шкафу нет места");
            return null;
        }

        SCAN.nextLine();
        System.out.print("Введите имя автора: ");
        String author = SCAN.nextLine();
        System.out.print("Введите название книги: ");
        String title = SCAN.nextLine();
        int year;
        while (true) {
            try {
                System.out.print("Введите год издания книги: ");
                year = SCAN.nextInt();
                SCAN.nextLine();
                break;
            } catch (InputMismatchException e) {
                SCAN.nextLine();
            }
        }
        return new Book(author, title, year);
    }

    private static String inputBookTitle() {
        SCAN.nextLine();
        System.out.print("Введите название книги: ");
        return SCAN.nextLine();
    }
}

enum Menu {
    SAVE, FIND, DELETE, CLEAR, SHOW_ALL_BOOKS, EXIT
}
