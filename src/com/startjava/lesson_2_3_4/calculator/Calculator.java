package com.startjava.lesson_2_3_4.calculator;

import java.lang.Math;

public class Calculator {
    static final int ELEMENTS_LENGTH = 3;

    public static Double calculate(String expression) {
        String[] elements = expression.split(" ");
        double result;
        String sign = null;

        try {
            if (elements.length != ELEMENTS_LENGTH) {
                throw new ArrayIndexOutOfBoundsException();
            }

            sign = elements[1];
            int num1 = Integer.parseInt(elements[0]);
            int num2 = Integer.parseInt(elements[2]);

            result = switch (sign) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "*" -> num1 * num2;
                case "/" -> {
                    if (num2 == 0) {
                        throw new ArithmeticException();
                    }
                    yield (double) num1 / num2;
                }
                case "%" -> Math.floorMod(num1, num2);
                case "^" -> Math.pow(num1, num2);
                default -> throw new UnsupportedOperationException();
            };
        } catch (ArithmeticException ex) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return null;
        } catch (NumberFormatException ex) {
            System.out.println("Ошибка: вы использовали не целые числа");
            return null;
        } catch (UnsupportedOperationException ex) {
            System.out.printf("Ошибка: операция '%s' не поддерживается%n", sign);
            System.out.println("Доступные операции [+, -, *, /, %, ^]");
            return null;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Ошибка: введено неверное выражение");
            return null;
        }
        return result;
    }
}