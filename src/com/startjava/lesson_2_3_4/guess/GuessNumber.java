package com.startjava.lesson_2_3_4.guess;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
    private static final int MAX_ATTEMPTS = 10;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final Player thirdPlayer;

    public GuessNumber(Player[] players) {
        this.firstPlayer = players[0];
        this.secondPlayer = players[1];
        this.thirdPlayer = players[2];
    }

    public void play() {
        int countRound = 1;

        while (countRound < 4) {
            System.out.printf("Раунд №%d%n", countRound);
            System.out.println("Игра началась! У каждого игрока по 10 попыток");
            int secretNumber = (int) (Math.random() * 100) + 1;
            while (thirdPlayer.getAttempts() <= MAX_ATTEMPTS) {
                inputNumber(firstPlayer);
                if (checkNumber(firstPlayer, secretNumber)) {
                    break;
                }

                checkAttempts(firstPlayer);

                inputNumber(secondPlayer);
                if (checkNumber(secondPlayer, secretNumber)) {
                    break;
                }
                checkAttempts(secondPlayer);

                inputNumber(thirdPlayer);
                if (checkNumber(thirdPlayer, secretNumber)) {
                    break;
                }
                checkAttempts(thirdPlayer);
            }

            printCurrentResult();

            firstPlayer.clear();
            secondPlayer.clear();

            firstPlayer.setAttempts(1);
            secondPlayer.setAttempts(1);
            countRound++;
        }
        printFinalResult();
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
                System.out.print("Число должно входить в отрезок [1, 100]\n" +
                        "Попробуйте еще раз: ");
                number = scan.nextInt();
            }
        } while (true);
        player.addNumber(number);
        player.setAttempts(player.getAttempts() + 1);
    }

    private boolean checkNumber(Player player, int secretNumber) {
        int currNumber = player.getLastElementInNumbers();

        if (currNumber == secretNumber) {
            System.out.printf("%s угадал число %d с %d-й попытки.%n",
                    player.getName(), currNumber, player.getAttempts() - 1);
            player.setVictories();
            return true;
        }

        System.out.printf("%d %s загаданного числа%n",
                currNumber, currNumber > secretNumber ? "больше" : "меньше");

        return false;
    }

    public void checkAttempts(Player player) {
        if (player.getAttempts() > MAX_ATTEMPTS) {
            System.out.printf("У %s закончились попытки!%n", player.getName());
        }
    }
    
    public void printCurrentResult() {
        System.out.printf("Все числа введенные %s: ", firstPlayer.getName());
        System.out.println(Arrays.toString(firstPlayer.getNumbers()).replaceAll("[\\[\\],]", ""));

        System.out.printf("Все числа введенные %s: ", secondPlayer.getName());
        System.out.println(Arrays.toString(secondPlayer.getNumbers()).replaceAll("[\\[\\],]", ""));

        System.out.printf("Все числа введенные %s: ", thirdPlayer.getName());
        System.out.println(Arrays.toString(thirdPlayer.getNumbers()).replaceAll("[\\[\\],]", ""));
    }

    public void printFinalResult() {
        int a = firstPlayer.getVictories();
        int b = secondPlayer.getVictories();
        int c = thirdPlayer.getVictories();

        if (a > b && a > c) {
            System.out.printf("По результатам трёх раундов победу одержал %s, у него %d побед(ы)%n",
                    firstPlayer.getName(), a);
        } else if (b > a && b > c) {
            System.out.printf("По результатам трёх раундов победу одержал %s, у него %d побед(ы)%n",
                    secondPlayer.getName(), b);
        } else if (c > a && c > b) {
            System.out.printf("По результатам трёх раундов победу одержал %s, у него %d побед(ы)%n",
                    thirdPlayer.getName(), c);
        } else if (a == b && a == c) {
            System.out.printf("Боевая ничья: у всех по %d побед%n", a);
        } else if (a == b) {
            System.out.printf("У нас два победителя это %s и %s у них по %d победе%n",
                    firstPlayer.getName(), secondPlayer.getName(), firstPlayer.getVictories());
        } else if (a == c) {
            System.out.printf("У нас два победителя это %s и %s у них по %d победе%n",
                    firstPlayer.getName(), thirdPlayer.getName(), firstPlayer.getVictories());
        } else {
            System.out.printf("У нас два победителя это %s и %s у них по %d победе%n",
                    secondPlayer.getName(), thirdPlayer.getName(), secondPlayer.getVictories());
        }
    }
}