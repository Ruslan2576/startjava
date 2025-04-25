package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] numbers = new int[10];
    private int lenAllNumbers;
    private int attempts = 1;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempts - 1);
    }

    public void addNumber(int number) {
        if (number > 0 && number < 101) {
            numbers[lenAllNumbers++] = number;
        }
    }

    public void clearNumbers() {
        Arrays.fill(numbers, 0, attempts - 1, 0);
        lenAllNumbers = 0;
    }
}