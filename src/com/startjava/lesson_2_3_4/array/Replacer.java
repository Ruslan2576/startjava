package com.startjava.lesson_2_3_4.array;

public class Replacer {
    public static void main(String[] args) {
        float[] numbers = new float[15];
        for (int i = 0; i < 15; i++) {
            numbers[i] = (float) Math.random();
        }

        replaceNumbers(numbers, -1);
        replaceNumbers(numbers, 15);
        replaceNumbers(numbers, 0);
        replaceNumbers(numbers, 14);
    }

    private static void replaceNumbers(float[] numbers, int index) {
        if (index < 0 || index >= numbers.length) {
            System.out.println("Ошибка: вы вышли за пределы индекса массива.");
            return;
        }

        int count = 0;
        float[] replacedNumbers = new float[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[index]) {
                replacedNumbers[i] = 0;
                count++;
                continue;
            }
            replacedNumbers[i] = numbers[i];
        }
        printArray(numbers, replacedNumbers, index, count);
    }

    private static void printArray(float[] original, float[] replacedNumbers, int index, int count) {
        System.out.println("Исходный массив");
        for (int i = 0; i < original.length; i++) {
            System.out.printf("%.3f ", original[i]);
            if (i == 7) {
                System.out.println();
            }
        }

        System.out.println("\nИзменённый массив");
        for (int i = 0; i < replacedNumbers.length; i++) {
            System.out.printf("%.3f ", replacedNumbers[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.printf("%nЗначение из ячейки по индексу %d: %.3f%n", index, original[index]);
        System.out.printf("Количество обнулённых ячеек: %d%n%n", count);
    }
}
