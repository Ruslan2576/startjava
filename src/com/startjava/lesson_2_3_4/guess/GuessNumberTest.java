package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final int PLAYERS_COUNT = 3;

    public static void main(String[] args) {
        System.out.println("Угадай число в диапазоне [1, 100]");
        Scanner scan = new Scanner(System.in);
        GuessNumber game = new GuessNumber(createPlayers());
        String choice = YES;

        while (!choice.equals(NO)) {
            if (!choice.equals(YES)) {
                System.out.print("Введите корректный ответ [yes / no]: ");
                choice = scan.next().toLowerCase();
                if (!choice.equals(YES)) {
                    continue;
                }
            }

            game.play();

            System.out.print("Хотите продолжить игру? [yes / no]: ");
            choice = scan.next().toLowerCase();
        }
    }

    private static Player[] createPlayers() {
        Scanner scan = new Scanner(System.in);
        Player[] players = new Player[PLAYERS_COUNT];
        for (int i = 0; i < players.length; i++) {
            System.out.printf("Игрок №%d введите своё имя: ", i + 1);
            players[i] = new Player(scan.next());
        }
        return players;
    }
}