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
    private int gallowsLen;
    private final String[] gallows = {"_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private final String word;

    public HangmanGame(String word) {
        this.correctSymbols = new char[word.length()];
        incorrectSymbols = new char[word.length() + gallows.length];
        this.word = word;
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
            if (gallowsLen > 0) {
                gallowsLen--;
            }
        } else {
            if (checkIncorrectSymbols(incorrectSymbols, symbol)) {
                incorrectSymbols[incorrectSymbolsCounter++] = symbol;
            }
            gallowsLen++;
            for (int i = 0; i < gallowsLen; i++) {
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

    public static void printIncorrectArray(char[] incorrectSymbols) {
        for (char c : incorrectSymbols) {
            if (c != 0) {
                System.out.print(c + ", ");
            }
        }
        System.out.println();
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

    public void play() {
        String currentWord;
        do {
            // Проверка на корректность ввода и на совпадение.
            char symbol = inputSymbol();
            boolean isContain = check(word, symbol);
            contain(gallows, isContain, symbol);

            // Вывод текущей инфорамации
            currentWord = printCurrentResult(correctSymbols, word);
            if (!currentWord.equals(word)) {
                System.out.println("текущее количество попыток: " + attempts);
                System.out.print("Все ошибочные буквы: ");
                HangmanGame.printIncorrectArray(incorrectSymbols);
            }
        } while (gallowsLen < gallows.length && (!currentWord.equals(word)));

        if (currentWord.equals(word)) {
            System.out.println("Поздравляю: вы победили!");
        } else {
            System.out.println("Вы проиграли: правильное слово - " + word);
        }
    }

    public static String printCurrentResult(char[] symbols, String word) {
        StringBuilder mask = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            boolean isContain = false;
            for (char symbol : symbols) {
                if (word.charAt(i) == symbol) {
                    isContain = true;
                    break;
                }
            }
            if (isContain) {
                mask.append(word.charAt(i));
            } else {
                mask.append("*");
            }
        }
        System.out.println(mask);
        return mask.toString();
    }
}