package com.startjava.lesson_2_3_4.array;

public class TextOutputTypewriter {
    public static void main(String[] args) throws InterruptedException {
        String str1 = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";

        String str2 = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        printArray(changeString(str1));
        printArray(changeString(str2));
        printArray(changeString(null));
        printArray(changeString(""));
    }

    private static String changeString(String someText) {
        if (someText == null || someText.isBlank()) {
            System.out.println("Ошибка: строка неккоректна.");
            return null;
        }

        String[] arrayWithoutPunctuationMarks = someText.replaceAll("[!?.,]", "")
                .replaceAll(" -", "").split(" ");

        int min = 0;
        int max = 0;
        for (int i = 0; i < arrayWithoutPunctuationMarks.length; i++) {
            if (arrayWithoutPunctuationMarks[i].length() > arrayWithoutPunctuationMarks[max].length()) {
                max = i;
            }

            if (arrayWithoutPunctuationMarks[i].length() < arrayWithoutPunctuationMarks[min].length()) {
                min = i;
            }
        }

        String[] changedArray = someText.split(" ");
        if (min > max) {
            for (int i = min + 1; i > max; i--) {
                changedArray[i] = changedArray[i].toUpperCase();
            }
        }

        for (int i = min; i <= max; i++) {
            changedArray[i] = changedArray[i].toUpperCase();
        }

        StringBuilder sb = new StringBuilder();
        for (String word : changedArray) {
            sb.append(word).append(" ");
        }
        return sb.toString();
    }

    private static void printArray(String text) throws InterruptedException {
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
