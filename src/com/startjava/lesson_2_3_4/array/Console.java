package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    private Console() {
    }

    public static void printArrayTwoLines(float[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%.3f ", numbers[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void printFactorialExpr(int[] original, int[] factorials) {
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

    public static void printTwoArrays(float[] original, float[] modified, int index) {
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
        printArrayTwoLines(original);

        System.out.println("Изменённый массив");
        printArrayTwoLines(modified);
        System.out.printf("Значение из ячейки по переданному индексу: %.3f%n", modified[index]);
        System.out.printf("Количество обнулённых ячеек: %d%n%n", count);
    }

    public static void printBeforeAfterReversed(int[] original, int[] reversed) {
        System.out.println("   До реверса: " + Arrays.toString(original));
        System.out.println("После реверса: " + Arrays.toString(reversed));
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

    public static void printTriangle(char[] symbols) {
        if (symbols == null) {
            return;
        }

        StringBuilder triangle = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {
            triangle.repeat(" ", symbols.length - 1 - i);
            triangle.append(symbols[i]).repeat(symbols[i], i * 2).append("\n");
        }
        System.out.println(triangle);
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
