package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Replacer {
    public static void main(String[] args) {
        float[] numbers = new float[15];
        for (int i = 0; i < 15; i++) {
            numbers[i] = (float) Math.random();
        }

        printArray(numbers, replace(numbers, -1), -1);
        printArray(numbers, replace(numbers, 15), 15);
        printArray(numbers, replace(numbers, 0), 0);
        printArray(numbers, replace(numbers, 14), 14);
    }

    private static float[] replace(float[] numbers, int index) {
        if (index + 1 < 0 || index + 1 >= numbers.length) {
            return numbers;
        }
        float[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        Arrays.fill(numbersCopy, index + 1, numbers.length, 0);
        return numbersCopy;
    }

    private static void printArray(float[] original, float[] replacedNumbers, int index) {
        System.out.println("Исходный массив");
        for (int i = 0; i < original.length; i++) {
            System.out.printf("%.3f ", original[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println("\n");

        System.out.println("Изменённый массив");
        for (int i = 0; i < replacedNumbers.length; i++) {
            System.out.printf("%.3f ", replacedNumbers[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println();

        if (index > replacedNumbers.length - 1 || index < 0) {
            System.out.printf("Ошибка: индекс %d отсутствует%n", index);
        } else {
            System.out.printf("Значение из ячейки по индексу %d: %.3f%n", index, replacedNumbers[index]);
        }
        int counterZero = index >= replacedNumbers.length ||
                index < -1 ? 0 : replacedNumbers.length - 1 - index;
        System.out.printf("Количество обнулённых ячеек: %d%n%n", counterZero);
    }
}
