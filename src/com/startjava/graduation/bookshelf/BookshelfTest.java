package com.startjava.graduation.bookshelf;

import static com.startjava.graduation.bookshelf.Bookshelf.BOOKSHELF_SIZE;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    private static final String GREETING = "Привет, это книжный шкаф. Тут ты можешь хранить свои книги.";
    private static final int MAX_CHOICE_MENU = 6;
    private static final int MIN_CHOICE_MENU = 1;
    private static final int SPEED_PRINTING = 100;
    private static final int SHELF_LEN = 50;

    private static final String MENU = """
            1.save
            2.find
            3.delete
            4.clear
            5.show all books
            6.exit
            """;
    private static Scanner scan;
    private static Bookshelf bookshelf;
    private static Menu action;

    public static void main(String[] args) throws InterruptedException {
        scan = new Scanner(System.in);
        bookshelf = new Bookshelf();
        printGreeting();
        while (action != Menu.EXIT) {
            action = menu();
            executeMenuItem();
            if (action != Menu.EXIT) {
                System.out.print("Для продолжения работы нажмите клавишу <Enter>");
                scan.nextLine();
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

    private static void executeMenuItem() {
        Book book;
        String title;
        switch (action) {
            case SAVE -> {
                book = createBook();
                if (book != null) {
                    bookshelf.save(book);
                    System.out.println("Книга добавлена в шкаф");
                }
            }
            case FIND -> {
                title = inputBookTitle();
                book = bookshelf.find(title);
                if (book != null) {
                    System.out.println("Книга, которую вы искали");
                    System.out.println(book);
                }
            }
            case DELETE -> {
                title = inputBookTitle();
                book = bookshelf.find(title);
                if (book != null) {
                    bookshelf.delete(title);
                    System.out.println("Книга удалена.");
                }
            }
            case CLEAR -> {
                bookshelf.clear();
                scan.nextLine();
                System.out.println("Все книги удалены.");
            }
            case SHOW_ALL_BOOKS -> {
                showAllBooks();
                scan.nextLine();
            }
            default -> action = Menu.EXIT;
        }
    }

    private static Menu menu() {
        if (bookshelf.getBooksCount() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
        }

        int choice;
        System.out.print(MENU);
        System.out.print("Выберите нужный пункт меню, введя его номер: ");
        do {
            try {
                choice = scan.nextInt();
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
                scan.nextLine();
            }
        } while (true);
    }

    private static Book createBook() {
        if (bookshelf.getBooksCount() == BOOKSHELF_SIZE) {
            System.out.println("В шкафу нет места");
            scan.nextLine();
            return null;
        }

        scan.nextLine();
        System.out.print("Введите имя автора: ");
        String author = scan.nextLine();
        System.out.print("Введите название книги: ");
        String title = scan.nextLine();
        int year;
        while (true) {
            try {
                System.out.print("Введите год издания книги: ");
                year = scan.nextInt();
                scan.nextLine();
                break;
            } catch (InputMismatchException e) {
                scan.nextLine();
            }
        }
        return new Book(author, title, year);
    }

    private static String inputBookTitle() {
        scan.nextLine();
        System.out.print("Введите название книги: ");
        return scan.nextLine();
    }

    public static void showAllBooks() {
        int booksCount = bookshelf.getBooksCount();
        System.out.printf("В шкафу книг - %d, свободно полок - %d%n",
                booksCount, BOOKSHELF_SIZE - booksCount);
        for (int i = 0; i < booksCount; i++) {
            System.out.println("|" + bookshelf.getBooks()[i] +
                    " ".repeat(SHELF_LEN - bookshelf.getBooks()[i].toString().length()) + "|");
            System.out.println("|" + "-".repeat(SHELF_LEN) + "|");
        }
    }
}

