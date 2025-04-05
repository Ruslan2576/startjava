package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    private Console() {
    }

    public static void printTriangle(char[] symbols, int start, int stop) {
        if (symbols == null) {
            System.out.printf("Ошибка: левая граница (%c) > правой (%c)%n", start, stop);
            return;
        }

        StringBuilder triangle = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {
            triangle.repeat(" ", symbols.length - 1 - i);
            triangle.append(symbols[i]).repeat(symbols[i], i * 2).append("\n");
        }
        System.out.println(triangle);
    }

    public static void printResults(float[] original, float[] modified, int index) {
        if (modified == null) {
            return;
        }

        if (index < 0 || index >= original.length) {
            System.out.printf("Ошибка: индекс %d находится за границами массива от %d до %d.%n",
                    index, 0, original.length - 1);
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

    public static void printArray(float[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%.3f ", numbers[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void printExpr(int[] original, int[] factorials) {
        if (original == null) {
            return;
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] < 0) {
                System.out.printf("Ошибка: факториал %d! не определен%n", original[i]);
                continue;
            }

            if (original[i] <= 1) {
                System.out.println(original[i] + "! = 1");
            } else {
                StringBuilder expr = new StringBuilder(original[i] + "! = ");
                for (int j = 1; j <= original[i]; j++) {
                    expr.append(j == original[i] ? j : j + " * ");
                }
                expr.append(" = ").append(factorials[i]);
                System.out.println(expr);
            }
        }
        System.out.println();
    }

    public static void printResult(int[] original, int[] reversed) {
        System.out.println("   До реверса: " + java.util.Arrays.toString(original));
        System.out.println("После реверса: " + Arrays.toString(reversed));
    }

    public static void printSortedNumbers(int[] numbers, int start, int stop, int width) {
        if (numbers == null) {
            return;
        }

        int len = (int) (Math.abs(start - stop) * .75);
        if (width < 1) {
            System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)%n", width);
            return;
        }

        if (len < 0) {
            System.out.printf("Ошибка: длина массива должна быть > 0 (%d)%n", len);
            return;
        }

        if (start >= stop) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n", start, stop);
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

    public static void type(String text) throws InterruptedException {
        if (text == null) {
            System.out.println("Ошибка: строка равна null.");
            return;
        }

        if (text.isBlank()) {
            System.out.println("Ошибка: строка пустая");
            return;
        }

        for (String s : text.split("")) {
            System.out.print(s);
            Thread.sleep(100);
        }
        System.out.println("\n");
    }
}
