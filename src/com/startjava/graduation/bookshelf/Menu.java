package com.startjava.graduation.bookshelf;

public enum Menu {
    SAVE, FIND, DELETE, CLEAR, EXIT;

    public Menu getPoint(int choice) {
        return Menu.values()[choice - 1];
    }
}
