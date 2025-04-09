package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGame {
    private final char[] correctSymbols;
    private final char[] incorrectSymbols;
    private final char[] allInputSymbols = new char[33];
    private int attempts = 6;
    private int correctSymbolsCounter;
    private int incorrectSymbolsCounter;
    private int allSymbols;
    private int cnt;

    public HangmanGame(int lenCorrectSymbols, int lenIncorrectSymbols) {
        this.correctSymbols = new char[lenCorrectSymbols];
        this.incorrectSymbols = new char[lenIncorrectSymbols];
    }

    public char inputSymbol() {
        Scanner scan = new Scanner(System.in);
        char symbol;
        boolean isRepeat = true;
        boolean isCyrillic;

        do {
            System.out.print("Угадайте слово введя букву: ");
            symbol = scan.next().toUpperCase().charAt(0);

            isCyrillic = checkCyrillic(symbol);
            if (!isCyrillic) {
                System.out.println("Вы ввели не кириллический символ: " + symbol);
                continue;
            }

            isRepeat = checkAllSymbols(allInputSymbols, symbol);
            if (isRepeat) {
                System.out.println("Вы уже вводили букву: " + symbol);
            } else {
                allInputSymbols[allSymbols++] = symbol;
            }
        } while (isRepeat);

        return symbol;
    }

    public static boolean check(String word, char symbol) {
        boolean isCorrect = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.toUpperCase().charAt(i) == symbol) {
                isCorrect = true;
                break;
            }
        }
        return isCorrect;
    }

    public void contain(String[] array, boolean isContain, char symbol) {
        if (isContain) {
            correctSymbols[correctSymbolsCounter++] = symbol;
            if (attempts < array.length) {
                attempts++;
            }
            if (cnt > 0) {
                cnt--;
            }
        } else {
            if (checkIncorrectSymbols(incorrectSymbols, symbol)) {
                incorrectSymbols[incorrectSymbolsCounter++] = symbol;
            }
            cnt++;
            for (int i = 0; i < cnt; i++) {
                System.out.println(array[i]);
            }
            attempts--;
        }
    }

    private static boolean checkIncorrectSymbols(char[] symbols, char symbol) {
        for (char s : symbols) {
            if (s == symbol) {
                return false;
            }
        }
        return true;
    }

    public char[] getCorrectSymbols() {
        return correctSymbols;
    }

    public char[] getIncorrectSymbols() {
        return incorrectSymbols;
    }

    public int getAttempts() {
        return attempts;
    }

    public static void printIncorrectArray(char[] incorrectSymbols) {
        for (char c : incorrectSymbols) {
            if (c != 0) {
                System.out.print(c + ", ");
            }
        }
        System.out.println();
    }

    public int getCnt() {
        return cnt;
    }

    private static boolean checkAllSymbols(char[] allInputSymbols, char symbol) {
        for (char c : allInputSymbols) {
            if (c == symbol) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkCyrillic(char symbol) {
        return symbol >= 1040 && symbol <= 1071;
    }
}