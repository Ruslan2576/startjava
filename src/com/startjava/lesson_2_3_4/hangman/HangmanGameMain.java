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
            // Проверяем введенный ответ.
            if (!choice.equals("yes") && !choice.isEmpty()) {
                // Спрашиваем до тех пор, пока не будет получет корректный ответ.
                System.out.print("Введите корректный ответ [yes / no]: ");
                choice = scan.next().toLowerCase();
                if (!choice.equals("yes")) {
                    continue;
                }
            }

            // Загадываем слово и запускаем игру
            String secretWord = planets[rand.nextInt(0, planets.length)].toUpperCase();
            HangmanGame hg = new HangmanGame(secretWord);
            hg.play();

            // Предлагаем сыграть ещё.
            System.out.print("Хотите продолжить игру [yes / no]: ");
            choice = scan.next().toLowerCase();
        }
    }
}
