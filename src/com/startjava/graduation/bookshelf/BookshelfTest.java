package com.startjava.graduation.bookshelf;

import static com.startjava.graduation.bookshelf.Bookshelf.CAPACITY;

import com.startjava.graduation.bookshelf.exception.CanNotRemoveSuchBook;
import com.startjava.graduation.bookshelf.exception.InvalidInputException;
import com.startjava.graduation.bookshelf.exception.NoSuchBookException;
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
            } catch (InputMismatchException | NoSuchBookException | CanNotRemoveSuchBook ex) {
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
        if (bookshelf.getBooksCount() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
        }
        MenuItem[] menuItems = createMenu();
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.ordinal() + 1 + "." + menuItem.getLabel());
        }
    }

    private static MenuItem[] createMenu() {
        if (bookshelf.getBooksCount() == 0) {
            return new MenuItem[]{MenuItem.ADD, MenuItem.EXIT};
        } else if (bookshelf.getBooksCount() == CAPACITY) {
            return new MenuItem[]{MenuItem.FIND, MenuItem.DELETE, MenuItem.CLEAR, MenuItem.EXIT};
        } else {
            return MenuItem.values();
        }
    }

    private static MenuItem makeChoice() {
        System.out.print("Выберите нужный пункт меню, введя его номер: ");
        do {
            try {
                int id = scan.nextInt();
                return MenuItem.getPoint(id);
            } catch (InputMismatchException e) {
                System.out.print("Введите число, а не букву: ");
                scan.nextLine();
            } catch (InvalidInputException e) {
                System.out.print(e.getMessage());
            }
        } while (true);
    }

    private static void executeMenuItem(MenuItem action) {
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

    private static void find() {
        scan.nextLine();
        String title = inputBookTitle();
        Book book = bookshelf.find(title);
        if (book != null) {
            System.out.println("Книга, которую вы искали\n" + book);
        }
    }

    private static void delete() {
        scan.nextLine();
        String title = inputBookTitle();
        bookshelf.find(title);
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
