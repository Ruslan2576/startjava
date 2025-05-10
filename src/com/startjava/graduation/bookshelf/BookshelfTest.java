package com.startjava.graduation.bookshelf;

import static com.startjava.graduation.bookshelf.Bookshelf.CAPACITY;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    private static final String GREETING = "Привет, это книжный шкаф. Тут ты можешь хранить свои книги.";
    private static final String MENU = """
            1.save
            2.find
            3.delete
            4.clear
            5.exit
            """;
    private static Book book;
    private static String title;
    private static Scanner scan;
    private static Bookshelf bookshelf;
    private static Menu action;
    private static final int MAX_CHOICE_MENU = 5;
    private static final int MIN_CHOICE_MENU = 1;

    public static void main(String[] args) throws InterruptedException {
        scan = new Scanner(System.in);
        bookshelf = new Bookshelf();
        printGreeting();

        do {
            action = menu();
            if (action == Menu.EXIT) {
                break;
            }
            executeMenuItem();
            bookshelf.showAllBooks();
            waitingInput();
        } while (true);
    }

    private static void printGreeting() throws InterruptedException {
        for (String ch : GREETING.split("")) {
            System.out.print(ch);
            Thread.sleep(100);
        }
        System.out.println();
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
                return Menu.values()[choice - 1];
            } catch (InputMismatchException e) {
                System.out.print("Ошибка: введите номер из списка: ");
                scan.nextLine();
            }
        } while (true);
    }

    private static void executeMenuItem() {
        switch (action) {
            case SAVE -> save();
            case FIND -> find();
            case DELETE -> delete();
            case CLEAR -> clear();
            default -> throw new InputMismatchException();
        }
    }

    private static void save() {
        if (bookshelf.getBooksCount() == CAPACITY) {
            bookshelf.save(null);
            scan.nextLine();
            return;
        }
        book = createBook();
        System.out.println("Книга добавлена в шкаф");
        bookshelf.save(book);
    }

    private static void find() {
        title = inputBookTitle();
        book = bookshelf.find(title);
        if (book != null) {
            System.out.println("Книга, которую вы искали");
            System.out.println(book);
        }
    }

    private static void delete() {
        title = inputBookTitle();
        book = bookshelf.find(title);
        if (book != null) {
            bookshelf.delete(title);
            System.out.println("Книга удалена.");
        }
    }

    private static void clear() {
        bookshelf.clear();
        scan.nextLine();
        System.out.println("Все книги удалены.");
    }

    private static Book createBook() {
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

    private static void waitingInput() {
        if (action != Menu.EXIT) {
            System.out.print("Для продолжения работы нажмите клавишу <Enter>");
            scan.nextLine();
        }
    }
}
