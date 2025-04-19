package com.startjava.lesson_2_3_4.calculator;

import java.lang.Math;

public class Calculator {
    private int num1;
    private int num2;
    private String sign;

    public double calculate(String[] expression) {
        num1 = Integer.parseInt(expression[0]);
        num2 = Integer.parseInt(expression[2]);
        sign = expression[1];

        double result;
        switch (sign) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (!checkZero()) {
                    return Double.MAX_VALUE;
                }
                result = (double) num1 / num2;
                break;
            case "%":
                result = Math.floorMod(num1, num2);
                break;
            case "^":
                result = Math.pow(num1, num2);
                break;
            default:
                System.out.printf("Ошибка: операция '%s' не поддерживается%n", sign);
                System.out.println("Доступные операции [+, -, *, /, %, ^]");
                return Double.MAX_VALUE;
        }
        return result;
    }

    private boolean checkZero() {
        double result = (double) num1 / num2;
        if (Double.isNaN(result)) {
            System.out.println("Ошибка: результат выражения: " + result);
            return false;
        }

        if (num2 == 0 && sign.equals("/")) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return false;
        }

        return true;
    }
}