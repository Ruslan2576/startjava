package com.startjava.lesson_1.final_;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int num1 = console.nextInt();
        System.out.print("\nВведите второе число: ");
        int num2 = console.nextInt();
        System.out.print("\nВведите арифметическую операцию(+, -, *, /, %, ^): ");
        String operator = console.next();

        int result = 0;
        if (operator.equals("+")) {
            result = num1 + num2;
        } else if (operator.equals("-")) {
            result = num1 - num2;
        } else if (operator.equals("*")) {
            result = num1 * num2;
        } else if (operator.equals("/")) {
            result = num1 / num2;
        } else if (operator.equals("%")) {
            result = num1 % num2;
        } else if (operator.equals("^")) {
            result = 1;
            for (int i = 0; i < num2; i++) {
                result *= num1;
            }
        }
        System.out.printf("%d %s %d = %d", num1, operator, num2, result);
    }
}