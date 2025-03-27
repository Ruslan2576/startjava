package com.startjava.lesson_2_3_4.array;

public class ResettingCells {
    public static void main(String[] args) {
        float[] numbers = new float[15];
        for (int i = 0; i < 15; i++) {
            numbers[i] = (float) Math.random();
        }

        float[] replacedNumbers = resetCells(numbers, -1);
        if (replacedNumbers != null) {
            printArray(numbers, replacedNumbers, -1);
        }

        replacedNumbers = resetCells(numbers, 15);
        if (replacedNumbers != null) {
            printArray(numbers, replacedNumbers, 15);
        }

        replacedNumbers = resetCells(numbers, 0);
        if (replacedNumbers != null) {
            printArray(numbers, replacedNumbers, 0);
        }

        replacedNumbers = resetCells(numbers, 14);
        if (replacedNumbers != null) {
            printArray(numbers, replacedNumbers, 14);
        }
    }

    private static float[] resetCells(float[] numbers, int index) {
        if (index < 0 || index >= numbers.length) {
            System.out.printf("Ошибка: индекс %d находится за границами массива от %d до %d.%n",
                    index, 0, numbers.length - 1);
            return null;
        }

        float[] replacedNumbers = new float[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[index]) {
                replacedNumbers[i] = 0;
                continue;
            }
            replacedNumbers[i] = numbers[i];
        }
        return replacedNumbers;
    }

    private static void printArray(float[] original, float[] replacedNumbers, int index) {
        int count = 0;
        for (float number : original) {
            if (number > replacedNumbers[index]) {
                count++;
            }
        }
        System.out.println("Исходный массив");
        displaysArray(original);

        System.out.println("Изменённый массив");
        displaysArray(replacedNumbers);
        System.out.printf("Значение из ячейки по переданному индексу: %.3f%n", replacedNumbers[index]);
        System.out.printf("Количество обнулённых ячеек: %d%n%n", count);
    }

    private static void displaysArray(float[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%.3f ", numbers[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
