import java.lang.Character;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        // Task 1
        System.out.println("1. Перевод псевдокода на язык Java");
        boolean isMaleGander = true;
        int age = 30;
        double height = 1.84;

        if (!isMaleGander) {
            System.out.println("Женщина");
        } else {
            System.out.println("Мужчина");
        }

        if (age > 18) {
            System.out.println("Совершеннолетний");
        } else {
            System.out.println("Несовершеннолетний");
        }
        
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
            System.out.println("Число: " + num1 + " больше числа: " + num2);
        } else if (num1 < num2) {
            System.out.println("Число: " + num2 + " больше числа: " + num1);
        } else {
            System.out.println("Число: " + num1 + " и число: " + num2 + " равны");
        }

        // Task 3
        System.out.println("\n3. Проверка числа");
        int number = -2;
        
        if (number != 0) {
            if (number > 0 && number % 2 == 0) {
                System.out.println(number + " является положительным и чётным");
            } else if (number < 0 && number % 2 == 0) {
                System.out.println(number + " является отрицательным и чётным");
            } else if (number > 0 && number % 2 != 0) {
                System.out.println(number + " является положительным и нечётным");
            } else {
                System.out.println(number + " является отрицательным и нечётным");
            }
        } else {
            System.out.println("Число " + number);
        }

        // Task 4
        System.out.println("\n4. Поиск одинаковых цифр в числах");
        int a = 123;
        int b = 223;

        int hundredsA = a / 100;
        int tensA = a / 10 % 10;
        int onesA = a % 10;

        int hundredsB = b / 100;
        int tensB = b / 10 % 10;
        int onesB = b % 10;

        if (hundredsA == hundredsB || tensA == tensB || onesA == onesB) {
            System.out.println("Исходные числа: " + a + " и " + b);
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
            System.out.println("Подходящих цифр нет.");
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
        double percent = 0;

        if (deposit < 100_000 && deposit > 0) {
            percent = .05;
        } else if (deposit >= 100_000 && deposit <= 300_000) {
            percent = .07;
        } else {
            percent = .10;
        }

        System.out.printf("Сумма вклада: %.2f\n", deposit);
        System.out.printf("Сумма начисленного процента: %.2f\n", deposit * percent);
        System.out.printf("Итоговая сумма с процентом: %.2f\n", ((double) deposit * percent + deposit));

        // Task 7
        System.out.println("\n7.Определение оценки по предметам");
        double history = 59;
        double programming = 92;
        int scoreHistory = 0;
        int scoreProgramming = 0;

        if (history <= 60) {
            System.out.println("История - 2");
            scoreHistory = 2;
        } else if (history <= 73) {
            System.out.println("История - 3");
            scoreHistory = 3;
        } else if (history <= 91) {
            System.out.println("История -4");
            scoreHistory = 4;
        } else if (history < 100) {
            System.out.println("История - 5");
            scoreHistory = 5;
        }

        if (programming <= 60) {
            System.out.println("Программирование - 2");
            scoreProgramming = 2;
        } else if (programming <= 73) {
            System.out.println("Программирование - 3");
            scoreProgramming = 3;
        } else if (programming <= 91) {
            System.out.println("Программирование -4");
            scoreProgramming = 4;
        } else if (programming < 100) {
            System.out.println("Программирование - 5");
            scoreProgramming = 5;
        }

        System.out.println("средний балл оценок по предметам: " + 
                ((double) (scoreHistory + scoreProgramming) / 2));
        System.out.println("средний % по предметам: " + 
                ((double) (history + programming) / 2));

        // Task 8
        System.out.println("\n8. Расчет годовой прибыли");
        double monthlyProfit = 13025.233;
        double premisesRent = 5123.018;
        double productionPrice = 9001.729;
        double yearProfit = monthlyProfit * 12 - (premisesRent + productionPrice) * 12;
        
        System.out.printf("Прибыль за год: %+.2f руб\n", yearProfit);

        // Task 9
        System.out.println("\n9. *Подсчет начисленных банком %");
        BigDecimal secondDeposit = new BigDecimal("321123.59");
        BigDecimal secondPercent = null;

        if (secondDeposit.doubleValue() < 100_000 && secondDeposit.doubleValue() > 0) {
            secondPercent = new BigDecimal(".05");
        } else if (secondDeposit.doubleValue() >= 100_000 &&
                secondDeposit.doubleValue() < 300_000) {
            secondPercent = new BigDecimal(".07");
        } else {
            secondPercent = new BigDecimal(".1");
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
        BigDecimal secondYearProfit = secondMonthlyProfit.multiply(new BigDecimal("12"))
                .subtract(secondPremisesRent.add(secondProductionPrice)
                .multiply(new BigDecimal("12"))).setScale(2, RoundingMode.HALF_UP);

        System.out.printf("Прибыль за год: %+.2f руб\n", secondYearProfit);
    }
}