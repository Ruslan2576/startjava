package com.startjava.lesson_2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        int[] numbers1 = {};
        int[] factorial1 = calc(numbers1);
        printExpr(numbers1, factorial1);

        int[] numbers2 = null;
        int[] factorial2 = calc(numbers2);
        printExpr(numbers2, factorial2);

        int[] numbers3 = {8, 0, 9};
        int[] factorial3 = calc(numbers3);
        printExpr(numbers3, factorial3);

        int[] numbers4 = {-3, 1, 7, 13};
        int[] factorial4 = calc(numbers4);
        printExpr(numbers4, factorial4);

        int[] numbers5 = {-22, -0};
        int[] factorial5 = calc(numbers5);
        printExpr(numbers5, factorial5);
    }

    private static int[] calc(int... numbers) {
        if (numbers == null) {
            return null;
        }
        int[] factorials = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                continue;
            }
            int result = 1;
            for (int j = 2; j <= numbers[i]; j++) {
                result *= j;
            }
            factorials[i] = result;
        }
        return factorials;
    }

    private static void printExpr(int[] original, int[] factorials) {
        if (original == null) {
            return;
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] < 0) {
                System.out.printf("Ошибка: факториал %d! не определен%n", original[i]);
                continue;
            } else if (original[i] <= 1) {
                System.out.println(original[i] + "! = 1");
                continue;
            }

            StringBuilder expr = new StringBuilder(original[i] + "! = ");
            for (int j = 1; j <= original[i]; j++) {
                expr.append(j == original[i] ? j : j + " * ");
            }
            expr.append(" = ").append(factorials[i]);
            System.out.println(expr);
        }
        System.out.println();
    }
}
