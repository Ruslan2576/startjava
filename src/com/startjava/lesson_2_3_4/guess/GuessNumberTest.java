package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Получаем имя и инициализируем первого игрока
        System.out.print("Игрок №1 введите своё имя: ");
        String name = scan.next();
        Player firstPlayer = new Player(name);

        // Получаем имя и инициализируем второго игрока
        System.out.print("Игрок №2 введите своё имя: ");
        name = scan.next();
        Player secondPlayer = new Player(name);

        GuessNumber game = new GuessNumber(firstPlayer, secondPlayer);
        String choice = "";

        while (!choice.equals("no")) {
            // Запуск игры
            game.play();

            // Продолжим?
            do {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                choice = scan.next();
            } while (!choice.equals("yes") && !choice.equals("no"));
        }
    }
}