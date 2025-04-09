package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        String[] planets = {"Сатурн", "Юпитер", "Венера", "Марс", "Земля"};
        String[] array = {"_______",
                "|     |",
                "|     @",
                "|    /|\\",
                "|    / \\",
                "| GAME OVER!"
        };

        String choice = "";
        while (!choice.equals("no")) {
            String currentWord;
            String word = planets[rand.nextInt(0, planets.length)].toUpperCase();
            HangmanGame hg = new HangmanGame(word.length(), word.length() + array.length);
            do {
                // Проверка на корректность ввода и на совпадение.
                char symbol = hg.inputSymbol();
                boolean isContain = HangmanGame.check(word, symbol);
                hg.contain(array, isContain, symbol);

                // Вывод промежуточной инфорамации.
                currentWord = printCurrentResult(hg.getCorrectSymbols(), word);
                if (!currentWord.equals(word)) {
                    System.out.println("текущее количество попыток: " + hg.getAttempts());
                    System.out.print("Все ошибочные буквы: ");
                    HangmanGame.printIncorrectArray(hg.getIncorrectSymbols());
                }
            } while (hg.getCnt() < array.length && (!currentWord.equals(word)));

            if (currentWord.equals(word)) {
                System.out.println("Поздравляю: вы победили!");
            } else {
                System.out.println("Вы проиграли: правильное слово - " + word);
            }

            // Предложение сыграть ещё.
            System.out.print("Хотите продлжить игру [yes / no]: ");
            choice = scan.next();
            while (!choice.equals("yes") && !choice.equals("no")) {
                System.out.print("Введите корректный ответ [yes / no]: ");
                choice = scan.next();
            }
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
