package com.startjava.graduation.bookshelf;

import static com.startjava.graduation.bookshelf.Bookshelf.CAPACITY;

import com.startjava.graduation.bookshelf.exception.CanNotRemoveSuchABook;
import com.startjava.graduation.bookshelf.exception.InvalidInputException;
import com.startjava.graduation.bookshelf.exception.NoSuchABookException;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    private static final String GREETING = "Привет, это книжный шкаф. Тут ты можешь хранить свои книги.";
    private static final int SHELF_LEN = 50;
    private static Scanner scan;
    private static Bookshelf bookshelf;

    public static void main(String[] args) throws InterruptedException {
        scan = new Scanner(System.in);
        bookshelf = new Bookshelf();
        MenuItem action = MenuItem.EXIT;
        printGreeting();
        do {
            showMenu();
            try {
                action = makeChoice();
                executeMenuItem(action);
                showAllBooks();
                waitEnter();
            } catch (InputMismatchException | NoSuchABookException | CanNotRemoveSuchABook ex) {
                System.out.println(ex.getMessage());
                waitEnter();
            }
        } while (action != MenuItem.EXIT);
    }

    private static void printGreeting() throws InterruptedException {
        for (String ch : GREETING.split("")) {
            System.out.print(ch);
            Thread.sleep(100);
        }
        System.out.println();
    }

    private static void showMenu() {
        MenuItem[] menuItems = MenuItem.values();
        if (bookshelf.getBooksCount() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
            System.out.println(1 + "." + menuItems[0].getMessage());
            System.out.println(5 + "." + menuItems[4].getMessage());
        } else if (bookshelf.getBooksCount() == CAPACITY) {
            for (int i = 1; i < menuItems.length; i++) {
                System.out.println(i + 1 + "." + menuItems[i].getMessage());
            }
        } else {
            for (int i = 0; i < menuItems.length; i++) {
                System.out.println(i + 1 + "." + menuItems[i].getMessage());
            }
        }
    }

    private static MenuItem makeChoice() {
        System.out.print("Выберите нужный пункт меню, введя его номер: ");
        do {
            try {
                int choice = scan.nextInt();
                return MenuItem.getPoint(choice);
            } catch (InputMismatchException e) {
                System.out.print("Введите число, а не букву: ");
                scan.nextLine();
            } catch (InvalidInputException e) {
                System.out.print(e.getMessage());
            }
        } while (true);
    }

    private static void executeMenuItem(MenuItem action) throws NoSuchABookException, CanNotRemoveSuchABook {
        switch (action) {
            case ADD -> save();
            case FIND -> find();
            case DELETE -> delete();
            case CLEAR -> clear();
            default -> throw new InputMismatchException("Exit");
        }
    }

    private static void save() {
        Book book = createBook();
        bookshelf.add(book);
        System.out.println("Книга добавлена в шкаф");
    }

    private static Book createBook() {
        scan.nextLine();
        System.out.print("Введите имя автора: ");
        String author = scan.nextLine();
        String title = inputBookTitle();
        Year year;
        while (true) {
            try {
                System.out.print("Введите год издания книги: ");
                year = Year.of(scan.nextInt());
                scan.nextLine();
                break;
            } catch (InputMismatchException e) {
                scan.nextLine();
            }
        }
        return new Book(author, title, year);
    }

    private static void find() throws NoSuchABookException {
        scan.nextLine();
        String title = inputBookTitle();
        Book book = bookshelf.find(title);
        if (book != null) {
            System.out.println("Книга, которую вы искали\n" + book);
        }
    }

    private static void delete() throws NoSuchABookException, CanNotRemoveSuchABook {
        scan.nextLine();
        String title = inputBookTitle();
        Book book = bookshelf.find(title);
        bookshelf.remove(title);
        System.out.println("Книга удалена.");
    }

    private static String inputBookTitle() {
        System.out.print("Введите название книги: ");
        return scan.nextLine();
    }

    private static void clear() {
        bookshelf.clear();
        scan.nextLine();
        System.out.println("Все книги удалены.");
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

    private static void waitEnter() {
        do {
            System.out.print("Для продолжения работы нажмите клавишу <Enter>");
        } while (!scan.nextLine().isEmpty());
    }
}
