package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class Arrays {
    private Arrays() {
    }

    public static char[] sortSymbols(char start, char stop, boolean direction) {
        if (start > stop) {
            return null;
        }

        int len = stop - start + 1;
        char[] symbols = new char[len];
        for (int i = 0; i < len; i++) {
            symbols[i] = direction ? start++ : stop--;
        }
        return symbols;
    }

    public static float[] remove(float[] numbers, int index) {
        if (index < 0 || index >= numbers.length) {
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

    public static float[] createRandomArr() {
        float[] numbers = new float[15];
        for (int i = 0; i < 15; i++) {
            numbers[i] = (float) Math.random();
        }
        return numbers;
    }

    public static int[] calc(int... numbers) {
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

    public static int[] createRandomArray(int start, int stop, int count) {
        int len = (int) (Math.abs(start - stop) * .75);
        if (count < 1 || len < 0 || start >= stop) {
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
