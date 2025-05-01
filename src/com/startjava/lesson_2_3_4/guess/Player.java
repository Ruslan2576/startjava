package com.startjava.lesson_2_3_4.guess;

import static com.startjava.lesson_2_3_4.guess.GuessNumber.MAX_RANGE;
import static com.startjava.lesson_2_3_4.guess.GuessNumber.MIN_RANGE;

import java.io.IOException;
import java.util.Arrays;

public class Player {
    private static final int LEN_ARRAY = 10;
    private final String name;
    private final int[] numbers = new int[LEN_ARRAY];
    private int numbersCount;
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

    public void addNumber(int number) throws IOException {
        if (number > MIN_RANGE && number <= MAX_RANGE) {
            numbers[numbersCount++] = number;
        } else {
            throw new IOException();
        }
    }

    public int getLastNumber() {
        return numbers[attempts - 2];
    }

    public void clear() {
        Arrays.fill(numbers, 0, attempts - 1, 0);
        numbersCount = 0;
    }
}