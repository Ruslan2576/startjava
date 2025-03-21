package com.startjava.lesson_1.base;

import java.lang.Character;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        // Task 1
        System.out.println("1. Перевод псевдокода на язык Java");
        boolean isMaleGander = true;
        if (!isMaleGander) {
            System.out.println("Женщина");
        } else {
            System.out.println("Мужчина");
        }

        int age = 30;
        if (age > 18) {
            System.out.println("Совершеннолетний");
        } else {
            System.out.println("Несовершеннолетний");
        }

        double height = 1.84;
        if (height < 1.8) {
            System.out.println("Невысокий");
        } else {
            System.out.println("Выше среднего");
        }

        char firstLetterName = "Ruslan".charAt(0);
        if (firstLetterName == 'M') {
            System.out.println("Перевая буква имени М");
        } else if (firstLetterName == 'I') {
            System.out.println("Первая буква имени I");
        } else {
            System.out.println("Первая буква имени " + firstLetterName);
        }

        // Task 2
        System.out.println("\n2. Поиск большего числа");
        int num1 = 55;
        int num2 = 55;

        if (num1 > num2) {
            System.out.println(num1 + " больше " + num2);
        } else if (num1 < num2) {
            System.out.println(num2 + " больше числа " + num1);
        } else {
            System.out.println("два числа равны " + num1);
        }

        // Task 3
        System.out.println("\n3. Проверка числа");
        int number = -1;
        
        if (number != 0) {
            if (number > 0) {
                System.out.print(number + " является положительным и ");
            } else {
                System.out.print(number + " является отрицательным и ");
            }

            if (number % 2 == 0) {
                System.out.println("чётным");
            } else {
                System.out.println("нечётным");
            }
        } else {
            System.out.println("Число " + number);
        }

        // Task 4
        System.out.println("\n4. Поиск одинаковых цифр в числах");
        num1 = 123;
        num2 = 223;

        int hundredsA = num1 / 100;
        int tensA = num1 / 10 % 10;
        int onesA = num1 % 10;

        int hundredsB = num2 / 100;
        int tensB = num2 / 10 % 10;
        int onesB = num2 % 10;

        if (hundredsA == hundredsB || tensA == tensB || onesA == onesB) {
            System.out.println("Исходные числа: " + num1 + " и " + num2);
            if (hundredsA == hundredsB) {
                System.out.println("Одинаковые сотни в первом числе " + 
                        hundredsA + " и во втором числе " + hundredsB);
            }
            if (tensA == tensB) {
                System.out.println("Одинаковые десятки в первом " + tensA +
                        " и во втором числе " + tensB);
            }
            if (onesA == onesB) {
                System.out.println("Одинаковые единицы в первом " + onesA + 
                        " и во втором числе " + onesB);
            }
        } else {
            System.out.println("В числах нет равных разрядов.");
        }

        // Task 5
        System.out.println("\n5. Определение символа по его коду");
        char symbol = '\u0057';

        if (Character.isUpperCase(symbol)) {
            System.out.println(symbol + " - большая буква");
        } else if (Character.isLowerCase(symbol)) {
            System.out.println(symbol + " - маленькая буква");
        } else if (Character.isDigit(symbol)) {
            System.out.println(symbol + " - цифра");
        } else {
            System.out.println(symbol + " ни буква и ни цифра");
        }

        // Task 6
        System.out.println("\n6. Подсчет начисленных банком %");
        double deposit = 321123.59;
        double percent = .10;

        if (deposit > 0 && deposit < 100_000) {
            percent = .05;
        } else if (deposit >= 100_000 && deposit <= 300_000) {
            percent = .07;
        }

        System.out.printf("Сумма вклада: %.2f\n", deposit);
        System.out.printf("Сумма начисленного процента: %.2f\n", deposit * percent);
        System.out.printf("Итоговая сумма с процентом: %.2f\n", ((double) deposit * percent + deposit));

        // Task 7
        System.out.println("\n7.Определение оценки по предметам");
        double historyPercent = 59;
        int historyScore = 5;
        if (historyPercent <= 60) {
            historyScore = 2;
        } else if (historyPercent <= 73) {
            historyScore = 3;
        } else if (historyPercent <= 91) {
            historyScore = 4;
        }

        double programmingPercent = 92;
        int programmingScore = 5;
        if (programmingPercent <= 60) {
            programmingScore = 2;
        } else if (programmingPercent <= 73) {
            programmingScore = 3;
        } else if (programmingPercent <= 91) {
            programmingScore = 4;
        }

        System.out.println("история - " + historyScore);
        System.out.println("программирование - " + programmingScore);
        System.out.println("средний балл оценок по предметам: " + 
                ((double) (historyScore + programmingScore) / 2));
        System.out.println("средний % по предметам: " + 
                ((double) (historyPercent + programmingPercent) / 2));

        // Task 8
        System.out.println("\n8. Расчет годовой прибыли");
        double monthlyProfit = 13025.233;
        double premisesRent = 5123.018;
        double productionPrice = 9001.729;
        double yearProfit = 12 * (monthlyProfit - (premisesRent + productionPrice));
    
        System.out.printf("Прибыль за год: %+.2f руб\n", yearProfit);

        // Task 9
        System.out.println("\n9. *Подсчет начисленных банком %");
        BigDecimal secondDeposit = new BigDecimal("321123.59");
        BigDecimal secondPercent = new BigDecimal(".10");

        if (secondDeposit.doubleValue() > 0 && secondDeposit.doubleValue() < 100_000) {
            secondPercent = new BigDecimal(".05");
        } else if (secondDeposit.doubleValue() >= 100_000 &&
                secondDeposit.doubleValue() < 300_000) {
            secondPercent = new BigDecimal(".07");
        }

        System.out.printf("Сумма вклада: %.2f\n", secondDeposit);
        System.out.printf("Сумма начисленного процента: %.2f\n", 
                secondDeposit.multiply(secondPercent).setScale(2, RoundingMode.HALF_UP));
        System.out.printf("Итоговая сумма с процентом: %.2f\n", 
                secondDeposit.multiply(secondPercent).add(secondDeposit)
                .setScale(2, RoundingMode.HALF_UP));

        // Task 10
        System.out.println("\n10. *Расчет годовой прибыли");
        var secondMonthlyProfit = new BigDecimal("13025.233");
        var secondPremisesRent = new BigDecimal("5123.018");
        var secondProductionPrice = new BigDecimal("9001.729");
        BigDecimal secondYearProfit = BigDecimal.valueOf(12).multiply(secondMonthlyProfit
                .subtract(secondPremisesRent.add(secondProductionPrice)))
                .setScale(2, RoundingMode.HALF_UP);

        System.out.printf("Прибыль за год: %+.2f руб\n", secondYearProfit);
    }
}