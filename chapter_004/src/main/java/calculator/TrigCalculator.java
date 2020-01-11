package calculator;

/**
 * Class for make operation with trig function.
 */
public class TrigCalculator extends CalculatorM {

    /**
     * Field that show name our class for use other classes.
     */
    private static final String NAME = "TRIG";

    /**
     * Field that show result our calculation .
     */
    double result = 0;

    /**
     * Field that show us one operand .
     */
    private double num1 = 0;

    /**
     * Field that show us other operand if that exist.
     */
    private double num2 = 0;

    /**
     * Field that show us one operator.
     */
    private String operator = "";

    /**
     * Field object that we use for read user's console.
     */
    final private ConsoleReadTrig consoleReader;

    /**
     * Field object that we use for check user's console and operator.
     */
    final private ValidateOperator validation;

    /**
     * Create default constructor.
     */
    public TrigCalculator(ConsoleReadTrig consoleReader, ValidateOperator validation) {
        this.consoleReader = consoleReader;
        this.validation = validation;
    }

    /**
     * function calculating trig with angle in radians.
     *
     * @param numFirst   double, this angle in radians.
     * @param simvolTRig String, this operator specific trig function like sin, cos, tan, and i.t.c.,
     *                   usually it's user's input.
     * @return result double
     */
    public double calc(double numFirst, String simvolTRig) {
        double result = 0;
        return TrigComands.actions.get(simvolTRig).apply(simvolTRig, numFirst);
    }

    /**
     * function calculating trig with angle in radians.
     * usually it's user's input about angle and operator specific trig function.
     * angle Double input , operator String input.
     *
     * @return result double
     */
    double calc() {
        double result = 0;
        String operation = this.consoleReader.getOperation();
        Double numFirst = this.consoleReader.getDouble();
        if (validation.checkOperationTrig(operation)) {
            result = TrigComands.actions.get(operation).apply(operation, numFirst);
        }
        return result;
    }
    /**
     * Procedure calculating trig aggregate some our function calculating and checking.
     *
     * result calculating we write to variable result.
     */
    public void startConsoleCalc() {
        double num1 = this.consoleReader.getDouble();
        String operation = this.consoleReader.getOperation();
        this.setNum1(num1);
        this.setOperator(operation);
        if (validation.checkOperationTrig(operation)) {
            this.result = this.calc(num1, operation);
        } else {
            System.out.println("Result is not saccesed in, invalid operation" + operation);
        }
    }

    @Override
    public Double getResult() {
        return result;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public static String getNAME() {
        return NAME;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getOperator() {
        return operator;
    }
}
