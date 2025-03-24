package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverser {
    public static void main(String[] args) {
        int[] numbers1 = {};
        int[] numbersAfterReverse = reverse(numbers1);
        printResult(numbers1, numbersAfterReverse);

        int[] numbers2 = null;
        numbersAfterReverse = reverse(numbers2);
        printResult(numbers2, numbersAfterReverse);

        int[] numbers3 = {6, 8, 9, 1};
        numbersAfterReverse = reverse(numbers3);
        printResult(numbers3, numbersAfterReverse);

        int[] numbers4 = {13, 8, 5, 3, 2, 1, 1};
        numbersAfterReverse = reverse(numbers4);
        printResult(numbers4, numbersAfterReverse);
    }

    private static int[] reverse(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        int[] reversed = new int[numbers.length];
        int counter = numbers.length - 1;
        for (int number : numbers) {
            reversed[counter] = number;
            counter--;
        }
        return reversed;
    }

    private static void printResult(int[] numbersBeforeReverse, int[] numbersAfterReverse) {
        System.out.println("   До реверса: " + Arrays.toString(numbersBeforeReverse));
        System.out.println("После реверса: " + Arrays.toString(numbersAfterReverse));
    }
}
