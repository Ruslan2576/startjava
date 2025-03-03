
public class CyclesTheme {
    public static void main(String[] args) {
        // Task 1
        System.out.println("1. Подсчет суммы четных и нечетных чисел");
        int start = -10;
        int stop = 21;
        int evenNumberSum = 0;
        int oddNumberSum = 0;
        int counter = start;

        do {
            if (counter % 2 == 0) {
                evenNumberSum += counter;
            } else {
                oddNumberSum += counter;
            }
            counter++;
        } while (counter <= stop);
        System.out.printf("В отрезке [%d, %d] сумма четных чисел = %d, а нечетных = %d%n",
                start,stop, evenNumberSum, oddNumberSum);

        // Task 2
        System.out.println("\n2. Вывод чисел между min и max в порядке убывания");
        int number1 = 10;
        int number2 = 5;
        int number3 = -1;
        int max = number1;
        int min = number1;

        // поиск минимального числа
        if (number2 < min) {
            min = number2;
        }
        if (number3 < min) {
            min = number3;
        }

        // поиск максимального числа
        if (number2 > max) {
            max = number2;
        }
        if (number3 > max) {
            max = number2;
        }

        for (--max; max > min; max--) {
            System.out.print(max);
        }

        // Task 3
        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");
        int number = 1234;
        int numberSum = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            numberSum += lastDigit;
            System.out.print(lastDigit + "");
            number /= 10;
        }
        System.out.println("\nСумма цифр: " + numberSum);

        // Task 4
        System.out.println("\n4. Вывод чисел в несколько строк");
        counter = 0;
        for (int i = 1; i < 24; i++) {
            if (i % 2 != 0) {
                System.out.printf("%3d", i);
                counter++;
            } else if (counter == 5) {
                System.out.println();
                counter = 0;
            }
        }
        while (counter != 0 && counter < 5) {
            System.out.printf("%3d", 0);
            counter++;
        }

        // Task 5
        System.out.println("\n\n5. Проверка количества двоек числа на четность/нечетность");
        int initialNumber = 3242592;
        int twosCounter = 0;
        int initialNumberCopy = initialNumber;
        while (initialNumberCopy > 0) {
            if (initialNumberCopy % 10 == 2) {
                twosCounter++;
            }
            initialNumberCopy /= 10;
        }
        if (twosCounter % 2 == 0) {
            System.out.printf("В %d четное (%d) количество двоек%n",
                    initialNumber, twosCounter);
        } else {
            System.out.printf("В %d нечетное (%d) количество двоек%n",
                    initialNumber, twosCounter);
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
        int outerLoop = 0;
        int innerLoop = 0;
        while (outerLoop < 5) {
            innerLoop = 5 - outerLoop;
            while (innerLoop > 0) {
                System.out.print("#");
                innerLoop--;
            }
            System.out.println();
            outerLoop++;
        }
        System.out.println();

        // Равнобедренный треугольник
        outerLoop = 1;
        counter = 1;
        int secondCounter = 2;

        do {
            innerLoop = 0;
            do {
                System.out.print("#");
                innerLoop++;
            } while (innerLoop < counter);
            counter++;

            if (outerLoop > 2) {
                counter -= secondCounter;
                secondCounter++;
            } 

            System.out.println();
            outerLoop++;
        } while (outerLoop <= 5);

        // Task 7
        System.out.println("\n7. Вывод ASCII-символов");
        String decimal = "DECIMAL";
        String character = "CHARACTER";
        String description = "DESCRIPTION";
        System.out.printf("%s %13s %15s%n", decimal, character, description);
    
        for (int i = 33; i < 123; i++) {
            if (i % 2 != 0 && i < 48) {
                System.out.printf("  %-13s %-14c %-14s%n", i, (char) i, Character.getName(i));
            } else if (i % 2 == 0 && i > 97) {
                System.out.printf("  %-13s %-14c %-14s%n", i, (char) i, Character.getName(i));
            }
        }

        // Task 8
        System.out.println("\n8. Проверка, является ли число палиндромом");
        int baseNumber = 1234321;
        int baseNumberCopy = baseNumber;
        String reverseNumber = "";
        while (baseNumberCopy > 0) {
            reverseNumber += baseNumberCopy % 10;
            baseNumberCopy /= 10;
        }

        if (baseNumber == Integer.parseInt(reverseNumber)) {
            System.out.printf("Число %d - палиндром%n", baseNumber);
        } else {
            System.out.printf("Число %d - не палиндром%n", baseNumber);
        }

        // Task 9
        System.out.println("\n9. Проверка, является ли число счастливым");
        baseNumber = 123321;
        int firstPartNumberSum = 0;
        int secondPartNumberSum = 0;
        counter = 0;
        String leftPartNumber = "";
        String rightPartNumber = "";
        while (baseNumber > 0) {
            int lastDigit = baseNumber % 10;
            if (counter < 3) {
                secondPartNumberSum += lastDigit;
                rightPartNumber = lastDigit + rightPartNumber;
            } else {
                firstPartNumberSum += lastDigit;
                leftPartNumber = lastDigit + leftPartNumber;
            }
            counter++;
            baseNumber /= 10;
        }

        if (firstPartNumberSum == secondPartNumberSum) {
            System.out.println("Число " + leftPartNumber + rightPartNumber + " - счастливое");
        } else {
            System.out.println("Число " + leftPartNumber + rightPartNumber + " - несчастливое");
        }
        
        System.out.printf("Сумма цифр: %s = %d%n", leftPartNumber, firstPartNumberSum);
        System.out.printf("Сумма цифр: %s = %d%n", rightPartNumber, secondPartNumberSum);

        // Task 10
        System.out.println("\n10. Вывод таблицы умножения Пифагора");
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