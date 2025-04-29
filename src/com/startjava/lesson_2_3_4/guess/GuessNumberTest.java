package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        System.out.println("Угадай число в диапазоне [1, 100]");
        Scanner scan = new Scanner(System.in);

        // Бросаем жребий

        GuessNumber game = new GuessNumber(inputPlayers());

        String choice = "yes";

        while (!choice.equals("no")) {
            if (!choice.equals("yes")) {
                System.out.print("Введите корректный ответ [yes / no]: ");
                choice = scan.next().toLowerCase();
                if (!choice.equals("yes")) {
                    continue;
                }
            }

            game.play();

            System.out.print("Хотите продолжить игру? [yes / no]: ");
            choice = scan.next().toLowerCase();
        }
    }

    public static Player[] inputPlayers() {
        Scanner scan = new Scanner(System.in);
        Player[] players = new Player[3];
        for (int i = 0; i < players.length; i++) {
            System.out.printf("Игрок №%d введите своё имя: ", i + 1);
            players[i] = new Player(scan.next());
        }
        return players;
    }
}