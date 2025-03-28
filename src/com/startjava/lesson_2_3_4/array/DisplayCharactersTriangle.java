package com.startjava.lesson_2_3_4.array;

public class DisplayCharactersTriangle {
    public static void main(String[] args) {
        char[] symbols = sortSymbols('0', '9', true);
        printTriangle(symbols);

        symbols = sortSymbols('/', '!', false);
        printTriangle(symbols);

        symbols = sortSymbols('A', 'J', false);
        printTriangle(symbols);
    }

    private static char[] sortSymbols(char start, char stop, boolean direction) {
        if (start > stop) {
            System.out.printf("Ошибка: левая граница (%c) > правой (%c)%n", start, stop);
            return null;
        }

        int len = stop - start + 1;
        char[] symbols = new char[len];
        for (int i = 0; i < len; i++) {
            symbols[i] = direction ? start++ : stop--;
        }
        return symbols;
    }

    private static void printTriangle(char[] symbols) {
        if (symbols == null) {
            return;
        }

        StringBuilder triangle = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {
            triangle.repeat(" ", symbols.length - 1 - i);
            triangle.append(symbols[i]).repeat(symbols[i], i * 2).append("\n");
        }
        System.out.println(triangle);
    }
}
