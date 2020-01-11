package calculator;

/**
 * Abstract Class for creating different realisation 0f calculator.
 */
public abstract class CalculatorM {

    char operation;
    double numFirst;
    double result;

    static String name;


    /**
     * every object  our class must have method return result calculation.
     */
    abstract double calc();

    /**
     * every object  our class must have method aggregate stages calculating.
     */
    abstract public void startConsoleCalc();

    /**
     * every object  our class must have method return result Calculation.
     */
    abstract Double getResult();


    public void setOperation(char operation) {
        this.operation = operation;
    }

    public void setNumFirst(int numFirst) {
        this.numFirst = numFirst;
    }

    public void setName(String name) {
        this.name = name;
    }
}
