package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Угадай число в диапазоне [1, 100]");

        Player[] players = new Player[3];
        for (int i = 0; i < players.length; i++) {
            System.out.printf("Игрок №%d введите своё имя: ", i + 1);
            String name = scan.next();
            players[i] = new Player(name);
        }
        // Бросаем жребий
        Player[] shuffledPlayers = shuffle(players);
        GuessNumber game = new GuessNumber(shuffledPlayers);

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

            System.out.print("Хотите продолжить игру? [yes / no]: ");
            choice = scan.next().toLowerCase();
        }
    }

    public static Player[] shuffle(Player[] players) {
        for (int i = players.length; i > 0; i--) {
            int num = (int) (Math.random() * i);
            Player tmpPlayer = players[0];
            players[0] = players[num];
            players[num] = tmpPlayer;
        }
        return players;
    }
}