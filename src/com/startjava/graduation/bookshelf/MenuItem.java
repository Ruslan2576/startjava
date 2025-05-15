package com.startjava.graduation.bookshelf;

import com.startjava.graduation.bookshelf.exception.InvalidInputException;

public enum MenuItem {
    ADD("Добавить книгу"),
    FIND("Найти книгу"),
    DELETE("Удалить книгу"),
    CLEAR("Удалить все книги"),
    EXIT("Выход");

    private final String label;

    MenuItem(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static MenuItem getPoint(int choice) {
        MenuItem[] menuItems = BookshelfTest.createMenu();
        if (choice > 0 && choice <= menuItems.length) {
            return menuItems[choice - 1];
        }

        throw new InvalidInputException("Ошибка: введите пункт из предложенного в меню: ");
    }
}
