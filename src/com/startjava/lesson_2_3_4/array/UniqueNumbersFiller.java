package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersFiller {
    public static void main(String[] args) {
        printSortedNumbers(createRandomArray(-30, -10, 23));
        printSortedNumbers(createRandomArray(10, 50, 10));
        printSortedNumbers(createRandomArray(-34, -34, 0));
        printSortedNumbers(createRandomArray(-1, 2, -3));
        printSortedNumbers(createRandomArray(5, -8, 2));
    }

    public static int[][] createRandomArray(int start, int stop, int count) {
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

        if (count > len) {
            count = Math.abs(stop - start + 1);
        }

        int[][] numbers = new int[len][count];
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < count; j++) {
                boolean isEquals = false;
                int randomNumber = rand.nextInt(start, stop + 1);
                for (int k = 0; k < count; k++) {
                    if (numbers[i][k] == randomNumber) {
                        isEquals = true;
                        j--;
                        break;
                    }
                }
                if (!isEquals) {
                    numbers[i][j] = randomNumber;
                }
            }
        }
        return numbers;
    }

    public static void printSortedNumbers(int[][] numbers) {
        if (numbers == null) {
            return;
        }
        for (int[] number : numbers) {
            Arrays.sort(number);
            System.out.println(Arrays.toString(number));
        }
    }
}

