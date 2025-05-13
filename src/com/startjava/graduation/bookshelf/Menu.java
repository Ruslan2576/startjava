package com.startjava.graduation.bookshelf;

import java.io.IOException;

public enum Menu {
    SAVE, FIND, DELETE, CLEAR, EXIT;

    public static Menu getPoint(int choice) throws IOException {
        return switch (choice) {
            case 1 -> SAVE;
            case 2 -> FIND;
            case 3 -> DELETE;
            case 4 -> CLEAR;
            case 5 -> EXIT;
            default -> throw new IOException("Ошибка: введите пункт из предложенного в меню: ");
        };
    }
}
