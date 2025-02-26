import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        // Task 1
        System.out.println("\n1. Вывод характеристик компьютера");
        byte coreCount = 12;
        short systemType = 64;
        int ramCapacity = 16;
        long hddCapacity = 2L;
        float cpuFrequency = 3.30F;
        double screenDiagonal = 15.6;
        char laptopModelSymbol = 'L';
        boolean keyboardBacklight = true;

        System.out.println("Количество ядер " + coreCount);
        System.out.println("Частота процессора + " + cpuFrequency);
        System.out.println("Оперативная память " + ramCapacity);
        System.out.println("Тип системы " + systemType + "-разрядная операционная систама, x" + systemType);
        System.out.println("Ёмкость жесткого диска " + hddCapacity + "TB");
        System.out.println("Диагональ экрана " + screenDiagonal);
        System.out.println("Подстветка клавиатуры " + keyboardBacklight);
        System.out.println("Модель ноутбука Machenike " + laptopModelSymbol + "16 Pro");

        // Task 2
        System.out.println("\n2. Расчет стоимости товара со скидкой");
        double penPrice = 105.5;
        double bookPrice = 235.83;
        double basePrice = penPrice + bookPrice;
        double discountSum = basePrice * .11;
        double discountPrice = basePrice - discountSum;

        System.out.format("Стоимость товаров без скидки: %.2f\n", basePrice);
        System.out.format("Сумму скидки: %.2f\n", discountSum);
        System.out.format("Стоимость товаров со скидкой: %.2f\n", discountPrice);

        // Task 3
        System.out.println("\n3. Вывод слова Java");
        System.out.println("    J   a  v     v  a");
        System.out.println("    J  a a  v   v  a a");
        System.out.println("J   J aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

        // Task 4
        System.out.println("\n4. Вывод min и max значений целых числовых типов");
        byte byteMaxValue = 127;
        short shortMaxValue = 32_767;
        int intMaxValue = 2_147_483_647;
        long longMaxValue = 9_223_372_036_854_775_807L;
        char charMaxValue = 65_535;

        System.out.println("первоначальное значение " + byteMaxValue);
        System.out.println("значение после инкремента на единицу " + ++byteMaxValue);
        System.out.println("значение после декремента на единицу " + --byteMaxValue);

        System.out.println("первоначальное значение " + shortMaxValue);
        System.out.println("значение после инкремента на единицу " + ++shortMaxValue);
        System.out.println("значение после декремента на единицу " + --shortMaxValue);

        System.out.println("первоначальное значение " + intMaxValue);
        System.out.println("значение после инкремента на единицу " + ++intMaxValue);
        System.out.println("значение после декремента на единицу " + --intMaxValue);

        System.out.println("первоначальное значение " + longMaxValue);
        System.out.println("значение после инкремента на единицу " + ++longMaxValue);
        System.out.println("значение после декремента на единицу " + --longMaxValue);

        System.out.println("первоначальное значение " + (int) charMaxValue);
        System.out.println("значение после инкремента на единицу " + (int) ++charMaxValue);
        System.out.println("значение после декремента на единицу " + (int) --charMaxValue);

        // Task 5
        System.out.println("\n5. Перестановка значений переменных");
        int x = 2;
        int y = 5;

        System.out.println("Перестановка с помощью третьей переменной");
        System.out.println("Исходные значения переменных: x - " + x + ", y - " + y);
        int tmp = x;
        x = y;
        y = tmp;
        System.out.println("Новые значения переменных: x - " + x + ", y - " + y);

        System.out.println("Перестановка с помощью арифметических операций");
        System.out.println("Исходные значения переменных: x - " + x + ", y - " + y);
        System.out.printf("Новые значения переменных: x - %d, y - %d%n", (x * y / x), (y * x / y));

        System.out.println("Перестановка с помощью побитовой операции");
        System.out.println("Исходные значения переменных: x - " + x + ", y - " + y);
        x ^= y;
        y ^= x;
        x ^= y;
        System.out.println("Новые значения переменных: x - " + x + ", y - " + y);

        // Task 6
        System.out.println("\n6. Вывод символов и их кодов");
        // 36, 42, 64, 94, 126
        char dollar = '$';
        char asterisk = '*';
        char atSign = '@';
        char caret = '^';
        char tilde = '~';
        System.out.println((int) dollar + " " + dollar);
        System.out.println((int) asterisk + " " + asterisk);
        System.out.println((int) atSign + " " + atSign);
        System.out.println((int) caret + " " + caret);
        System.out.println((int) tilde + " " + tilde);

        // Task 7
        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");
        char slash = '\\';
        char backslash = '/';
        char leftParenthesis = '(';
        char rightParenthesis = ')';
        char underscore = '_';
        System.out.println("    " + backslash + slash);
        System.out.println("   " + backslash + "  " + slash);
        System.out.println("  " + backslash + underscore + leftParenthesis + " " +
                rightParenthesis + slash);
        System.out.println(" " + backslash + "      " + slash);
        System.out.println("" + backslash + underscore + underscore + underscore + underscore +
                backslash + slash + underscore + underscore + slash);

        // Task 8
        System.out.println("\n8. Манипуляции с сотнями, десятками и единицами числа");
        int number = 123;
        int ones = number % 10;
        int tens = number / 10 % 10;
        int hundreds = number / 100;
        int sum = ones + tens + hundreds;
        int multiplication = ones * tens * hundreds;
        System.out.println("Число " + number + " содержит:");
        System.out.println("  сотен - " + hundreds);
        System.out.println("  десятков - " + tens);
        System.out.println("  единиц - " + ones);
        System.out.println("Сумма разрядов = " + sum);
        System.out.println("Произведение разрядов = " + multiplication);

        // Task 9
        System.out.println("\n9. Перевод секунд в часы, минуты и секунды");
        int time = 86399;
        System.out.println(time / 3600 + ":" + time / 60 % 60 + ":" + time % 60);

        // Task 10
        System.out.println("\n10. *Расчет стоимости товара со скидкой");
        BigDecimal newPenCost = new BigDecimal("105.5");
        BigDecimal newBookCost = new BigDecimal("235.83");
        BigDecimal newDiscountPercent = new BigDecimal(".11");
        BigDecimal newBasePrice = newPenCost.add(newBookCost);
        BigDecimal newDiscountSum = newBasePrice.multiply(newDiscountPercent)
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal newGoodsCostWithDiscount = newBasePrice.subtract(newDiscountSum)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.println("Стоимость товаров без скидки: " + newBasePrice);
        System.out.println("\nСумму скидки: " + newDiscountSum);
        System.out.println("\nСтоимость товаров со скидкой: " + newGoodsCostWithDiscount);
    }
}