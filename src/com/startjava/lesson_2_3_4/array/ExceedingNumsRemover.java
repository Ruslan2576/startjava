package com.startjava.lesson_2_3_4.array;

public class ExceedingNumsRemover {
    public static void main(String[] args) {
        float[] numbers = createRandomArray();

        float[] modified = remove(numbers, -1);
        printResult(numbers, modified, -1);

        modified = remove(numbers, 15);
        printResult(numbers, modified, 15);

        modified = remove(numbers, 0);
        printResult(numbers, modified, 0);

        modified = remove(numbers, 14);
        printResult(numbers, modified, 14);
    }

    private static float[] remove(float[] numbers, int index) {
        if (index < 0 || index >= numbers.length) {
            System.out.printf("Ошибка: индекс %d находится за границами массива от %d до %d.%n",
                    index, 0, numbers.length - 1);
            return null;
        }
        sdfdsfdfsfsfs
        float[] modified = new float[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[index]) {
                modified[i] = 0;
                continue;
            }
            modified[i] = numbers[i];
        }
        return modified;
    }

    private static void printResult(float[] original, float[] modified, int index) {
        if (modified == null) {
            return;
        }

        int count = 0;
        for (float number : original) {
            if (number > modified[index]) {
                count++;
            }
        }

        System.out.println("Исходный массив");
        printArray(original);

        System.out.println("Изменённый массив");
        printArray(modified);
        System.out.printf("Значение из ячейки по переданному индексу: %.3f%n", modified[index]);
        System.out.printf("Количество обнулённых ячеек: %d%n%n", count);
    }

    private static void printArray(float[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%.3f ", numbers[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static float[] createRandomArray() {
        float[] numbers = new float[15];
        for (int i = 0; i < 15; i++) {
            numbers[i] = (float) Math.random();
        }
        return numbers;
    }
}