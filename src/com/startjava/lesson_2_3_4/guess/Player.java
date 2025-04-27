package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] numbers = new int[10];
    private int countNumbers;
    private int attempts = 1;
    private int victories;

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

    public int getVictories() {
        return victories;
    }

    public void setVictories() {
        victories++;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempts - 1);
    }

    public void addNumber(int number) {
        if (number > 0 && number < 101) {
            numbers[countNumbers++] = number;
        }
    }

    public void clear() {
        Arrays.fill(numbers, 0, attempts - 1, 0);
        countNumbers = 0;
    }

    public int getLastElementInNumbers() {
        return getNumbers()[getNumbers().length - 1];
    }
}