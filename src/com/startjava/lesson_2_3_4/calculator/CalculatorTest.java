package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
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

            Calculator calculator = new Calculator();
            System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
            String expression = scan.nextLine();
            double result = calculator.calculate(expression);

            // Вывести результат
            printResult(expression, result);

            // Продолжаем, или как?
            System.out.print("Хотите продолжить игру [yes / no]: ");
            choice = scan.nextLine().toLowerCase();
        }
    }

    public static void printResult(String expression, double result) {
        if (result != Double.MAX_VALUE) {
            DecimalFormat df = new DecimalFormat("#.###");
            System.out.print(expression + " = ");
            System.out.println(df.format(result));
        }
    }
}