package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        reverser();
        factorial();
        exceedingNumsRemove();
        displayCharacterTriangle();
        uniqueNumbersFiller();
        textOutputTypeWriter();
    }

    private static void reverser() {
        int[] numbersReverser = new int[0];
        int[] reversed = Arrays.reverse(numbersReverser);
        Console.printReverseArray(numbersReverser, reversed);

        numbersReverser = null;
        reversed = Arrays.reverse(numbersReverser);
        Console.printReverseArray(numbersReverser, reversed);

        numbersReverser = new int[]{6, 8, 9, 1};
        reversed = Arrays.reverse(numbersReverser);
        Console.printReverseArray(numbersReverser, reversed);

        numbersReverser = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversed = Arrays.reverse(numbersReverser);
        Console.printReverseArray(numbersReverser, reversed);
    }

    private static void factorial() {
        int[] numbers1 = {};
        int[] factorials = Arrays.calc(numbers1);
        Console.printExpr(numbers1, factorials);

        int[] numbers2 = null;
        factorials = Arrays.calc(numbers2);
        Console.printExpr(numbers2, factorials);

        int[] numbers3 = {8, 0, 9};
        factorials = Arrays.calc(numbers3);
        Console.printExpr(numbers3, factorials);

        int[] numbers4 = {-3, 1, 7, 13};
        factorials = Arrays.calc(numbers4);
        Console.printExpr(numbers4, factorials);

        int[] numbers5 = {-22, -0};
        factorials = Arrays.calc(numbers5);
        Console.printExpr(numbers5, factorials);
    }

    private static void exceedingNumsRemove() {
        float[] numbers = Arrays.createRandomArray();

        float[] modified = Arrays.remove(numbers, -1);
        Console.printNumsRemove(numbers, modified, -1);

        modified = Arrays.remove(numbers, 15);
        Console.printNumsRemove(numbers, modified, 15);

        modified = Arrays.remove(numbers, 0);
        Console.printNumsRemove(numbers, modified, 0);

        modified = Arrays.remove(numbers, 14);
        Console.printNumsRemove(numbers, modified, 14);
    }

    private static void displayCharacterTriangle() {
        char[] symbols = Arrays.sortSymbols('0', '9', true);
        Console.printTriangle(symbols, '0', '9');

        symbols = Arrays.sortSymbols('/', '!', false);
        Console.printTriangle(symbols, '/', '!');

        symbols = Arrays.sortSymbols('A', 'J', false);
        Console.printTriangle(symbols, 'A', 'J');
    }

    private static void uniqueNumbersFiller() {
        Console.printSortedNumbers(Arrays.createUniqueNumsArray(-30, -10, 23), -30, -10, 23);
        Console.printSortedNumbers(Arrays.createUniqueNumsArray(10, 50, 10), 10, 50, 10);
        Console.printSortedNumbers(Arrays.createUniqueNumsArray(-34, -34, 0), -34, -34, 0);
        Console.printSortedNumbers(Arrays.createUniqueNumsArray(-1, 2, -3), -1, 2, -3);
        Console.printSortedNumbers(Arrays.createUniqueNumsArray(5, -8, 2), 5, -8, 2);
    }

    private static void textOutputTypeWriter() throws InterruptedException {
        String str1 = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";

        String str2 = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        Console.type(Arrays.toUpperCaseRange(str1));
        Console.type(Arrays.toUpperCaseRange(str2));
        Console.type(Arrays.toUpperCaseRange(null));
        Console.type(Arrays.toUpperCaseRange(""));
    }
}
