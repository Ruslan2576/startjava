package com.startjava.lesson_2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        int[] numbers1 = {};
        int[] factorial1 = getFactorial(numbers1);
        printResult(numbers1, factorial1);

        int[] numbers2 = null;
        int[] factorial2 = getFactorial(numbers2);
        printResult(numbers2, factorial2);

        int[] numbers3 = {8, 0, 9};
        int[] factorial3 = getFactorial(numbers3);
        printResult(numbers3, factorial3);

        int[] numbers4 = {-3, 1, 7, 13};
        int[] factorial4 = getFactorial(numbers4);
        printResult(numbers4, factorial4);

        int[] numbers5 = {-22, -0};
        int[] factorial5 = getFactorial(numbers5);
        printResult(numbers5, factorial5);
    }

    private static int[] getFactorial(int... numbers) {
        if (numbers == null) {
            return null;
        }
        int[] factorial = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 1) {
                factorial[i] = numbers[i];
                continue;
            }
            int result = 1;
            for (int j = 1; j <= numbers[i]; j++) {
                result *= j;
            }
            factorial[i] = result;
        }
        return factorial;
    }

    private static void printResult(int[] original, int[] factorial) {
        if (original == null) {
            return;
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] < 1) {
                System.out.printf("Ошибка: факториал %d! не определен%n", original[i]);
                continue;
            }
            StringBuilder result = new StringBuilder("!" + original[i] + " = ");
            for (int j = 1; j <= original[i]; j++) {
                result.append(j).append(" * ");
            }
            result.delete(result.length() - 3, result.length());
            result.append(original[i] == 1 ? "" : " = " + factorial[i]);
            System.out.println(result);
        }
        System.out.println();
    }
}
