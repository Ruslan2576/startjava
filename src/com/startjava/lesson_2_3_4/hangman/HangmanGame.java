package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGame {
    private final char[] correctSymbols;
    private final char[] wrongSymbols;
    private final char[] allInputSymbols = new char[33];
    private int attempts = 5;
    private int correctSymbolsCounter;
    private int wrongSymbolsCounter;
    private int allSymbols;
    private int gallowsLen;
    private final String[] gallows = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private final String secretWord;

    public HangmanGame(String word) {
        correctSymbols = new char[word.length()];
        wrongSymbols = new char[word.length() + gallows.length - 1];
        secretWord = word;
        play();
    }

    private void play() {
        String currentWord;
        do {
            // Вывод текущей инфорамации
            currentWord = printCurrentResult(correctSymbols, secretWord);
            System.out.println("текущее количество попыток: " + attempts);
            System.out.print("Все ошибочные буквы: ");
            printWrongArray(wrongSymbols);

            // Проверка на корректность ввода и на совпадение.
            if (!currentWord.equals(secretWord)) {
                char symbol = inputSymbol();
                boolean isContain = hasSymbolInSecretWord(secretWord, symbol);
                addSymbolToArrays(isContain, symbol);
            }
        } while (gallowsLen < gallows.length - 1 && (!currentWord.equals(secretWord)));

        if (currentWord.equals(secretWord)) {
            System.out.println("Поздравляю: вы победили!");
        } else {
            System.out.println(gallows[5]);
            System.out.println("Вы проиграли: правильное слово - " + secretWord);
        }
    }

    private String printCurrentResult(char[] symbols, String word) {
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

    private void printWrongArray(char[] wrongSymbols) {
        for (char c : wrongSymbols) {
            if (c != 0) {
                System.out.print(c + ", ");
            }
        }
        System.out.println();
    }

    private char inputSymbol() {
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

    private boolean hasSymbolInSecretWord(String word, char symbol) {
        boolean isCorrect = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.toUpperCase().charAt(i) == symbol) {
                isCorrect = true;
                break;
            }
        }
        return isCorrect;
    }

    private void addSymbolToArrays(boolean isContain, char symbol) {
        if (isContain) {
            correctSymbols[correctSymbolsCounter++] = symbol;
            if (attempts < gallows.length - 1) {
                attempts++;
            }

            if (gallowsLen > 0) {
                gallowsLen--;
            }
        } else {
            if (checkWrongSymbols(wrongSymbols, symbol)) {
                wrongSymbols[wrongSymbolsCounter++] = symbol;
            }

            gallowsLen++;
            for (int i = 0; i < gallowsLen; i++) {
                System.out.println(gallows[i]);
            }

            attempts--;
        }
    }

    private boolean checkWrongSymbols(char[] letters, char symbol) {
        for (char c : letters) {
            if (c == symbol) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCyrillic(char symbol) {
        return symbol >= 1040 && symbol <= 1071;
    }

    private static boolean checkAllSymbols(char[] allInputSymbols, char symbol) {
        for (char c : allInputSymbols) {
            if (c == symbol) {
                return true;
            }
        }
        return false;
    }
}