package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private int number;
    private final int[] allNumbers = new int[10];
    private int lenAllNumbers;
    private int attempts = 1;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public int[] getAllNumbers() {
        return Arrays.copyOf(allNumbers, attempts - 1);
    }

    public void setNumbers(int number) {
        if (number > 0 && number < 101) {
            allNumbers[lenAllNumbers++] = number;
        }
    }

    public void clearAllNumbers() {
        Arrays.fill(allNumbers, 0, attempts - 1, 0);
        lenAllNumbers = 0;
    }

    public void showAllNumbers() {
        for (int number : getAllNumbers()) {
            System.out.printf("%d ", number);
        }
        System.out.println();
    }
}