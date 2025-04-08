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
        int[] reversed = Arrays.reverse(new int[]{});
        Console.printReverseArray(new int[]{}, reversed);

        reversed = Arrays.reverse(null);
        Console.printReverseArray(null, reversed);

        reversed = Arrays.reverse(new int[]{6, 8, 9, 1});
        Console.printReverseArray(new int[]{6, 8, 9, 1}, reversed);

        reversed = Arrays.reverse(new int[]{13, 8, 5, 3, 2, 1, 1});
        Console.printReverseArray(new int[]{13, 8, 5, 3, 2, 1, 1}, reversed);
    }

    private static void factorial() {
        int[] factorials = Arrays.calc();
        Console.printFactorialExpr(new int[]{}, factorials);

        factorials = Arrays.calc(null);
        Console.printFactorialExpr(null, factorials);

        factorials = Arrays.calc(0, 8, 9);
        Console.printFactorialExpr(new int[]{0, 8, 9}, factorials);

        factorials = Arrays.calc(-3, 1, 7, 13);
        Console.printFactorialExpr(new int[]{-3, 1, 7, 13}, factorials);

        factorials = Arrays.calc(-22, -0);
        Console.printFactorialExpr(new int[]{-22, -0}, factorials);
    }

    private static void exceedingNumsRemove() {
        float[] numbers = new float[15];
        for (int i = 0; i < 15; i++) {
            numbers[i] = (float) Math.random();
        }

        float[] modified = Arrays.modifiedIndexes(numbers, -1);
        Console.printModifiedNums(numbers, modified, -1);

        modified = Arrays.modifiedIndexes(numbers, 15);
        Console.printModifiedNums(numbers, modified, 15);

        modified = Arrays.modifiedIndexes(numbers, 0);
        Console.printModifiedNums(numbers, modified, 0);

        modified = Arrays.modifiedIndexes(numbers, 14);
        Console.printModifiedNums(numbers, modified, 14);
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
        int[] uniqueNumbers = Arrays.createUniqueNumsArray(-30, -10, 23);
        Console.printNumbers(uniqueNumbers, -30, -10, 23);

        uniqueNumbers = Arrays.createUniqueNumsArray(10, 50, 10);
        Console.printNumbers(uniqueNumbers, 10, 50, 10);

        uniqueNumbers = Arrays.createUniqueNumsArray(-34, -34, 0);
        Console.printNumbers(uniqueNumbers, -34, -34, 0);

        uniqueNumbers = Arrays.createUniqueNumsArray(-1, 2, -3);
        Console.printNumbers(uniqueNumbers, -1, 2, -3);

        uniqueNumbers = Arrays.createUniqueNumsArray(5, -8, 2);
        Console.printNumbers(uniqueNumbers, 5, -8, 2);
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
