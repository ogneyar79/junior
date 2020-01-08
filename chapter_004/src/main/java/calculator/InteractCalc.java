package calculator;

/**
 * Class for make operation with numbers.
 */
public class InteractCalc extends CalculatorM {

    private static final String NAME = "SIMPLEC";

    private double result;

    /**
     * Field object CalculatorElementary that we use at our operation.
     */
    final CalculatorElementary calculatorElementary;

    double num2;
    double numFirst;

    ConsolReaderForCalc consolReader;

    final ValidateOperator validation;

    public InteractCalc(final CalculatorElementary calculatorElementary, ConsolReaderForCalc consolReader, ValidateOperator validation) {
        this.calculatorElementary = calculatorElementary;
        this.consolReader = consolReader;
        this.validation = validation;
    }

    public void startConsoleCalc() {
        double num1 = this.consolReader.getDouble();
        double num2 = this.consolReader.getDouble();
        this.setNumFirst(num1);
        this.setNum2(num2);
        char operation = this.consolReader.getOperation();
        if (validation.checkOperation(operation)) {
            this.result = this.calc(num1, num2, operation);
        } else {
            System.out.println("Result is not saccesed in, invalid operation" + operation);
        }
    }

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

    double calc() {
        double result = 0;
        switch (operation) {
            case '+':
                this.calculatorElementary.add(this.numFirst, this.num2);
                result = this.calculatorElementary.getResult();
                break;
            case '-':
                this.calculatorElementary.subtract(this.numFirst, this.num2);
                result = this.calculatorElementary.getResult();
                break;
            case '*':
                this.calculatorElementary.multiply(this.numFirst, this.num2);
                result = this.calculatorElementary.getResult();
                break;
            case '/':
                this.calculatorElementary.div(this.numFirst, this.num2);
                result = this.calculatorElementary.getResult();
                break;
            default:
                break;
        }

        return result;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setNumFirst(double numFirst) {
        this.numFirst = numFirst;
    }

    public Double getResult() {
        return this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InteractCalc that = (InteractCalc) o;

        if (Double.compare(that.result, result) != 0) return false;
        if (Double.compare(that.num2, num2) != 0) return false;
        if (Double.compare(that.numFirst, numFirst) != 0) return false;
        if (calculatorElementary != null ? !calculatorElementary.equals(that.calculatorElementary) : that.calculatorElementary != null)
            return false;
        if (consolReader != null ? !consolReader.equals(that.consolReader) : that.consolReader != null) return false;
        return validation != null ? validation.equals(that.validation) : that.validation == null;
    }

    @Override
    public int hashCode() {
        int result = calculatorElementary != null ? calculatorElementary.hashCode() : 0;
        result = 31 * result + (consolReader != null ? consolReader.hashCode() : 0);
        result = 31 * result + (validation != null ? validation.hashCode() : 0);
        return result;
    }

    public static String getNAME() {
        return NAME;
    }
}
