package com.startjava.lesson_2_3_4.guess;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
    private static final int MAX_ATTEMPTS = 10;
    private static final int NUMBER_OF_ROUNDS = 3;
    static final int MAX_RANGE = 100;
    static final int MIN_RANGE = 1;
    private final Player[] players;

    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void play() {
        int countRound = 0;
        Player[] shuffledPlayers = shuffle(players);
        while (countRound < NUMBER_OF_ROUNDS) {
            boolean isGuess = false;
            System.out.printf("Раунд №%d%n", ++countRound);
            System.out.println("Игра началась! У каждого игрока по 10 попыток");
            int secretNumber = (int) (Math.random() * MAX_RANGE) + 1;
            while (shuffledPlayers[shuffledPlayers.length - 1].getAttempts() <= MAX_ATTEMPTS && !isGuess) {
                for (Player player : shuffledPlayers) {
                    inputNumber(player);
                    if (checkNumber(player, secretNumber)) {
                        isGuess = true;
                        break;
                    }

                    checkAttempts(player);
                }
            }
            printCurrentResult(shuffledPlayers);
            reset(shuffledPlayers);
        }
        printFinalResult(shuffledPlayers);
    }

    private static Player[] shuffle(Player[] players) {
        for (int i = players.length; i > 0; i--) {
            int num = (int) (Math.random() * i);
            Player tmpPlayer = players[0];
            players[0] = players[num];
            players[num] = tmpPlayer;
        }
        return players;
    }

    private void inputNumber(Player player) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Попытка №%d\n Число вводит %s: ", player.getAttempts(), player.getName());
        int number = scan.nextInt();

        do {
            try {
                if (number < MIN_RANGE || number > MAX_RANGE) {
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
        int currNumber = player.getLastNumber();

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

    private void checkAttempts(Player player) {
        if (player.getAttempts() > MAX_ATTEMPTS) {
            System.out.printf("У %s закончились попытки!%n", player.getName());
        }
    }
    
    private void printCurrentResult(Player[] players) {
        for (Player player : players) {
            System.out.printf("Все числа введенные %s: ", player.getName());
            System.out.println(Arrays.toString(player.getNumbers()).replaceAll("[\\[\\],]", ""));
        }
    }

    private static void reset(Player[] players) {
        for (Player player : players) {
            player.clear();
            player.setAttempts(1);
        }
    }

    private void printFinalResult(Player[] players) {
        int a = players[0].getVictories();
        int b = players[1].getVictories();
        int c = players[2].getVictories();

        if (a > b && a > c) {
            System.out.printf("По результатам трёх раундов победу одержал %s, у него %d побед(ы)%n",
                    players[0].getName(), a);
        } else if (b > a && b > c) {
            System.out.printf("По результатам трёх раундов победу одержал %s, у него %d побед(ы)%n",
                    players[1].getName(), b);
        } else if (c > a && c > b) {
            System.out.printf("По результатам трёх раундов победу одержал %s, у него %d побед(ы)%n",
                    players[2].getName(), c);
        } else if (a == b && a == c) {
            System.out.printf("Боевая ничья: у всех по %d побед%n", a);
        } else if (a == b) {
            System.out.printf("У нас два победителя это %s и %s у них по %d победе%n",
                    players[0].getName(), players[1].getName(), players[2].getVictories());
        } else if (a == c) {
            System.out.printf("У нас два победителя это %s и %s у них по %d победе%n",
                    players[0].getName(), players[2].getName(), players[0].getVictories());
        } else {
            System.out.printf("У нас два победителя это %s и %s у них по %d победе%n",
                    players[1].getName(), players[2].getName(), players[1].getVictories());
        }
    }
}