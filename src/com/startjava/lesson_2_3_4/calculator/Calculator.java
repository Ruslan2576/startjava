package com.startjava.lesson_2_3_4.calculator;

import java.lang.Math;
import java.text.DecimalFormat;
import javax.naming.OperationNotSupportedException;

public class Calculator {
    public static void calculate(String expression) {
        String[] elements = expression.split(" ");
        double result;
        String sign = null;

        try {
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
                default -> throw new OperationNotSupportedException();
            };
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Ошибка: неправильный ввод выражения");
            return;
        } catch (ArithmeticException ex) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return;
        } catch (NumberFormatException ex) {
            System.out.println("Ошибка: вы использовали не целые числа");
            return;
        } catch (OperationNotSupportedException ex) {
            System.out.printf("Ошибка: операция '%s' не поддерживается%n", sign);
            System.out.println("Доступные операции [+, -, *, /, %, ^]");
            return;
        }

        printResult(expression, result);
    }

    private static void printResult(String expression, double result) {
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println(expression + " = " + df.format(result));
    }
}