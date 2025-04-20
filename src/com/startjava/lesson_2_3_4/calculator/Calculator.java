package com.startjava.lesson_2_3_4.calculator;

import java.lang.Math;

public class Calculator {
    private int num1;
    private int num2;

    public double calculate(String expression) {
        String[] exprArray = expression.split(" ");
        num1 = Integer.parseInt(exprArray[0]);
        num2 = Integer.parseInt(exprArray[2]);
        String sign = exprArray[1];

        switch (sign) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (checkZero()) {
                    return (double) num1 / num2;
                }
                return Double.MAX_VALUE;
            case "%":
                if (checkZero()) {
                    return Math.floorMod(num1, num2);
                }
                return Double.MAX_VALUE;
            case "^":
                return Math.pow(num1, num2);
            default:
                System.out.printf("Ошибка: операция '%s' не поддерживается%n", sign);
                System.out.println("Доступные операции [+, -, *, /, %, ^]");
                return Double.MAX_VALUE;
        }
    }

    private boolean checkZero() {
        if (num1 == 0 && num2 == 0) {
            System.out.println("Ошибка: результат выражения: " + Double.NaN);
            return false;
        }

        if (num1 != 0 && num2 == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return false;
        }

        return true;
    }
}