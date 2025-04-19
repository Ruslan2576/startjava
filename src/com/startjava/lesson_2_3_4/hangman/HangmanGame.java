package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGame {
    private final char[] wrongLetters;
    private final char[] allInputLetters = new char[33];
    private int wrongLettersCounter;
    private int allLetters;
    private int gallowsLen;
    private final String[] gallows = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private int attempts = gallows.length - 1;
    private final String secretWord;

    public HangmanGame(String word) {
        wrongLetters = new char[word.length() + gallows.length - 1];
        secretWord = word;
    }

    public void play() {
        // String currentWord;
        String mask = createMask(secretWord);
        do {
            // Вывод текущей информации
            System.out.println(mask);
            System.out.println("Количество попыток: " + attempts);
            System.out.print("Все ошибочные буквы: ");
            printWrongLetters(wrongLetters);

            // Проверка на корректность ввода и на совпадение.
            if (!mask.equals(secretWord)) {
                char letter = inputSymbol();
                boolean isContain = hasSymbolInSecretWord(secretWord, letter);
                mask = printCurrentResult(letter, mask);
                addLetterToArrays(isContain, letter);
            }

            if (mask.equals(secretWord)) {
                System.out.println(mask);
            }
        } while (gallowsLen < gallows.length - 1 && (!mask.equals(secretWord)));

        if (mask.equals(secretWord)) {
            System.out.println("Поздравляю: вы победили!");
        } else {
            System.out.println(gallows[5]);
            System.out.println("Вы проиграли: правильное слово - " + secretWord);
        }
    }

    private String createMask(String secretWord) {
        return "*".repeat(secretWord.length());
    }

    private String printCurrentResult(char letter, String mask) {
        StringBuilder sb = new StringBuilder(mask);
        int index;
        for (int i = 0; i < secretWord.length(); i++) {
            index = secretWord.indexOf(letter, i);
            if (index != -1) {
                sb.replace(index, index + 1, String.valueOf(letter));
            }
        }
        return sb.toString();
    }

    private void printWrongLetters(char[] wrongLetters) {
        for (char c : wrongLetters) {
            if (c != 0) {
                System.out.print(c + ", ");
            }
        }
        System.out.println();
    }

    private char inputSymbol() {
        Scanner scan = new Scanner(System.in);
        char letter;
        boolean isRepeat = true;

        do {
            System.out.print("Угадайте слово введя букву: ");
            letter = scan.next().toUpperCase().charAt(0);

            if (!isCyrillic(letter)) {
                System.out.println("Вы ввели не кириллический символ: " + letter);
                continue;
            }

            isRepeat = checkAllLetters(allInputLetters, letter);
            if (isRepeat) {
                System.out.println("Вы уже вводили букву: " + letter);
            } else {
                allInputLetters[allLetters++] = letter;
            }
        } while (isRepeat);

        return letter;
    }

    private static boolean isCyrillic(char letter) {
        return String.valueOf(letter).matches("[А-Я]");
    }

    private static boolean checkAllLetters(char[] allInputLetters, char letter) {
        for (char c : allInputLetters) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSymbolInSecretWord(String word, char letter) {
        boolean isCorrect = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.toUpperCase().charAt(i) == letter) {
                isCorrect = true;
                break;
            }
        }
        return isCorrect;
    }

    private void addLetterToArrays(boolean isContain, char letter) {
        if (isContain) {
            if (attempts < gallows.length - 1) {
                attempts++;
            }

            if (gallowsLen > 0) {
                gallowsLen--;
            }
        } else {
            if (checkWrongLetters(wrongLetters, letter)) {
                wrongLetters[wrongLettersCounter++] = letter;
            }

            gallowsLen++;
            for (int i = 0; i < gallowsLen; i++) {
                System.out.println(gallows[i]);
            }

            attempts--;
        }
    }

    private boolean checkWrongLetters(char[] letters, char letter) {
        for (char c : letters) {
            if (c == letter) {
                return false;
            }
        }
        return true;
    }
}