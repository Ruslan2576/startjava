import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();
        CalculatorTest calcTest = new CalculatorTest();
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        int num1;

        // Основной цикл
        while (flag) {
            // Получаем первое число
            System.out.print("\nВведите первое число: ");
            num1 = scan.nextInt();

            // Получаем и проверяем знак операции
            scan.nextLine();
            boolean signFlag = false;
            char sign = 0;
            while (!signFlag) {
                System.out.print("\nВведите знак операции (+, -, *, /, ^, %): ");
                sign = scan.nextLine().charAt(0);
                signFlag = myCalculator.checkSign(sign);
            }

            // Получаем второе число
            int num2 = 0;
            do {
                System.out.print("\nВведите второе число: ");
                num2 = scan.nextInt();
            } while (!calcTest.checkZero(num2, sign));

            // Вычисляем выражение и выводим результат
            int result = myCalculator.runCalculate(num1, num2, sign);
            if (num2 < 0) {
                System.out.printf("%d %s %d = %.2f%n", num1, sign, num2, (double) 1 / result);
            } else {
                System.out.printf("%d %s %d = %d%n", num1, sign, num2, result);
            }

            // Продолжаем, или как ?
            scan.nextLine();
            String choice = null;
            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                choice = scan.nextLine();
                if (choice.equals("no")) {
                    flag = false;
                }
            } while (!(choice.equals("yes") || choice.equals("no")));
        }
    }

    public boolean checkZero(int checkedNum, char sign) {
        if (checkedNum == 0 && sign == '/') {
            System.out.println("Ошибка: деление на ноль запрещено");
            return false;
        }
        return true;
    }
}