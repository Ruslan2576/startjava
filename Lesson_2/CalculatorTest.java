import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scan = new Scanner(System.in);
        String choice = "";

        // Основной цикл
        while (!choice.equals("no")) {
            // Получаем первое число
            System.out.print("\nВведите первое число: ");
            int num1 = scan.nextInt();

            // Получаем и проверяем знак операции
            scan.nextLine();
            char sign = 0;
            do {
                System.out.print("\nВведите знак операции (+, -, *, /, ^, %): ");
                calculator.setSign(scan.nextLine().charAt(0));
            } while ((sign = calculator.getSign()) == 0);

            // Получаем второе число
            int num2 = 0;
            do {
                System.out.print("\nВведите второе число: ");
                num2 = scan.nextInt();
            } while (!checkZero(num2, sign));

            // Вычисляем выражение и выводим результат
            int result = calculator.calculate(num1, num2);
            printResult(num1, num2, sign, result);

            // Продолжаем, или как ?
            scan.nextLine();
            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                choice = scan.nextLine();
            } while (!choice.equals("yes") && !choice.equals("no"));
        }
    }

    public static boolean checkZero(int checkedNum, char sign) {
        if (checkedNum == 0 && sign == '/') {
            System.out.println("Ошибка: деление на ноль запрещено");
            return false;
        }
        return true;
    }

    public static void printResult(int num1, int num2, char sign, int result) {
        if (num2 < 0) {
            System.out.printf("%d %s %d = %.2f%n", num1, sign, num2, (double) 1 / result);
        } else {
            System.out.printf("%d %s %d = %d%n", num1, sign, num2, result);
        }
    }
}