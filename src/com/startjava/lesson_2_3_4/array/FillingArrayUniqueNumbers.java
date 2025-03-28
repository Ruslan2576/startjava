package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class FillingArrayUniqueNumbers {
    public static void main(String[] args) {
        printSortedNumbers(numbersRange(-30, -10, 23));
        printSortedNumbers(numbersRange(10, 50, 10));
        printSortedNumbers(numbersRange(-34, -34, 0));
        printSortedNumbers(numbersRange(-1, 2, -3));
        printSortedNumbers(numbersRange(5, -8, 2));
    }

    public static int[] numbersRange(int start, int stop, int count) {
        int len = (int) (count * .75);
        if (count < 1) {
            System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)%n", count);
            return null;
        }

        if (len < 0) {
            System.out.printf("Ошибка: длина массива должна быть > 0 (%d)%n", len);
            return null;
        }

        if (start >= stop) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n", start, stop);
            return null;
        }

        Random rand = new Random();
        int[] numbers = new int[len];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(start, stop + 1);
        }
        return numbers;
    }

    public static void printSortedNumbers(int[] numbers) {
        if (numbers == null) {
            return;
        }
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
