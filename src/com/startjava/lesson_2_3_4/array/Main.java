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
        int[] numbers = {};
        int[] reversed = Arrays.reverse(numbers);
        Console.printReverseArray(new int[]{}, reversed);

        numbers = null;
        reversed = Arrays.reverse(numbers);
        Console.printReverseArray(numbers, reversed);

        numbers = new int[]{6, 8, 9, 1};
        reversed = Arrays.reverse(numbers);
        Console.printReverseArray(numbers, reversed);

        numbers = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversed = Arrays.reverse(numbers);
        Console.printReverseArray(numbers, reversed);
    }

    private static void factorial() {
        int[] numbers = {};
        int[] factorials = Arrays.calc(numbers);
        Console.printFactorialExpr(numbers, factorials);

        numbers = null;
        factorials = Arrays.calc(numbers);
        Console.printFactorialExpr(numbers, factorials);

        numbers = new int[]{0, 8, 9};
        factorials = Arrays.calc(numbers);
        Console.printFactorialExpr(numbers, factorials);

        numbers = new int[]{-3, 1, 7, 13};
        factorials = Arrays.calc(numbers);
        Console.printFactorialExpr(numbers, factorials);

        numbers = new int[]{-22, -0};
        factorials = Arrays.calc(numbers);
        Console.printFactorialExpr(numbers, factorials);
    }

    private static void exceedingNumsRemove() {
        float[] numbers = new float[15];
        for (int i = 0; i < 15; i++) {
            numbers[i] = (float) Math.random();
        }

        float[] modified = Arrays.exceedingNums(numbers, -1);
        Console.printModifiedNums(numbers, modified, -1);

        modified = Arrays.exceedingNums(numbers, 15);
        Console.printModifiedNums(numbers, modified, 15);

        modified = Arrays.exceedingNums(numbers, 0);
        Console.printModifiedNums(numbers, modified, 0);

        modified = Arrays.exceedingNums(numbers, 14);
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
