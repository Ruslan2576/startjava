package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersFiller {
    public static void main(String[] args) {
        printSortedNumbers(createRandomArray(-30, -10, 23), 23);
        printSortedNumbers(createRandomArray(10, 50, 10), 10);
        printSortedNumbers(createRandomArray(-34, -34, 0), 0);
        printSortedNumbers(createRandomArray(-1, 2, -3), -3);
        printSortedNumbers(createRandomArray(5, -8, 2), 2);
    }

    public static int[] createRandomArray(int start, int stop, int count) {
        int len = (int) (Math.abs(start - stop) * .75);
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

        int[] numbers = new int[len];
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            boolean isEquals = false;
            int randomNumber = rand.nextInt(start, stop + 1);
            for (int j = 0; j < i; j++) {
                if (numbers[j] == randomNumber) {
                    isEquals = true;
                    i--;
                    break;
                }
            }
            if (!isEquals) {
                numbers[i] = randomNumber;
            }
        }
        return numbers;
    }

    public static void printSortedNumbers(int[] numbers, int width) {
        if (numbers == null) {
            return;
        }

        Arrays.sort(numbers);
        int count = 1;
        for (int number : numbers) {
            System.out.printf("%3d ", number);
            if (count == width) {
                System.out.println();
                count = 0;
            }
            count++;
        }
        System.out.println("\n");
    }
}

