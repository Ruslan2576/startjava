package com.startjava.lesson_2_3_4.guess;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS = 10;
    private static final int NUMBER_OF_ROUNDS = 3;
    static final int MAX_RANGE = 100;
    static final int MIN_RANGE = 1;
    private final Player[] players;

    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void play() {
        int countRound = 0;
        shuffle();
        while (countRound < NUMBER_OF_ROUNDS) {
            boolean isGuessed = false;
            System.out.printf("Раунд №%d%n", ++countRound);
            System.out.println("Игра началась! У каждого игрока по 10 попыток");
            int secretNumber = (int) (Math.random() * MAX_RANGE) + 1;
            while (hasAttempts() && !isGuessed) {
                for (Player player : players) {
                    inputNumber(player);
                    if (checkNumber(player, secretNumber)) {
                        isGuessed = true;
                        break;
                    }

                    checkAttempts(player);
                }
            }
            printRoundResult();
            reset();
        }
        printFinalResult();
    }

    private void shuffle() {
        for (int i = players.length; i > 0; i--) {
            int randomIndex = (int) (Math.random() * i);
            Player tmpPlayer = players[0];
            players[0] = players[randomIndex];
            players[randomIndex] = tmpPlayer;
        }
    }

    private boolean hasAttempts() {
        int attemptsCount = players[players.length - 1].getAttempts();
        return attemptsCount <= MAX_ATTEMPTS;
    }

    private void inputNumber(Player player) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Попытка №%d\n Число вводит %s: ", player.getAttempts(), player.getName());
        int number = scan.nextInt();

        do {
            try {
                player.addNumber(number);
                break;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                number = scan.nextInt();
            }
        } while (true);
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
    
    private void printRoundResult() {
        for (Player player : players) {
            System.out.printf("Все числа введенные %s: ", player.getName());
            System.out.println(Arrays.toString(player.getNumbers()).replaceAll("[\\[\\],]", ""));
        }
    }

    private void reset() {
        for (Player player : players) {
            player.clear();
            player.setAttempts(1);
        }
    }

    private void printFinalResult() {
        Arrays.sort(players, Comparator.comparingInt(Player::getVictories).reversed());
        if (players[0].getVictories() > players[1].getVictories()) {
            System.out.printf("По результатам трёх раундов победил %s у него %d побед(ы)%n",
                    players[0].getName(), players[0].getVictories());
            System.out.println("Результаты остальных участников");
            for (int i = 1; i < players.length; i++) {
                System.out.println(players[i].getName() + " количество побед: " + players[i].getVictories());
            }
        }

        if (players[0].getVictories() == players[1].getVictories() &&
                players[0].getVictories() == players[2].getVictories()) {
            System.out.println("По результатам трёх раундов у нас ничья");
            for (Player player : players) {
                System.out.println(player.getName() + " количество побед: " + player.getVictories());
            }
        }
    }
}