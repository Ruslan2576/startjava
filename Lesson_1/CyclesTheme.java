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
                start, stop, evenNumberSum, oddNumberSum);

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
            System.out.print(max + " ");
        }

        // Task 3
        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");
        int initialNumber = 1234;
        int numberSum = 0;

        while (initialNumber > 0) {
            int lastDigit = initialNumber % 10;
            numberSum += lastDigit;
            System.out.print(lastDigit);
            initialNumber /= 10;
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
        initialNumber = 3242592;
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
        int heightCounter = 0;
        int widthCounter = 0;
        while (heightCounter < 5) {
            widthCounter = 5 - heightCounter;
            while (widthCounter > 0) {
                System.out.print("#");
                widthCounter--;
            }
            System.out.println();
            heightCounter++;
        }
        System.out.println();

        // Равнобедренный треугольник
        int mainCounter = 1;
        heightCounter = 1;
        int subtractionCounter = 2;
        do {
            widthCounter = 0;
            do {
                System.out.print("#");
                widthCounter++;
            } while (widthCounter < mainCounter);
            mainCounter++;

            if (heightCounter > 2) {
                mainCounter -= subtractionCounter;
                subtractionCounter++;
            } 

            System.out.println();
            heightCounter++;
        } while (heightCounter <= 5);

        // Task 7
        System.out.println("\n7. Вывод ASCII-символов");
        System.out.printf("%s %13s %15s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");
    
        for (int i = 33; i < 123; i++) {
            if (i % 2 != 0 && i < 48) {
                System.out.printf("  %-13s %-14c %-14s%n", i, (char) i, Character.getName(i));
            } else if (i % 2 == 0 && i > 97) {
                System.out.printf("  %-13s %-14c %-14s%n", i, (char) i, Character.getName(i));
            }
        }

        // Task 8
        System.out.println("\n8. Проверка, является ли число палиндромом");
        initialNumber = 1234321;
        initialNumberCopy = initialNumber;
        int reverseNumber = 0;
        while (initialNumberCopy > 0) {
            int lastDigit = initialNumberCopy % 10;
            reverseNumber = reverseNumber * 10 + lastDigit;
            initialNumberCopy /= 10;
        }

        if (initialNumber == reverseNumber) {
            System.out.printf("Число %d - палиндром%n", initialNumber);
        } else {
            System.out.printf("Число %d - не палиндром%n", initialNumber);
        }

        // Task 9
        System.out.println("\n9. Проверка, является ли число счастливым");
        initialNumber = 123321;
        int leftPartNumberSum = 0;
        int rightPartNumberSum = 0;
        counter = 0;
        int leftPartNumber = initialNumber / 1000;
        int rightPartNumber = initialNumber % 1000;
        
        while (initialNumber > 0) {
            int lastDigit = initialNumber % 10;
            if (counter < 3) {
                rightPartNumberSum += lastDigit;
            } else {
                leftPartNumberSum += lastDigit;
            }
            counter++;
            initialNumber /= 10;
        }

        if (leftPartNumberSum == rightPartNumberSum) {
            System.out.println("Число " + leftPartNumber + rightPartNumber + " - счастливое");
        } else {
            System.out.println("Число " + leftPartNumber + leftPartNumber + " - несчастливое");
        }
        
        System.out.printf("Сумма цифр: %s = %d%n", leftPartNumber, leftPartNumberSum);
        System.out.printf("Сумма цифр: %s = %d%n", rightPartNumber, rightPartNumberSum);

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