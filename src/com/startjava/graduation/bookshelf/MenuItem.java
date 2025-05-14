package com.startjava.graduation.bookshelf;

import com.startjava.graduation.bookshelf.exception.InvalidInputException;

public enum MenuItem {
    ADD("Добавить книгу"),
    FIND("Найти книгу"),
    DELETE("Удалить книгу"),
    CLEAR("Удалить все книги"),
    EXIT("Выход");

    private final String message;

    MenuItem(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static MenuItem getPoint(int choice) throws InvalidInputException {
        if (choice > 0 && choice <= MenuItem.values().length) {
            return MenuItem.values()[choice - 1];
        }

        throw new InvalidInputException("Ошибка: введите пункт из предложенного в меню: ");
    }
}
