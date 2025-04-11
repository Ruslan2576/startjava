package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class Arrays {
    private Arrays() {
    }

    public static int[] calcFactorials(int... numbers) {
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

    public static int[] createUniqueNumsArray(int start, int stop, int count) {
        int len = (int) (Math.abs(start - stop) * .75);

        if (len < 0) {
            System.out.printf("Ошибка: длина массива должна быть > 0 (%d)%n", len);
            return null;
        }

        if (count < 1) {
            System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)%n", count);
            return null;
        }

        if (start >= stop) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n", start, stop);
            return null;
        }

        int[] numbers = new int[len];
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            boolean isEquals = false;
            int randomNumber = rand.nextInt(start, stop + 1);
            for (int j = 0; j < i; j++) {
                if (numbers[j] == randomNumber) {
                    isEquals = true;
                    i--;
                    break;
                }
            }
            if (!isEquals) {
                numbers[i] = randomNumber;
            }
        }
        return numbers;
    }

    public static float[] resetExceedingNums(float[] numbers, int index) {
        if (index < 0 || index >= numbers.length) {
            System.out.printf("Ошибка: индекс %d находится за границами массива от %d до %d.%n",
                    index, 0, numbers.length - 1);
            return null;
        }

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

    public static int[] reverse(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        int[] reversed = new int[numbers.length];
        int counter = numbers.length - 1;
        for (int number : numbers) {
            reversed[counter--] = number;
        }
        return reversed;
    }

    public static char[] sortSymbols(char start, char stop, boolean direction) {
        if (start > stop) {
            System.out.printf("Ошибка: левая граница (%c) > правой (%c)%n", start, stop);
            return null;
        }

        int len = stop - start + 1;
        char[] symbols = new char[len];
        for (int i = 0; i < len; i++) {
            symbols[i] = direction ? start++ : stop--;
        }
        return symbols;
    }

    public static String toUpperCaseRange(String inputText) {
        if (inputText == null || inputText.isBlank()) {
            return null;
        }

        String[] noPunctuation = inputText.replaceAll("\\s *\\p{P}", "").split(" ");

        int maxLenWord = 0;
        int minLenWord = 0;
        for (int i = 0; i < noPunctuation.length; i++) {
            if (noPunctuation[i].length() > noPunctuation[maxLenWord].length()) {
                maxLenWord = i;
            }

            if (noPunctuation[i].length() < noPunctuation[minLenWord].length()) {
                minLenWord = i;
            }
        }

        if (minLenWord > maxLenWord) {
            int tmp = maxLenWord;
            maxLenWord = minLenWord + 1;
            minLenWord = tmp;
        }

        String[] changedArray = inputText.split(" ");
        for (int i = minLenWord; i <= maxLenWord; i++) {
            changedArray[i] = changedArray[i].toUpperCase();
        }

        StringBuilder sb = new StringBuilder();
        for (String word : changedArray) {
            sb.append(word).append(" ");
        }
        return sb.toString();
    }
}
