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
    private static final int MAX_CHOICE_MENU = 5;
    private static final int MIN_CHOICE_MENU = 1;
    private static final int SHELF_LEN = 50;
    private static Scanner scan;
    private static Bookshelf bookshelf;
    private static Menu action = Menu.EXIT;

    public static void main(String[] args) throws InterruptedException {
        scan = new Scanner(System.in);
        bookshelf = new Bookshelf();
        printGreeting();
        while ((action = makeChoice()) != Menu.EXIT) {
            try {
                executeMenuItem();
                showAllBooks();
                waitingInputEnter();
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void printGreeting() throws InterruptedException {
        for (String ch : GREETING.split("")) {
            System.out.print(ch);
            Thread.sleep(100);
        }
        System.out.println();
    }

    private static Menu makeChoice() {
        showMenu();
        System.out.print("Выберите нужный пункт меню, введя его номер: ");
        do {
            try {
                int choice = scan.nextInt();
                if (choice < MIN_CHOICE_MENU || choice > MAX_CHOICE_MENU) {
                    throw new InputMismatchException();
                }
                return action.getPoint(choice);
            } catch (InputMismatchException e) {
                System.out.print("Ошибка: введите номер из списка: ");
                scan.nextLine();
            }
        } while (true);
    }

    private static void showMenu() {
        if (bookshelf.getBooksCount() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
        }
        System.out.print(MENU);
    }

    private static void executeMenuItem() {
        switch (action) {
            case SAVE -> save();
            case FIND -> find();
            case DELETE -> delete();
            case CLEAR -> clear();
            default -> throw new InputMismatchException("Ошибка ввода");
        }
    }

    private static void save() {
        // Этот if нужен для того, чтобы сообщить пользователю о том,
        // что на полке больше нет места, до того как он введёт информацию о книге.
        if (bookshelf.getBooksCount() >= CAPACITY) {
            bookshelf.save(new Book(null, null, 0));
            scan.nextLine();
            return;
        }
        Book book = createBook();
        System.out.println("Книга добавлена в шкаф");
        bookshelf.save(book);
    }

    private static Book createBook() {
        scan.nextLine();
        System.out.print("Введите имя автора: ");
        String author = scan.nextLine();
        String title = inputBookTitle();
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

    private static void find() {
        scan.nextLine();
        String title = inputBookTitle();
        Book book = bookshelf.find(title);
        if (book != null) {
            System.out.println("Книга, которую вы искали");
            System.out.println(book);
        }
    }

    private static void delete() {
        scan.nextLine();
        String title = inputBookTitle();
        Book book = bookshelf.find(title);
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

    private static String inputBookTitle() {
        System.out.print("Введите название книги: ");
        return scan.nextLine();
    }

    public static void showAllBooks() {
        int booksCount = bookshelf.getBooksCount();
        Book[] books = bookshelf.getBooks();
        System.out.printf("%nВ шкафу книг - %d, свободно полок - %d%n%n", booksCount, CAPACITY - booksCount);
        for (Book book : books) {
            System.out.println("|" + book + " ".repeat(SHELF_LEN - book.toString().length()) + "|");
            System.out.println("|" + "-".repeat(SHELF_LEN) + "|");
        }
    }

    private static void waitingInputEnter() {
        do {
            System.out.print("Для продолжения работы нажмите клавишу <Enter>");
        } while (!scan.nextLine().isEmpty());
    }
}
