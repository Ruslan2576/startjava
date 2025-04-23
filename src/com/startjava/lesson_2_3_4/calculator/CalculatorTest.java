package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String choice = "yes";

        while (!choice.equals("no")) {
            if (!choice.equals("yes")) {
                System.out.print("Введите корректный ответ [yes / no]: ");
                choice = scan.nextLine().toLowerCase();
                if (!choice.equals("yes")) {
                    continue;
                }
            }

            String expression = inputExpr(scan);
            Double result = Calculator.calculate(expression);

            // Вывести результат
            printResult(expression, result);

            // Продолжаем, или как?
            System.out.print("Хотите продолжить игру [yes / no]: ");
            choice = scan.nextLine().toLowerCase();
        }
    }

    private static String inputExpr(Scanner scan) {
        System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
        return scan.nextLine().replaceAll("\\s+", " ").trim();
    }

    private static void printResult(String expression, Double result) {
        if (result != null) {
            DecimalFormat df = new DecimalFormat("#.###");
            System.out.println(expression + " = " + df.format(result));
        }
    }
}