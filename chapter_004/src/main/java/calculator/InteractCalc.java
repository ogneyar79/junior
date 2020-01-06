package calculator;

/**
 * Class for make operation with numbers.
 */
public class InteractCalc implements ICalculatorConsole {

    /**
     * Field object CalculatorElementary that we use at our operation.
     */
    final CalculatorElementary calculatorElementary;

    /**
     * Constructor our class.
     *
     * @param calculatorElementary CalculatorElementary.
     */
    public InteractCalc(final CalculatorElementary calculatorElementary) {
        this.calculatorElementary = calculatorElementary;

    }

    /**
     * Function for calculation.
     *
     * @param num1      double.
     * @param num2      double.
     * @param operation char.
     * @return result double.
     */
    public double calc(double num1, double num2, char operation) {
        double result = 0;
        switch (operation) {
            case '+':
                this.calculatorElementary.add(num1, num2);
                result = this.calculatorElementary.getResult();
                break;
            case '-':
                this.calculatorElementary.subtract(num1, num2);
                result = this.calculatorElementary.getResult();
                break;
            case '*':
                this.calculatorElementary.multiply(num1, num2);
                result = this.calculatorElementary.getResult();
                break;
            case '/':
                this.calculatorElementary.div(num1, num2);
                result = this.calculatorElementary.getResult();
                break;
            default:
                break;
        }
        return result;
    }
}
