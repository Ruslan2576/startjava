package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        String[] planets = {"Сатурн", "Юпитер", "Венера", "Марс", "Земля"};

        String choice = "";
        while (!choice.equals("no")) {
            // Загадываем слово
            String secretWord = planets[rand.nextInt(0, planets.length)].toUpperCase();
            new HangmanGame(secretWord);

            // Предлогаем сыграть ещё
            System.out.print("Хотите продлжить игру [yes / no]: ");
            choice = scan.next().toLowerCase();
            if (!choice.equals("yes") && !choice.equals("no")) {
                choice = getChoice(choice, scan);
            }
        }
    }

    private static String getChoice(String choice, Scanner scan) {
        while (!choice.equals("yes") && !choice.equals("no")) {
            System.out.print("Введите корректный ответ [yes / no]: ");
            choice = scan.next();
        }
        return choice;
    }
}
