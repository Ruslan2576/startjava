package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String choice = "";

        while (!choice.equals("no")) {
            if (!choice.equals("yes") && !choice.isEmpty()) {
                System.out.print("Введите корректный ответ [yes / no]: ");
                choice = scan.nextLine().toLowerCase();
                if (!choice.equals("yes")) {
                    continue;
                }
            }

            System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
            String expression = scan.nextLine().replaceAll("\\s+", " ").trim();
            Calculator.calculate(expression);

            // Продолжаем, или как?
            System.out.print("Хотите продолжить игру [yes / no]: ");
            choice = scan.nextLine().toLowerCase();
        }
    }
}