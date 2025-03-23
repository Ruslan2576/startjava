package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] numbers1 = {};
        System.out.println("До реверса: " + Arrays.toString(numbers1));
        printResult(reverse(numbers1));

        int[] numbers2 = null;
        System.out.println("До реверса: " + Arrays.toString(numbers2));
        printResult(reverse(numbers2));

        int[] numbers3 = {6, 8, 9, 1};
        System.out.println("До реверса: " + Arrays.toString(numbers3));
        printResult(reverse(numbers3));

        int[] numbers4 = {13, 8, 5, 3, 2, 1, 1};
        System.out.println("До реверса: " + Arrays.toString(numbers4));
        printResult(reverse(numbers4));
    }

    public static int[] reverse(int[] numbers) {
        if (numbers != null) {
            int[] result = new int[numbers.length];
            int counter = 0;
            for (int i = numbers.length - 1; i >= 0; i--) {
                result[counter] = numbers[i];
                counter++;
            }
            return result;
        }
        return null;
    }

    public static void printResult(int[] numbers) {
        System.out.println("После реверса: " + Arrays.toString(numbers));
    }
}
