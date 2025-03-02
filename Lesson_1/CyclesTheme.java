
public class CyclesTheme {
    public static void main(String[] args) {
        // Task 1
        System.out.println("1. Подсчет суммы четных и нечетных чисел");
        int start = -10;
        int stop = 21;
        int evenNumberSum = 0;
        int oddNumberSum = 0;
        int cycleStart = start;

        do {
            if (cycleStart % 2 == 0) {
                evenNumberSum += 1;
            } else {
                oddNumberSum += 1;
            }
            cycleStart++;
        } while (cycleStart <= stop);
        System.out.printf("В отрезке [%d, %d] сумма четных чисел = %d, а нечетных = %d%n", start,
                stop, evenNumberSum, oddNumberSum);

        // Task 2
        System.out.println("\n2. Вывод чисел между min и max в порядке убывания");
        int num1 = 10;
        int num2 = 5;
        int num3 = -1;
        int maxNumber = 0;
        int minNumber = 0;

        if (num1 > num2 && num1 > num3 && num2 > num3) {
            maxNumber = num1;
            minNumber = num3;
        } else if (num1 > num2 && num1 > num3 && num2 < num3) {
            maxNumber = num1;
            minNumber = num2;
        } else if (num2 > num1 && num2 > num3 && num1 > num3) {
            maxNumber = num2;
            minNumber = num3;
        } else if (num2 > num1 && num2 > num3 && num1 < num3) {
            maxNumber = num2;
            minNumber = num1;
        } else if (num3 > num1 && num3 > num2 && num1 > num2) {
            maxNumber = num3;
            minNumber = num2;
        } else if (num3 > num1 && num3 > num2 && num1 < num2) {
            maxNumber = num3;
            minNumber = num1;
        }

        for (--maxNumber; maxNumber > minNumber; maxNumber--) {
            System.out.print(maxNumber + " ");
        }

        // Task 3
        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");
        int number = 1234;
        int result = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            result += lastDigit;
            System.out.print(lastDigit + " ");
            number /= 10;
        }
        System.out.println("\nСумма цифр: " + result);

        // Task 4
        // Надеюсь я правильно понял условие задачи.
        System.out.println("\n4. Вывод чисел в несколько строк");
        int counter = 0;
        for (int i = 1; i < 24; i++) {
            if (counter < 5) {
                if (i % 2 != 0) {
                    System.out.printf("%7d", i);
                    counter++;
                }
            } else {
                System.out.println();
                counter = 0;
            }
        }
        while (counter != 0 && counter < 5) {
            System.out.printf("%7d", 0);
            counter++;
        }

        // Task 5
        System.out.println("\n\n5. Проверка количества двоек числа на четность/нечетность");
        int verifiableNumber = 3242592;
        int twosCounter = 0;
        int verifiableNumberCopy = verifiableNumber;
        while (verifiableNumberCopy > 0) {
            int lastDigit = verifiableNumberCopy % 10;
            if (lastDigit == 2) {
                twosCounter++;
            }
            verifiableNumberCopy /= 10;
        }
        if (twosCounter % 2 == 0) {
            System.out.printf("В %d четное (%d) количество двоек%n",
                    verifiableNumber, twosCounter);
        } else {
            System.out.printf("В %d нечетное (%d) количество двоек%n",
                    verifiableNumber, twosCounter);
        }

        // Task 6
        // Прямоугольник
        System.out.println("\n6. Вывод геометрических фигур");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // Прямоугольный треугольник
        int outerCycle = 0;
        while (outerCycle < 5) {
            int innerCycle = 5 - outerCycle;
            while (innerCycle > 0) {
                System.out.print("#");
                innerCycle--;
            }
            System.out.println();
            outerCycle++;
        }
        System.out.println();

        // Равнобедренный треугольник
        int triangleFirstPart = 1;
        int triangleSecondPart = 3;

        do {
            for (int i = 0; i < triangleFirstPart; i++) {
                System.out.print("$");
            }
            System.out.println();
            triangleFirstPart++;
        } while (triangleFirstPart <= 2);
        
        do {
            for (int i = 0; i < triangleSecondPart; i++) {
                System.out.print("$");
            }
            System.out.println();
            triangleSecondPart--;
        } while (triangleSecondPart > 0);

        // Task 7
        System.out.println("\n7. Вывод ASCII-символов");
        String decimal = "DECIMAL";
        String character = "CHARACTER";
        String description = "DESCRIPTION";
        System.out.printf("%s %13s %15s%n", decimal, character, description);
        for (int i = 33; i < 48; i++) {
            if (i % 2 != 0) {
                System.out.printf("  %-13s %-14c %-14s%n", i, (char) i, Character.getName(i));
            }
        }

        // Task 8
        System.out.println("\n8. Проверка, является ли число палиндромом");
        int currentNumber = 1234321;
        int currentNumberCopy = currentNumber;
        String reverseNumber = "";
        while (currentNumberCopy > 0) {
            reverseNumber += currentNumberCopy % 10;
            currentNumberCopy /= 10;
        }

        if (currentNumber == Integer.parseInt(reverseNumber)) {
            System.out.printf("Число %d - палиндром%n", currentNumber);
        } else {
            System.out.printf("Число %d - не палиндром%n", currentNumber);
        }

        // Task 9
        System.out.println("\n9. Проверка, является ли число счастливым");
        int randomNumber = 123321;
        int firstPart = 0;
        int secondPart = 0;
        int cnt = 0;
        String str1 = "";
        String str2 = "";
        while (randomNumber > 0) {
            int lastDigit = randomNumber % 10;
            if (cnt < 3) {
                secondPart += lastDigit;
                str2 = lastDigit + str2;
            } else {
                firstPart += lastDigit;
                str1 = lastDigit + str1;
            }
            cnt++;
            randomNumber /= 10;
        }

        if (firstPart == secondPart) {
            System.out.println("Число " + str1 + str2 + " - счастливое");
        } else {
            System.out.println("Число " + str1 + str2 + " - несчастливое");
        }
        
        System.out.printf("Сумма цифр: %s = %d%n", str1, firstPart);
        System.out.printf("Сумма цифр: %s = %d%n", str2, secondPart);

        // Task 10
        System.out.println("\n10. Вывод таблицы умножения Пифагора");
        System.out.println("    ТАБЛИЦА     ПИФАГОРА");
        System.out.print("  |");
        for (int i = 2; i < 10; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println("\n--+--------------------------------");

        for (int i = 2; i < 10; i++) {
            System.out.print(i + " |");
            for (int j = 2; j < 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}