package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Угадай число в диапазоне [1, 100]");

        // Получаем имя и инициализируем первого игрока
        System.out.print("Игрок №1 введите своё имя: ");
        String name = scan.next();
        Player firstPlayer = new Player(name);

        // Получаем имя и инициализируем второго игрока
        System.out.print("Игрок №2 введите своё имя: ");
        name = scan.next();
        Player secondPlayer = new Player(name);

        GuessNumber game = new GuessNumber(firstPlayer, secondPlayer);
        String choice = "yes";

        while (!choice.equals("no")) {
            if (!choice.equals("yes")) {
                System.out.print("Введите корректный ответ [yes / no]: ");
                choice = scan.next().toLowerCase();
                if (!choice.equals("yes")) {
                    continue;
                }
            }
            // Запуск игры
            game.play();

            System.out.print("Хотите продолжить игру? [yes/no]: ");
            choice = scan.next().toLowerCase();
        }
    }
}