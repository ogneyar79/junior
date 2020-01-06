package calculator;

import java.util.ArrayList;

/**
 * Class for work with calculator.
 */
public class CalculatorHandler {


    /**
     * Field Interface object major class.
     */
    final private ICalculatorConsole calc;
    /**
     * Field of objects for checking validation Operation.
     */
    final private ValidateOperator validation;

    /**
     * Field objects for console input.
     */
    private final ConsolReaderForCalc consolReaderForCalc;

    /**
     * Field fo saving results operation.
     */
    private final ArrayList<Double> resultsCalculation = new ArrayList<Double>();


    /**
     * Constructor our class.
     *
     * @param calc                ICalculatorConsole.
     * @param validation          ValidateOperator.
     * @param consolReaderForCalc ConsolReaderForCalc
     */
    public CalculatorHandler(final ICalculatorConsole calc, final ValidateOperator validation, ConsolReaderForCalc consolReaderForCalc) {
        this.calc = calc;
        this.validation = validation;
        this.consolReaderForCalc = consolReaderForCalc;
    }

    /**
     * Function for work calculator.
     *
     * @return result Double.
     */
    public double workWithCalculator() {
        ICalculatorConsole calc = this.getCalc();
        double result = 0;
        double numFirst = consolReaderForCalc.getDouble();
        char operation = consolReaderForCalc.getOperation();
        double numSecond = consolReaderForCalc.getDouble();
        if (validation.checkOperation(operation)) {
            result = calc.calc(numFirst, numSecond, operation);
            this.resultsCalculation.add(result);
            return result;
        }
        System.out.println(" Incorrect");
        return result;
    }


    /**
     * Function getter.
     *
     * @return results ArrayList.
     */
    public ArrayList<Double> getResultsCalculation() {
        return resultsCalculation;
    }

    /**
     * Function getting Last result our Calculation.
     *
     * @return double result.
     */
    public double getLastResaltCalculation() {
        return this.resultsCalculation.get(this.resultsCalculation.size() - 1);
    }

    /**
     * Function getter ICalculatorConsole objects.
     *
     * @return calc ICalculatorConsole.
     */
    public ICalculatorConsole getCalc() {
        return calc;
    }
}
