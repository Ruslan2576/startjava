package com.startjava.lesson_2_3_4.guess;

import java.io.IOException;
import java.util.Scanner;

public class GuessNumber {
    private final Player firstPlayer;
    private final Player secondPlayer;
    private static final int MAX_ATTEMPTS = 10;

    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play() {
        System.out.println("Игра началась! У каждого игрока по 10 попыток");
        int secretNumber = (int) (Math.random() * 100) + 1;
        while (secondPlayer.getAttempts() <= MAX_ATTEMPTS) {
            inputNumber(firstPlayer);
            if (checkNumber(firstPlayer, secretNumber)) {
                break;
            }

            inputNumber(secondPlayer);
            if (checkNumber(secondPlayer, secretNumber)) {
                break;
            }
        }
        System.out.printf("Все числа введенные %s: ", firstPlayer.getName());
        firstPlayer.showAllNumbers();
        System.out.printf("Все числа введенные %s: ", secondPlayer.getName());
        secondPlayer.showAllNumbers();

        firstPlayer.clearAllNumbers();
        secondPlayer.clearAllNumbers();

        firstPlayer.setAttempts(1);
        secondPlayer.setAttempts(1);
    }

    private void inputNumber(Player player) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Попытка №%d\n Число вводит %s: ", player.getAttempts(), player.getName());
        int number = scan.nextInt();

        do {
            try {
                if (number < 1 || number > 100) {
                    throw new IOException();
                }
                break;
            } catch (IOException ex) {
                System.out.print("Число должно входить в отрезок [1, 100].\n" +
                        "Попробуйте еще раз: ");
                number = scan.nextInt();
            }
        } while (true);

        player.setNumber(number);
        player.setAttempts(player.getAttempts() + 1);
    }

    private boolean checkNumber(Player player, int secretNumber) {
        int currNumber = player.getNumber();
        player.setNumbers(currNumber);

        if (currNumber == secretNumber) {
            System.out.printf("%s угадал число %d с %d-й попытки.%n",
                    player.getName(), currNumber, player.getAttempts() - 1);
            return true;
        }

        System.out.printf("%d %s загаданного числа%n",
                currNumber, currNumber > secretNumber ? "больше" : "меньше");

        if (player.getAttempts() > MAX_ATTEMPTS) {
            System.out.printf("У %s закончились попытки!%n", player.getName());
        }

        return false;
    }
}