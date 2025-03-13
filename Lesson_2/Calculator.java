public class Calculator {
    public int calculate(int num1, int num2, char sign) {
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
            num2 = Math.abs(num2);
            for (int i = 0; i < num2; i++) {
                result *= num1;
            }
        }
        return result;
    }
}