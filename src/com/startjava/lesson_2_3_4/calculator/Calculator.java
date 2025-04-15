package com.startjava.lesson_2_3_4.calculator;

import java.lang.Math;

public class Calculator {
    private final int num1;
    private final int num2;
    private String sign;

    public Calculator(String[] expression) {
        num1 = Integer.parseInt(expression[0]);
        num2 = Integer.parseInt(expression[2]);
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getSign() {
        return sign;
    }

    public boolean setSign(String sign) {
        switch (sign) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
            case "^":
                this.sign = sign;
                return true;
            default:
                System.out.printf("Ошибка: операция '%s' не поддерживается%n", sign);
                System.out.println("Доступные операции [+, -, *, /, %, ^]");
                return false;
        }
    }

    public double calculate(int num1, int num2) {
        double result = 0;
        if (sign.equals("+")) {
            result = num1 + num2;
        } else if (sign.equals("-")) {
            result = num1 - num2;
        } else if (sign.equals("*")) {
            result = num1 * num2;
        } else if (sign.equals("/")) {
            result = (double) num1 / num2;
        } else if (sign.equals("%")) {
            result = Math.floorMod(num1, num2);
        } else if (sign.equals("^")) {
            result = Math.pow(num1, num2);
        }
        return result;
    }

    public double shareArrayOnPart(String[] expression) {
        if (!setSign(expression[1])) {
            return Double.MAX_VALUE;
        }

        boolean answer = checkZero(num2, sign);
        double result = 0;
        if (answer) {
            result = calculate(num1, num2);
        }
        return result;
    }

    public boolean checkZero(int checkedNum, String sign) {
        if (checkedNum == 0 && sign.equals("/")) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return false;
        }
        return true;
    }
}