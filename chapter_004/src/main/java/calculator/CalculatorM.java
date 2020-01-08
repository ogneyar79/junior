package calculator;


public abstract class CalculatorM {
    char operation;
    int numFirst;


    static String name;

    int result;

    abstract double calc();
     abstract public void startConsoleCalc();

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
