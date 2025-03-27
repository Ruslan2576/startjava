package com.startjava.lesson_2_3_4.array;

public class SymbolSorter {
    public static void main(String[] args) {
        char[] symbols = sortSymbols('0', '9', true);
        if (symbols != null) {
            printTriangle(symbols);
        }

        symbols = sortSymbols('/', '!', false);
        if (symbols != null) {
            printTriangle(symbols);
        }

        symbols = sortSymbols('A', 'J', false);
        if (symbols != null) {
            printTriangle(symbols);
        }
    }

    private static char[] sortSymbols(char start, char stop, boolean direction) {
        if (start > stop) {
            System.out.printf("Ошибка: левая граница (%c) > правой (%c)%n", start, stop);
            return null;
        }
        int characterRange = stop - start + 1;
        char[] symbols = new char[characterRange];
        for (int i = 0; i < characterRange; i++) {
            if (direction) {
                symbols[i] = start++;
            } else {
                symbols[i] = stop--;
            }
        }
        return symbols;
    }

    private static void printTriangle(char[] symbols) {
        StringBuilder triangle = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {
            triangle.repeat(" ", symbols.length - 1 - i);
            triangle.append(symbols[i]).repeat(symbols[i], i * 2).append("\n");
        }
        System.out.println(triangle);
    }
}
