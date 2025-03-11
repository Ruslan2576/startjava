import java.util.Scanner;

public class Calculator {
    
    private Scanner scan;
    private int num1;
    private int num2;
    private char sign;

    public void inputMathExpression() {
        Calculator c = new Calculator();
        scan = new Scanner(System.in);
        System.out.print("\nВведите первое число: ");
        num1 = scan.nextInt();
        
        scan.nextLine();
        while (sign == 0) {
            System.out.print("\nВведите знак операции (+, -, *, /, ^, %): ");
            sign = checkSign(scan.nextLine().charAt(0));
        }

        if (sign == '/') {
            while (num2 == 0) {
                System.out.print("\nВведите второе число: ");
                num2 = scan.nextInt();
                checkZero(num2);
            }
        } else {
            System.out.print("\nВведите второе число: ");
            num2 = scan.nextInt();
        }
    }

    public void runCulculate() {
        int result = 0;
        if (sign == '+') {
            result = num1 + num2;
        } else if (sign == '-') {
            result = num1 - num2;
        } else if (sign == '*') {
            result = num1 * num2;
        } else if (sign == '/') {
            result = num1 / num2;
        } else if (sign == '%') {
            result = num1 % num2;
        } else if (sign == '^') {
            result = 1;
            int tmp = num2;
            if (num2 < 0) {
                tmp = -num2;
            }
            for (int i = 0; i < tmp; i++) {
                result *= num1;
            }
        }

        if (num2 < 0) {
            System.out.printf("%d %s %d = %f%n", num1, sign, num2, (double) 1 / result);
        } else {
            System.out.printf("%d %s %d = %d%n", num1, sign, num2, result);
        }
        sign = 0;
        num1 = 0;
        num2 = 0;
    }

    public boolean continueCalculation() {
        scan.nextLine();
        String choice = null;
        boolean flag = false;
        do {
            System.out.println("Хотите продолжить вычисления? [yes/no]:");
            choice = scan.nextLine();
            if (choice.equals("yes")) {
                flag = true;
            }
        } while (!(choice.equals("yes") || choice.equals("no")));
        return flag;
    }

    private char checkSign(char sign) {
        switch (sign) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
            case '^':
                this.sign = sign;
                break;
            default:
                System.out.printf("Ошибка: операция '%c' не поддерживается%n", sign);
        }
        return this.sign;
    }

    private int checkZero(int checkedNum) {
        if (checkedNum != 0) {
            num2 = checkedNum;
        } else {
            System.out.println("Ошибка: деление на ноль запрещено");
        }
        return num2;
    }
}