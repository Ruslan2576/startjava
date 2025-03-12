public class Calculator {
    public int runCalculate(int num1, int num2, char sign) {
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
        return result;
    }

    public boolean checkSign(char sign) {
        switch (sign) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
            case '^':
                return true;
            default:
                System.out.printf("Ошибка: операция '%c' не поддерживается%n", sign);
        }
        return false;
    }
}