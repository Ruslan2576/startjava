package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String choice = "";
        
        // Основной цикл
        while (!choice.equals("no")) {
            Calculator calculator;
            double result;
            do {
                // Получаем выражение
                System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
                String[] expression = scan.nextLine().split(" ");
                calculator = new Calculator(expression);

                // Вычисляем выражение
                result = calculator.shareArrayOnPart(expression);
            } while (result == Double.MAX_VALUE);

            // Вывести результат
            printResult(calculator.getNum1(), calculator.getNum2(), calculator.getSign(), result);

            // Продолжаем, или как?
            System.out.print("Хотите продлжить игру [yes / no]: ");
            choice = scan.nextLine().toLowerCase();
            if (!choice.equals("yes") && !choice.equals("no")) {
                choice = getChoice(choice, scan);
            }
        }
    }

    public static void printResult(int num1, int num2, String sign, double result) {
        String template = result % 1 == 0 ? "%d %s %d = %.0f%n" : "%d %s %d = %.3f%n";
        System.out.printf(template, num1, sign, num2, result);
    }

    private static String getChoice(String choice, Scanner scan) {
        while (!choice.equals("yes") && !choice.equals("no")) {
            System.out.print("Введите корректный ответ [yes / no]: ");
            choice = scan.nextLine();
        }
        return choice;
    }
}