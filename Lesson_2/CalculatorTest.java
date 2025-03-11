
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();
        boolean flag = true;
        while (flag) {
            myCalculator.inputMathExpression();
            myCalculator.runCulculate();
            flag = myCalculator.continueCalculation();
        }
    }
}