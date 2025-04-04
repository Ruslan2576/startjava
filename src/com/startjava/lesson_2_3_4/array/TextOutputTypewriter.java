package com.startjava.lesson_2_3_4.array;

public class TextOutputTypewriter {
    public static void main(String[] args) throws InterruptedException {
        String str1 = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";

        String str2 = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        type(toUpperCaseRange(str1));
        type(toUpperCaseRange(str2));
        type(toUpperCaseRange(null));
        type(toUpperCaseRange(""));
    }

    private static String toUpperCaseRange(String inputText) {
        if (inputText == null) {
            System.out.println("Ошибка: строка равна null.");
            return null;
        }

        if (inputText.isBlank()) {
            System.out.println("Ошибка: строка пустая");
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

    private static void type(String text) throws InterruptedException {
        if (text == null || text.isBlank()) {
            return;
        }

        for (String s : text.split("")) {
            System.out.print(s);
            Thread.sleep(100);
        }
        System.out.println("\n");
    }
}
