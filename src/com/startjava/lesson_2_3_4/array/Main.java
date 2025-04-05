package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        displayCharacterTriangle();
        exceedingNumsRemove();
        factorial();
        reverser();
        System.out.println();
        uniqueNumbersFiller();
        textOutputTypeWriter();
    }

    private static void displayCharacterTriangle() {
        // DisplayCharacterTriangle
        char[] symbols = Arrays.sortSymbols('0', '9', true);
        Console.printTriangle(symbols, '0', '9');

        symbols = Arrays.sortSymbols('/', '!', false);
        Console.printTriangle(symbols, '/', '!');

        symbols = Arrays.sortSymbols('A', 'J', false);
        Console.printTriangle(symbols, 'A', 'J');
    }

    private static void exceedingNumsRemove() {
        // ExceedingNumsRemove
        float[] numbers = Arrays.createRandomArr();

        float[] modified = Arrays.remove(numbers, -1);
        Console.printResults(numbers, modified, -1);

        modified = Arrays.remove(numbers, 15);
        Console.printResults(numbers, modified, 15);

        modified = Arrays.remove(numbers, 0);
        Console.printResults(numbers, modified, 0);

        modified = Arrays.remove(numbers, 14);
        Console.printResults(numbers, modified, 14);
    }

    private static void factorial() {
        // Factorial
        int[] numbers1 = {};
        int[] factorial1 = Arrays.calc(numbers1);
        Console.printExpr(numbers1, factorial1);

        int[] numbers2 = null;
        int[] factorial2 = Arrays.calc(numbers2);
        Console.printExpr(numbers2, factorial2);

        int[] numbers3 = {8, 0, 9};
        int[] factorial3 = Arrays.calc(numbers3);
        Console.printExpr(numbers3, factorial3);

        int[] numbers4 = {-3, 1, 7, 13};
        int[] factorial4 = Arrays.calc(numbers4);
        Console.printExpr(numbers4, factorial4);

        int[] numbers5 = {-22, -0};
        int[] factorial5 = Arrays.calc(numbers5);
        Console.printExpr(numbers5, factorial5);
    }

    private static void reverser() {
        // Reverser
        int[] numbersReverser1 = {};
        int[] reversed = Arrays.reverse(numbersReverser1);
        Console.printResult(numbersReverser1, reversed);

        int[] numbersReverser2 = null;
        reversed = Arrays.reverse(numbersReverser2);
        Console.printResult(numbersReverser2, reversed);

        int[] numbersReverser3 = {6, 8, 9, 1};
        reversed = Arrays.reverse(numbersReverser3);
        Console.printResult(numbersReverser3, reversed);

        int[] numbersReverser4 = {13, 8, 5, 3, 2, 1, 1};
        reversed = Arrays.reverse(numbersReverser4);
        Console.printResult(numbersReverser4, reversed);
    }

    private static void uniqueNumbersFiller() {
        // UniqueNumbersFiller
        Console.printSortedNumbers(Arrays.createRandomArray(-30, -10, 23), -30, -10, 23);
        Console.printSortedNumbers(Arrays.createRandomArray(10, 50, 10), 10, 50, 10);
        Console.printSortedNumbers(Arrays.createRandomArray(-34, -34, 0), -34, -34, 0);
        Console.printSortedNumbers(Arrays.createRandomArray(-1, 2, -3), -1, 2, -3);
        Console.printSortedNumbers(Arrays.createRandomArray(5, -8, 2), 5, -8, 2);
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
