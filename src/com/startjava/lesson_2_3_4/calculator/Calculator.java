package com.startjava.lesson_2_3_4.calculator;

import java.lang.Math;

public class Calculator {

    private char sign;

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        switch (sign) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
            case '^':
                this.sign = sign;
                break;
            default:
                System.out.printf("Ошибка: операция '%c' не поддерживается%n", sign);
        }
    }

    public int calculate(int num1, int num2) {
        int result = 0;
        if (sign == '+') {
            result = num1 + num2;
        } else if (sign == '-') {
            result = num1 - num2;
        } else if (sign == '*') {
            result = num1 * num2;
        } else if (sign == '/') {
            result = num1 / num2;
        } else if (sign == '%') {
            result = num1 % num2;
        } else if (sign == '^') {
            result = 1;
            num2 = Math.abs(num2);
            for (int i = 0; i < num2; i++) {
                result *= num1;
            }
        }
        return result;
    }
}