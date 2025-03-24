package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverser {
    public static void main(String[] args) {
        int[] numbers1 = {};
        int[] reversed = reverse(numbers1);
        printResult(numbers1, reversed);

        int[] numbers2 = null;
        reversed = reverse(numbers2);
        printResult(numbers2, reversed);

        int[] numbers3 = {6, 8, 9, 1};
        reversed = reverse(numbers3);
        printResult(numbers3, reversed);

        int[] numbers4 = {13, 8, 5, 3, 2, 1, 1};
        reversed = reverse(numbers4);
        printResult(numbers4, reversed);
    }

    private static int[] reverse(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        int[] reversed = new int[numbers.length];
        int counter = numbers.length - 1;
        for (int number : numbers) {
            reversed[counter--] = number;
        }
        return reversed;
    }

    private static void printResult(int[] original, int[] reversed) {
        System.out.println("   До реверса: " + Arrays.toString(original));
        System.out.println("После реверса: " + Arrays.toString(reversed));
    }
}